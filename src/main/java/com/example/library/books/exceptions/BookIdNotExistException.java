package com.example.library.books.exceptions;

public class BookIdNotExistException extends RuntimeException{

    public BookIdNotExistException(){
        super("Book ID does not exist!");
    }

}
