package com.example.library.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
/**
 * This class contains the entity of the Book
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("BOOKS")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max=50)
    @NotBlank
    @NotEmpty
    @NotNull(message = "Book name cannot be null!")
    private String name;

    @Length(max=50)
    @NotBlank
    @NotEmpty
    @NotNull(message = "Book author cannot be null!")
    private String author;

    @Length(max=50)
    @NotBlank
    @NotEmpty
    @NotNull
    private String email;

    public Book(String name, String author, String email) {
        this.name = name;
        this.author = author;
        this.email = email;
    }

}
