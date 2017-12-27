create role "ltuser" with login password 'admin123';

create database "lt_db" owner "ltuser" encoding 'UTF8' template template0;