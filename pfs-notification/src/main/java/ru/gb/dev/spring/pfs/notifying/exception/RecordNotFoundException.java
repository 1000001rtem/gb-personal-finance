package ru.gb.dev.spring.pfs.notifying.exception;

public class RecordNotFoundException extends NullPointerException {

    public RecordNotFoundException(String message) {
        super(message);
    }
}
