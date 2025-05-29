# Prerequisites
#
<<<<<<< HEAD
- JDK 11 
- Maven 3 
- MySQL 8
=======
- JDK 11 or later
- Maven 3 or later
- MySQL 5.6 or later
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab

# Technologies 
- Spring MVC
- Spring Security
- Spring Data JPA
- Maven
- JSP
<<<<<<< HEAD
- Tomcat
- MySQL
- Memcached
- Rabbitmq
- ElasticSearch
# Database
Here,we used Mysql DB 
sql dump file:
- /src/main/resources/db_backup.sql
- db_backup.sql file is a mysql dump file.we have to import this dump to mysql db server
- > mysql -u <user_name> -p accounts < db_backup.sql
=======
- MySQL
# Database
Here,we used Mysql DB 
MSQL DB Installation Steps for Linux ubuntu 14.04:
- $ sudo apt-get update
- $ sudo apt-get install mysql-server

Then look for the file :
- /src/main/resources/accountsdb
- accountsdb.sql file is a mysql dump file.we have to import this dump to mysql db server
- > mysql -u <user_name> -p accounts < accountsdb.sql
>>>>>>> cdbce970c7a456416720070802fc86f3e3e63cab


