package com.projetoloja.lojavirtual.service.exceptions;

public class ForbidenException extends RuntimeException{

    public ForbidenException() {
    }

    public ForbidenException(String message) {
        super(message);
    }
}
