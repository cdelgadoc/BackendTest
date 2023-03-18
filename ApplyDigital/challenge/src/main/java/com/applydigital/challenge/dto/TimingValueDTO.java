package com.applydigital.challenge.dto;

import java.util.Map;

public record TimingValueDTO(
		Map<String, Integer> format, 
		int total) {
}
