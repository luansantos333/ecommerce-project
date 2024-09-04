package com.projetoloja.lojavirtual.dto;

/*
* This class represents the field and message from the validation annotation from Jakarta Validation
* Framework
 */
public class FieldMessage {

    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
