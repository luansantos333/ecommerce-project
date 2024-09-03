package com.projetoloja.lojavirtual.service.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException() {
    }


    public DatabaseException(String message) {
        super(message);
    }
}
