

CREATE DATABASE `library`;
USE library;

create table books
(
    id integer not null AUTO_INCREMENT,
    name varchar(255) not null,
    author varchar(255) not null,
    primary key(id)
);

INSERT INTO books(name, author) VALUES("Book name 1", "Lorenz");

//    log.info("Inserting -> {}", bookRepository.createBook(new Book("Book 1", "Fadatare",LocalDate.now())));
//        log.info("Inserting -> {}", bookRepository.createBook(new Book("Book 2", "Cena", LocalDate.now())));
//        log.info("Inserting -> {}", bookRepository.createBook(new Book("Book 3", "stark", LocalDate.now())));
//
//        log.info("Employee id 10011 -> {}", bookRepository.findBook(1L));
//
//        log.info("Update 10003 -> {}", bookRepository.updateBook(new Book(10011L, "ram", "Stark", "ramesh123@gmail.com")));
//
//        bookRepository.deleteBook(10013L);
//
//        log.info("All Books -> {}", bookRepository.findAllBooks());