package com.example.library.books.exceptions;
/**
 * A class that holds the message for BookIdAlreadyExistException
 */
public class BookIdAlreadyExistException extends RuntimeException{
    public BookIdAlreadyExistException(Long id) {
        super("Book ID [" + id + "] Already Exist");
    }
}
