package com.example.library.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private static final String HASH_KEY = "Book";
    private static final String GROUP_KEY = "All Book";

    private RedisTemplate template;
    private BookMapper bookMapper;
    private HashOperations hashOperations;


    public BookRepository(RedisTemplate template, BookMapper bookMapper) {
        this.template = template;
        this.bookMapper = bookMapper;
        this.hashOperations = template.opsForHash();
    }

    public List<Book> findAllBooks(){
        return hashOperations.values(HASH_KEY);
//        return template.opsForHash().values(HASH_KEY);
    }

    public Book findBook(Long id){
        return (Book) hashOperations.get(HASH_KEY, id);
//        return (Book) template.opsForHash().get(HASH_KEY, id);
    }

    public Book createBook(Book book){
        hashOperations.put(HASH_KEY, book.getId(), book);
//        template.opsForHash().put(HASH_KEY, book.getId(), book);
        return book;
    }

    public String deleteBook(Long id){
        hashOperations.delete(HASH_KEY, id);
//        template.opsForHash().delete(HASH_KEY, id);
        return "Book Removed";
    }

    public void insertAllBooksToCache(){
        hashOperations.put(HASH_KEY, GROUP_KEY, bookMapper.findAllBooks());
//        template.opsForHash().put(HASH_KEY, GROUP_KEY, bookMapper.findAllBooks());

    }

    public void insertAllBooksToCache(Long id){
        hashOperations.put(HASH_KEY, GROUP_KEY, bookMapper.findBook(id));
//        template.opsForHash().put(HASH_KEY, GROUP_KEY, bookMapper.findAllBooks());

    }

    public List<Book> getAllBooksToCache(){
        return (List<Book>) hashOperations.get(HASH_KEY, GROUP_KEY);
//        return (List<Book>) template.opsForHash().get(HASH_KEY, GROUP_KEY);
    }
}
