package com.example.library.books.exceptions;
/**
 * A class that holds the message for BookIdNotFoundException
 */
public class BookIdNotFoundException extends RuntimeException{
    public BookIdNotFoundException(Long id)
    {
        super("Book ID [" + id + "] Not Found");
    }
}
