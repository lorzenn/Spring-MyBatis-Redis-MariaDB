package com.example.library.books.repository;

import com.example.library.books.model.Book;

import java.util.List;

/**
 * This interface holds all the methods to be implemented in BookDaoImpl
 */
public interface BookDao {

    boolean saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    boolean deleteBook(Long id);
    boolean updateBook(Book book);

}
