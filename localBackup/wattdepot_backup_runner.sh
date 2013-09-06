# A wrapper script for running wattdepot_backup_script.sh
# with no external input (e.g., as a cron job).
# Replace "PASSWORD" with the PostgreSQL password 
# of PostgreSQL's 'wattdepot' user.

export PGPASSWORD="PASSWORD"
sh ./wattdepot_backup_script.sh --delete-auto
unset PGPASSWORD
