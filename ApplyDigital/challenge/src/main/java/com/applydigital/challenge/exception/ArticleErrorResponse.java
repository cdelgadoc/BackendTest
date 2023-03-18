package com.applydigital.challenge.exception;

public class ArticleErrorResponse {

	private String message;

	public ArticleErrorResponse() {}

	public ArticleErrorResponse(String message) { 
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
