package com.projetoloja.lojavirtual.controllers.handlers;

import com.projetoloja.lojavirtual.dto.CustomError;
import com.projetoloja.lojavirtual.dto.FieldMessage;
import com.projetoloja.lojavirtual.dto.ValidationError;
import com.projetoloja.lojavirtual.service.exceptions.DatabaseException;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import com.projetoloja.lojavirtual.service.exceptions.ForbidenException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity <CustomError> methodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());
        for (int i=0; i<e.getBindingResult().getFieldErrors().size(); i++) {
            err.getFieldErrorMessageList().add(new FieldMessage(e.getBindingResult().getFieldErrors().get(i).getField(),
                    e.getBindingResult().getFieldErrors().get(i).getDefaultMessage()));

        }

        return ResponseEntity.status(status).body(err);

    }


    @ExceptionHandler (ForbidenException.class)
    public ResponseEntity<CustomError>  forbidenError (ForbidenException e, HttpServletRequest r) {


        HttpStatus status = HttpStatus.FORBIDDEN;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), r.getRequestURI());

        return ResponseEntity.status(status).body(err);

    }


}