package com.projetoloja.lojavirtual.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends  CustomError{

    private List<FieldMessage> fieldErrorMessageList = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }
    public List<FieldMessage> getFieldErrorMessageList() {
        return fieldErrorMessageList;
    }

    public void addError (String fieldName, String message) {
        getFieldErrorMessageList().removeIf(x -> x.getFieldName().equals(fieldName));

        getFieldErrorMessageList().add(new FieldMessage(fieldName, message));

    }


}
