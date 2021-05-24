package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomRequestExceptionHandler {

	@ExceptionHandler(CustomRequestException.class)
	public ResponseEntity<ErrorResponse> handleCustomException(final CustomRequestException exception) {
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setDetail(exception.getErrorCode().getMessage());
		errorResponse.setErrorCode(exception.getErrorCodeString());
		errorResponse.setMessage(exception.getErrorCode().getCode());
		errorResponse.setException(exception.getException().toString());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
	}

}
