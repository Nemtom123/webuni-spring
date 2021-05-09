package hu.webuni.airport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;


import hu.webuni.airport.service.NonUniqueIataExeption;

@Controller
@RestControllerAdvice
public class CustomExceptionHandler {
	
	
	private static final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);
	

	
	@ExceptionHandler(NonUniqueIataExeption.class)
	public ResponseEntity<MyError> handlerNonUniqueIata(NonUniqueIataExeption e, WebRequest req){
		log.warn(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MyError(1002, e.getMessage()));
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> handlerValidationError(MethodArgumentNotValidException e, WebRequest req){
		log.warn(e.getMessage(), e);
		MyError myError = new MyError(1002, e.getMessage());
		myError.setFieldError(e.getBindingResult().getFieldErrors());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(myError);
		
	}
}
