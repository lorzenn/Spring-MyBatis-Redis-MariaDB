package com.example.library.books;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    Book findBook(Long id);
    void createBook(Book book);
    int updateBook(Book book);
    int deleteBook(Long id);

}
