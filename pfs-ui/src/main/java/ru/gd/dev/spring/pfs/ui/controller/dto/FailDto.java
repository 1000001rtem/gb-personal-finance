package ru.gd.dev.spring.pfs.ui.controller.dto;

public class FailDto extends ResultDto {

    public FailDto(final Exception e) {
        setSuccess(false);
        setMessage(e.getMessage());
    }
}
