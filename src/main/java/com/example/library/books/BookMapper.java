package com.example.library.books;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    String SELECT_ALL_BOOKS = "select * from books";
    String SELECT_BOOKS_BY_ID = "SELECT * FROM books WHERE id = #{id}";
    String CREATE_BOOK = "INSERT INTO books(id, name, author) VALUES(#{id}, #{name}, #{author})";
    String UPDATE_BOOK_BY_ID = "UPDATE books set name=#{name}, author=#{author} where id=#{id}";
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
