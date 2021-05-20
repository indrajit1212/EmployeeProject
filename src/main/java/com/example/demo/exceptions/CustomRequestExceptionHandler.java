package com.example.demo.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CustomRequestExceptionHandler {
	
	@ExceptionHandler(value= {CustomRequestException.class})
	public ResponseEntity<Object> handleCustomRequestException(CustomRequestException e)
	{
		//1. create payload containiong exception details
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		
		CustomException customException=new CustomException(e.getMessage(),
		e,
		HttpStatus.BAD_REQUEST,
		ZonedDateTime.now(ZoneId.of("Z"))
		);
		return new ResponseEntity<>(customException,HttpStatus.BAD_REQUEST);
	}

}
