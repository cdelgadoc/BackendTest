package com.applydigital.challenge.dto;

import java.util.List;

public record SearchResultValueDTO(
        String value,
        String matchLevel,
        List<String> matchedWords) {
}