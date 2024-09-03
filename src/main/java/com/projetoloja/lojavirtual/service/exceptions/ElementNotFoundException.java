package com.projetoloja.lojavirtual.service.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException() {
    }

    public ElementNotFoundException(String message) {
        super(message);
    }
}
