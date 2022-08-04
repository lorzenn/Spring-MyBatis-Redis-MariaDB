package com.example.library.books.repository.impl;

import com.example.library.books.mapper.BookMapper;
import com.example.library.books.model.Book;
import com.example.library.books.repository.BookDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * This class is the implementation class of the interface BookDao
 * This class is responsible for saving the data to cache
 */
@Repository
@Slf4j
public class BookDaoImpl implements BookDao {

    private static final String KEY = "BOOKS";

    private final RedisTemplate redisTemplate;
    private final BookMapper bookMapper;

    public BookDaoImpl(RedisTemplate redisTemplate, BookMapper bookMapper) {
        this.redisTemplate = redisTemplate;
        this.bookMapper = bookMapper;
    }

    @Override
    public boolean saveBook(Book book) {
        bookMapper.createBook(book);
        return true;
    }

    @Override
    public List<Book> getAllBooks() {
        redisTemplate.opsForHash().values(KEY);
        return bookMapper.findAllBooks();
    }

    @Override
    public Book getBookById(Long id) {
        redisTemplate.opsForHash().get(KEY, id);
        return bookMapper.findBook(id);
    }

    @Override
    public boolean deleteBook(Long id) {
        redisTemplate.opsForHash().delete(KEY, id);
        bookMapper.deleteBook(id);
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        redisTemplate.opsForHash().values(KEY);
        bookMapper.updateBook(book);
        return true;
    }

}
