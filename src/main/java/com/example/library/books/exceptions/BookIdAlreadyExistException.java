package com.example.library.books.exceptions;

public class BookIdAlreadyExistException extends RuntimeException{

    public BookIdAlreadyExistException(){
        super("Book ID already exists!");
    }

}
