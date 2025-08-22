package com.dsrcorporation.ru.codereviewplatform.exception;

/**
 * Исключение, возникающее в случае,
 * если сущность не была найдена в БД.
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
