package com.example.library.books;


import com.example.library.books.exceptions.BookIdAlreadyExistException;
import com.example.library.books.exceptions.BookIdNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1")
@EnableCaching
public class BookController {

    private BookService bookService;

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        if( bookRepository.findAllBooks() != null){
            return bookService.findAllBooks();
        } else {
            bookRepository.insertAllBooksToCache();
        }
        return bookRepository.getAllBooksToCache();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book book = bookService.findBook(id);
        if(book == null) {
            throw new BookIdNotExistException();
        } else {
            bookRepository.insertAllBooksToCache(id);
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public void createBook(@RequestBody @Valid Book book){
        if(bookService.findBook(book.getId()) == null) {
            bookService.createBook(book);
            bookService.findBook(book.getId());
        } else
        {
            throw new BookIdAlreadyExistException();
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody @Valid Book book){
        if(bookService.updateBook(
                new Book(id,
                        book.getName(),
                        book.getAuthor())) == 0)
        {
            throw new BookIdNotExistException();
        }
        return ResponseEntity.ok(bookService.findBook(id));
    }

    @DeleteMapping("/books/{id}")
    @CacheEvict(key = "#id", value = "Book")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Long id){
        if(bookService.deleteBook(id) == 0)
        {
            throw new BookIdNotExistException();
        }
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
