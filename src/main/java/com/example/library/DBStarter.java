package com.example.library;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;

public class DBStarter {
    public static void main(String[] args) throws ManagedProcessException {
        DB db = DB.newEmbeddedDB(3306);
        db.start();
        db.source("books.sql");
    }


}
