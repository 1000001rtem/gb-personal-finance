package ru.gb.dev.spring.pfs.notifying.controller.service;

import ru.gb.dev.spring.pfs.notifying.exception.ResourceNotFoundException;

public class RestPreconditions {
    public static <T> T checkFound(T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("Resource not found");
        }
        return resource;
    }
}
