package com.dovindev.repository.exceptions;

public class DuplicateRecordDataAccessException extends WriteDataAccesException{
    public DuplicateRecordDataAccessException(String message) {
        super(message);
    }
}
