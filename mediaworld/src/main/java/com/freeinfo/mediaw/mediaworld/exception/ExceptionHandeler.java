package com.freeinfo.mediaw.mediaworld.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExceptionHandeler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(MediaworldException.class)
	public ResponseEntity<ErrorResponse> setMediaworldException(MediaworldException ex){
		
		ErrorResponse err = new ErrorResponse();
		
		err.setDate(java.time.LocalTime.now());
		err.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setMessage(ex.getMessaggio());
		
		return new ResponseEntity<ErrorResponse>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(InvalidCodeException.class)
	public ResponseEntity<ErrorResponse> setInvalidCodeException(InvalidCodeException ex){
		
		ErrorResponse err = new ErrorResponse();
		
		err.setDate(java.time.LocalTime.now());
		err.setCode(HttpStatus.NOT_FOUND.value());
		err.setMessage(ex.getMessaggio());
		
		return new ResponseEntity<ErrorResponse>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	

}
