package com.applydigital.challenge.security;

public record AuthCredentials(String email, String password) {
	public AuthCredentials() {
		this(null, null);
	}
}
