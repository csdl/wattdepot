# Notes:
# 1. Backups are stored in the /wattdepot-backups directory.
#    They are .tar.gz archives that contain:
#    - A plain text dump of the wattdepot database
#    - /home/wattdepot/.wattdepot/
#    - /home/wattdepot/wattdepot-2.2.1/
# 2. Backup names are timestamped to the second.
# 3. Backups taken on the first day of the month are copied to 
#    a new monthly backup in the /wattdepot-backups/monthly/ directory.
# 4. The script deletes any daily backups more than 7 days 
#    (604800 seconds) old. It asks the user before doing this. 
# 5. Run the script with --delete-auto to delete the old backups 
#    automatically.
# 6. The PGPASSWORD environment variable must be set to the password of 
#    PostgreSQL's "wattdepot" user for this script to work correctly.
#    If PGPASSWORD is not set, the user will be prompted for a password
#    when it runs.

cd /wattdepot-backups
export BACKUPTIME=$(date +"%Y-%m-%d_%H_%M_%S")
export NEW_DAILY_BACKUP="wattdepot_backup_$BACKUPTIME"
echo "Creating backup: /wattdepot-backups/$NEW_DAILY_BACKUP"
mkdir $NEW_DAILY_BACKUP
cd $NEW_DAILY_BACKUP
touch plaintext_backup.dump
/usr/pgsql-9.1/bin/pg_dump -Fp --no-acl --no-owner -h localhost -U wattdepot wattdepot > plaintext_backup.dump
cp -R /home/wattdepot/.wattdepot /wattdepot-backups/$NEW_DAILY_BACKUP/.wattdepot
cp -R /home/wattdepot/wattdepot-2.2.1 /wattdepot-backups/$NEW_DAILY_BACKUP/wattdepot-2.2.1
cd ../
tar -czf $NEW_DAILY_BACKUP.tar.gz ./$NEW_DAILY_BACKUP/
rm -rf $NEW_DAILY_BACKUP
echo "Backup compressed and stored at /wattdepot-backups/$NEW_DAILY_BACKUP.tar.gz"

# If it is the first day of the month, copy the backup to /wattdepot-backups/monthly/
if [ $(date +"%d") = "01" ];
    then
        export NEW_MONTHLY_BACKUP="wattdepot_monthly_backup_$BACKUPTIME.tar.gz"
        cp $NEW_DAILY_BACKUP.tar.gz /wattdepot-backups/monthly/$NEW_MONTHLY_BACKUP
        echo "Monthly backup created at /wattdepot-backups/monthly/$NEW_MONTHLY_BACKUP"
        unset NEW_MONTHLY_BACKUP
fi

unset NEW_DAILY_BACKUP
unset BACKUPTIME

# Remove old daily backups
cd /wattdepot-backups
export CURRENT_TIME=$(date +%s)
echo "Removing daily backups more than 7 days (604800 seconds) old."
echo "The following backups will be deleted:"
for FILE in $(find ./*.tar.gz -maxdepth 1 -type f); do
    export CURRENT_FILE_TIME=$(stat -c %Z $FILE)
    export CURRENT_FILE_AGE=$(expr $CURRENT_TIME - $CURRENT_FILE_TIME)
    if [ $CURRENT_FILE_AGE -gt 604800 ];
        then
            echo "$FILE"
    fi
    unset CURRENT_FILE_TIME
    unset CURRENT_FILE_AGE
done

# If the --delete-auto flag is set, don't ask the user and 
# just delete the old backups automatically. 
if [ $1 = "--delete-auto" ];
  then
      export DO_DELETE_BACKUPS="Yes"
  else
      export DO_DELETE_BACKUPS="Foo"
fi

while [ $DO_DELETE_BACKUPS != "Yes" -a $DO_DELETE_BACKUPS != "No" ];
do
    echo "Delete these backups? This operation cannot be undone. [Yes/No]"
    read DO_DELETE_BACKUPS
    if [ $DO_DELETE_BACKUPS = "Yes" ];
        then
            echo "Continuing..."
        else
            if [ $DO_DELETE_BACKUPS = "No" ];
                then
                    echo "Backup process completed without removing old backups."
                    unset $DO_DELETE_BACKUPS
                    exit
            fi
    fi
done
unset $DO_DELETE_BACKUPS

echo "Removing daily backups more than 7 days (604800 seconds) old."
for FILE in $(find ./*.tar.gz -maxdepth 1 -type f); do
    CURRENT_FILE_TIME=$(stat -c %Z $FILE)
    CURRENT_FILE_AGE=$(expr $CURRENT_TIME - $CURRENT_FILE_TIME)
    if [ $CURRENT_FILE_AGE -gt 604800 ];
        then
            rm $FILE
            echo "Deleted daily backup archive $FILE."
    fi
    unset CURRENT_FILE_TIME
    unset CURRENT_FILE_AGE
done 
echo "Removal of old daily backups is complete."
