package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomRequestException extends RuntimeException {
	private BaseCode errorCode;
	private String errorCodeString;
	private Exception exception;

	public CustomRequestException(final BaseCode errorCode) {
		super(errorCode.getMessage());
		this.exception = new RuntimeException(errorCode.getMessage());
		this.errorCode = errorCode;
		this.errorCodeString = errorCode.toString();
	}

	public CustomRequestException(final BaseCode errorCode, final Exception exception) {
		super(String.join("_", errorCode.getMessage(), exception.getMessage()), exception);
		this.exception = exception;
		this.errorCode = errorCode;
		this.errorCodeString = errorCode.toString();
	}

}
