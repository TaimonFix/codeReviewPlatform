package com.dsrcorporation.ru.codereviewplatform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Обработчик исключений.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Обработчик исключений, связанных с отсуствием сущностей в БД.
     */
    @ExceptionHandler(value = {UsernameNotFoundException.class,
                               EntityNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(final RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Обработчик исключений, связанных с плохим запросом.
     */
    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleBadRequestException(final RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
