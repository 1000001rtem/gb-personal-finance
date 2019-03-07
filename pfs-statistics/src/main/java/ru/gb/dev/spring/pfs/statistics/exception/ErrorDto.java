package ru.gb.dev.spring.pfs.statistics.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class for errors
 *
 * @author V. Zinchenko
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
	private String code;
	private String message;
}
