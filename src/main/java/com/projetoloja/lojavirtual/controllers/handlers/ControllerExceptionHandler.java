package com.projetoloja.lojavirtual.controllers.handlers;

import com.projetoloja.lojavirtual.dto.CustomError;
import com.projetoloja.lojavirtual.service.exceptions.DatabaseException;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;


@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ElementNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler (DatabaseException.class)
    public ResponseEntity<CustomError> databaseException (DatabaseException e, HttpServletRequest request) {

        HttpStatus statusRequest = HttpStatus.PRECONDITION_FAILED;
        CustomError err = new CustomError(Instant.now(), statusRequest.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(statusRequest).body(err);

    }



}
