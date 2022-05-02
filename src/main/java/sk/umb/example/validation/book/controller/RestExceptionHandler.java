package sk.umb.example.validation.book.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sk.umb.example.validation.book.service.BookServiceException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BookServiceException.class)
    public ResponseEntity<String> handleException(BookServiceException bookServiceException) {
        return ResponseEntity.status(444)
                .contentType(MediaType.APPLICATION_JSON)
                .body(bookServiceException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException validationException) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError  fieldError : validationException.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(456)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errors);
    }

}
