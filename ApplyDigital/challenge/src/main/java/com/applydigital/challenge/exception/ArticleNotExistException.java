package com.applydigital.challenge.exception;

public class ArticleNotExistException extends Exception {

	private static final long serialVersionUID = 4137365399230517611L;
	private String message;
	
	public ArticleNotExistException() {}

	public ArticleNotExistException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
