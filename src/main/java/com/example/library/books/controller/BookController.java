package com.example.library.books.controller;

import com.example.library.books.model.Book;
import com.example.library.books.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * This class holds the endpoints of the CRUD operations
 * @Endpoints
 * POST - localhost:8080/library/book
 * GET - localhost:8080/library/book AND localhost:8080/library/book/{id}
 * PUT - localhost:8080/library/book/{id}
 * DELETE - localhost:8080/library/book/{id}
 */
@RestController
@RequestMapping("/library")
@EnableCaching
@Slf4j
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity<String> saveBook(@RequestBody @Valid Book book) {
        bookService.saveBook(book);
        return ResponseEntity.ok("A new book was created successfully!!!");
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/book/{id}")
    @CacheEvict(key = "#id", value = "Book")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id){
        bookService.deleteUser(id);
        return ResponseEntity.ok("Book ID [" + id + "] Deleted Successfully!!!");
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody @Valid Book book) {
        bookService.updateBook(id,book);
        return ResponseEntity.ok("Book ID ["+id+"] Updated Successfully!!!");
    }

}
