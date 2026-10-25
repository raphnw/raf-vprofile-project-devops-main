# MySQL 8.4 (LTS) with the vprofile "accounts" database preloaded.
# Set the root password when the container runs, not in the image:
#   docker run -e MYSQL_ROOT_PASSWORD=vprodbpass ...
FROM mysql:8.4
LABEL project="raf-vprofile" author="Raf"

ENV MYSQL_DATABASE=accounts

# Scripts in this folder run once, the first time the database starts
COPY db_backup.sql /docker-entrypoint-initdb.d/db_backup.sql
