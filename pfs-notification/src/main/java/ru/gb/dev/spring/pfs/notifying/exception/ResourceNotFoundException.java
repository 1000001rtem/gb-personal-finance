package ru.gb.dev.spring.pfs.notifying.exception;

public class ResourceNotFoundException extends NullPointerException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
