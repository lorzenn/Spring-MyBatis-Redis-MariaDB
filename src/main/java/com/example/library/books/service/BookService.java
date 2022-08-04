package com.example.library.books.service;

import com.example.library.books.model.Book;

import java.util.List;
/**
 * This interface holds all the methods to be implemented in BookServiceImpl
 */
public interface BookService {

    boolean saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    boolean deleteUser(Long id);
    boolean updateBook(Long id, Book book);

}
