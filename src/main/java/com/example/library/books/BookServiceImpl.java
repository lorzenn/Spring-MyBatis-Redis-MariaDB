package com.example.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public Book findBook(Long id) {
        return bookRepository.findBook(id);
    }

    @Override
    public void createBook(Book book) {
        new ResponseEntity<>(bookRepository.createBook(book), HttpStatus.CREATED);
    }

    @Override
    public int updateBook(Book book) {
        return bookRepository.updateBook(book);
    }

    @Override
    public int deleteBook(Long id) {
        return bookRepository.deleteBook(id);
    }
}
