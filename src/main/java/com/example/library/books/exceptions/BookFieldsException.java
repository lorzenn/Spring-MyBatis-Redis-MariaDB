package com.example.library.books.exceptions;

public class BookFieldsException extends RuntimeException{

    public BookFieldsException(){
        super("Fields should not be null, empty, or exceed 50 characters!");
    }

}
