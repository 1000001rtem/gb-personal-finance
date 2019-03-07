package ru.gb.dev.spring.pfs.accounting.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * In this class we will handle all exceptions thrown by controllers
 *
 * @author V. Zinchenko
 */

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final String INTERNAL_SERVER_ERROR = "internal_server_error";
    private static final String ENTITY_NOT_FOUND = "entity_not_found";
    private static final String UNAUTHORIZED = "unauthorized";

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorDto handleSessionNotFound(HttpServletRequest request, EntityNotFoundException exception) {
        log.error("Entity not found exception at {}: {}", request.getRequestURI(), exception);
        return new ErrorDto(ENTITY_NOT_FOUND, exception.getLocalizedMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleUnknown(HttpServletRequest request, Exception exception) {
        log.error("exception at {}: {}", request.getRequestURI(), exception);
        return new ErrorDto(INTERNAL_SERVER_ERROR, exception.getLocalizedMessage());
    }

}
