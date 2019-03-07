package ru.gb.dev.spring.pfs.statistics.controller.dto;

public class FailDTO extends ResultDTO {

	public FailDTO(final Exception e) {
		setSuccess(false);
		setMessage(e.getMessage());
	}
}
