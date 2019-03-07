package ru.gb.dev.spring.pfs.notifying.exception;

public class ErrorDatabase extends NullPointerException{

    public ErrorDatabase(final String message) {
        super(message);
    }

}
