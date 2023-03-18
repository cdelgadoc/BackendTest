package com.applydigital.challenge.dto;

import java.util.List;

public record ArticleResponseDTO(
		List<ArticleDTO> hits,
		int page,
        int nbHits,
        int nbPages,
        String params) {
}
