package ru.gb.dev.spring.pfs.accounting.exception;

public class EntityNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 386726542537970495L;

    public EntityNotFoundException(final String message) {
        super(message);
    }

}
