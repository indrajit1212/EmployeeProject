package com.example.demo.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;



import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;

}
