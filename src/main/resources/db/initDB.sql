DROP TABLE IF EXISTS person;
CREATE TABLE person
(
    id      INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name    VARCHAR NOT NULL,
    age     INT CHECK (age > 0),
    email   VARCHAR UNIQUE
);