CREATE DATABASE `library`;
USE library;

create table books
(
    id integer not null AUTO_INCREMENT,
    name varchar(255) not null,
    author varchar(255) not null,
    email varchar(255) not null,
    primary key(id)
);
