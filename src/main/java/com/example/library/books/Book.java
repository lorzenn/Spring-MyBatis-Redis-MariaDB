package com.example.library.books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
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


}
