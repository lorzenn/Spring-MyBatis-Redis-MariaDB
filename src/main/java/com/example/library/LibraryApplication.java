package com.example.library;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) throws ManagedProcessException {
        DB db = DB.newEmbeddedDB(3306);
        db.start();
        db.source("books.sql");
        SpringApplication.run(LibraryApplication.class, args);

    }


}
