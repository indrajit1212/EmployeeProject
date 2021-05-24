package com.example.demo.exceptions;

import java.io.Serializable;

public interface BaseCode extends Serializable {

	String getCode();

	int getHttpStatusCode();

	String getMessage();

}
