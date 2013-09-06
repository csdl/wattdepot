# This script backs up the following into a .tar.gz archive:
# 1. A plain text dump of the wattdepot database
# 2. /home/wattdepot/.wattdepot/
# 3. /home/wattdepot/wattdepot-2.2.1/
# Notes:
# Backups are stored in the /wattdepot-backups directory.
# Backup names are timestamped to the second.
# The PGPASSWORD environment variable must be set to the password of 
# PostgreSQL's "wattdepot" user for this script to work correctly.

cd /wattdepot-backups
export NEW_WATTDEPOT_BACKUP="wattdepot_backup_$(date +"%Y-%m-%d_%H_%M_%S")"
echo "Creating backup: /wattdepot-backups/$NEW_WATTDEPOT_BACKUP"
mkdir $NEW_WATTDEPOT_BACKUP
cd $NEW_WATTDEPOT_BACKUP
touch plaintext_backup.dump
/usr/pgsql-9.1/bin/pg_dump -Fp --no-acl --no-owner -h localhost -U wattdepot wattdepot > plaintext_backup.dump
cp -R /home/wattdepot/.wattdepot /wattdepot-backups/$NEW_WATTDEPOT_BACKUP/.wattdepot
cp -R /home/wattdepot/wattdepot-2.2.1 /wattdepot-backups/$NEW_WATTDEPOT_BACKUP/wattdepot-2.2.1
cd ../
tar -czf $NEW_WATTDEPOT_BACKUP.tar.gz ./$NEW_WATTDEPOT_BACKUP/
rm -rf $NEW_WATTDEPOT_BACKUP
echo "Backup compressed and stored at /wattdepot-backups/$NEW_WATTDEPOT_BACKUP.tar.gz"
unset NEW_WATTDEPOT_BACKUP
