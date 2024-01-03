package com.example.imdb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.imdb.utility.ErrorStructure;


@RestControllerAdvice
public class ExceptionHandller extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> movieNotFoundException()
	{
		ErrorStructure es=new ErrorStructure();
		es.setStatusCode(HttpStatus.NOT_FOUND.value());
		es.setMessage(es.getMessage());
		es.setRootCause("data is not present");
		return new ResponseEntity<ErrorStructure>(es,HttpStatus.NOT_FOUND);	
	}

}
