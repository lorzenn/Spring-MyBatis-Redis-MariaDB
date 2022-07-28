package com.example.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBook(Long id) {
        return bookMapper.findBook(id);
    }

    @Override
    public void createBook(Book book) {
        new ResponseEntity<>(bookMapper.createBook(book), HttpStatus.CREATED);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public int deleteBook(Long id) {
        return bookMapper.deleteBook(id);
    }
}
