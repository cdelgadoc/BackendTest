package com.applydigital.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArticleRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ArticleErrorResponse> handleException(ArticleNotExistException exception) {
		ArticleErrorResponse error = new ArticleErrorResponse(exception.getMessage());
		return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<ArticleErrorResponse> handleException(Exception exception) {
		ArticleErrorResponse error = new ArticleErrorResponse(exception.getMessage());
		return new ResponseEntity<>(error, null, HttpStatus.SERVICE_UNAVAILABLE);
	}
}
