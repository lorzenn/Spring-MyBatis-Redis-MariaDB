package com.example.library.books.service.impl;

import com.example.library.books.exceptions.BookIdAlreadyExistException;
import com.example.library.books.exceptions.BookIdNotFoundException;
import com.example.library.books.mapper.BookMapper;
import com.example.library.books.model.Book;
import com.example.library.books.repository.BookDao;
import com.example.library.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * This class is the implementation class of the interface BookService
 * This class is responsible for the business logics and exceptions to be thrown
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookDao bookDao, BookMapper bookMapper) {
        this.bookDao = bookDao;
        this.bookMapper = bookMapper;
    }

    @Override
    public boolean saveBook(Book book) {
        if (bookMapper.findBook(book.getId()) == null) {
            bookDao.saveBook(book);
            return true;
        } else {
            throw new BookIdAlreadyExistException(book.getId());
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(Long id) {
        Book book = bookDao.getBookById(id);
        if(book==null)
        {
            throw new BookIdNotFoundException(id);
        }
        return book;
    }

    @Override
    public boolean deleteUser(Long id) {
        Book book = bookMapper.findBook(id);
        if(book == null)
        {
            throw new BookIdNotFoundException(id);
        }
        return bookDao.deleteBook(id);
    }

    @Override
    public boolean updateBook(Long id, Book book) {
        book.setId(id);
        if(bookMapper.updateBook(book)==0)
        {
            throw new BookIdNotFoundException(id);
        }
        return bookDao.updateBook(book);
    }

}
