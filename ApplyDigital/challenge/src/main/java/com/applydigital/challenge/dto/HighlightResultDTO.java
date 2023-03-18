package com.applydigital.challenge.dto;

public record HighlightResultDTO(
        SearchResultValueDTO author,
        SearchResultValueDTO tags,
        SearchResultValueDTO title,
        SearchResultValueDTO month) {
    
}