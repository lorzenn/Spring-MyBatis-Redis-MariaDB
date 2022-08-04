package com.example.library.books.mapper;

import com.example.library.books.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * This class has the @Mapper annotation which is the one responsible for checking the database.
 */
@Mapper
public interface BookMapper {

    String SELECT_ALL_BOOKS = "SELECT * FROM books";
    String SELECT_BOOKS_BY_ID = "SELECT * FROM books WHERE id = #{id}";
    String CREATE_BOOK = "INSERT INTO books(id, name, author, email) VALUES(#{id}, #{name}, #{author}, #{email})";
    String UPDATE_BOOK_BY_ID = "UPDATE books SET name=#{name}, author=#{author}, email=#{email} WHERE id=#{id}";
    String DELETE_BOOK_BY_ID = "DELETE FROM books WHERE id = #{id}";

    @Select(SELECT_ALL_BOOKS)
    List<Book> findAllBooks();
    @Select(SELECT_BOOKS_BY_ID)
    Book findBook(Long id);
    @Insert(CREATE_BOOK)
    int createBook(Book book);
    @Update(UPDATE_BOOK_BY_ID)
    int updateBook(Book book);
    @Delete(DELETE_BOOK_BY_ID)
    int deleteBook(Long id);

}
