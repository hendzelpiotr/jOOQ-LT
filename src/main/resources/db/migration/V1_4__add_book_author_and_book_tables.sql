CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  date_of_publication TIMESTAMP,
  name VARCHAR(1000) NOT NULL,
  price INTEGER NOT NULL
);

CREATE TABLE book_author (
  id SERIAL PRIMARY KEY,
  author_id INTEGER REFERENCES author(id),
  book_id INTEGER REFERENCES book(id)
);

INSERT INTO book (date_of_publication, name, price) VALUES ('2005-10-24', 'How to live with ORM', 99);
INSERT INTO book (date_of_publication, name, price) VALUES ('2015-10-24', 'How to live without ORM', 59);
INSERT INTO book (date_of_publication, name, price) VALUES ('2017-11-24', 'How to live with book about cats', 19);
INSERT INTO book (date_of_publication, name, price) VALUES ('2000-09-24', 'Clean something', 519);
INSERT INTO book (date_of_publication, name, price) VALUES ('966-10-04', 'Polish baptism', 59);

INSERT INTO book_author (author_id, book_id) VALUES (1,1);
INSERT INTO book_author (author_id, book_id) VALUES (1,2);
INSERT INTO book_author (author_id, book_id) VALUES (2,3);
INSERT INTO book_author (author_id, book_id) VALUES (3,4);
INSERT INTO book_author (author_id, book_id) VALUES (5,5);