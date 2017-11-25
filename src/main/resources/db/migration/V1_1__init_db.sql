--CREATE ROLE ltuser WITH LOGIN PASSWORD 'admin123'
--create database "lt_db" owner "ltuser" encoding 'UTF8' template template0;

CREATE TABLE author (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50) NOT NULL,
  date_of_birth timestamp,
  address VARCHAR(50)
);

INSERT INTO author
(first_name, last_name, date_of_birth, address)
VALUES ('George', 'Orwell', '1903-06-25', 'Rzeszow 312');

INSERT INTO author
(first_name, last_name, date_of_birth, address)
VALUES ('Paulo', 'Coelho', '1947-08-24', 'Krakow 13');


CREATE FUNCTION sum(integer, integer) RETURNS integer
AS 'select $1 + $2;'
LANGUAGE SQL
IMMUTABLE
RETURNS NULL ON NULL INPUT;