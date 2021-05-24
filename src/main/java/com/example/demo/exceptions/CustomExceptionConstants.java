package com.example.demo.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CustomExceptionConstants implements BaseCode {
	Employee_NOT_FOUND("employee not available"), DIVISION_BY_ZERO("division by zero");

	private String message;

	@Override
	public String getCode() {

		return name();
	}

	@Override
	public int getHttpStatusCode() {

		return 400;
	}

	@Override
	public String getMessage() {

		return this.message;
	}

}
