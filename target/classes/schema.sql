DROP TABLE IF EXISTS author;

DROP SEQUENCE IF EXISTS s_author_id;
CREATE SEQUENCE s_author_id START WITH 1;

CREATE TABLE author (
  id INT NOT NULL,
  first_name VARCHAR(50),
  last_name VARCHAR(50) NOT NULL,
  date_of_birth DATE,
  address VARCHAR(50),
  CONSTRAINT pk_author PRIMARY KEY (ID)
);
