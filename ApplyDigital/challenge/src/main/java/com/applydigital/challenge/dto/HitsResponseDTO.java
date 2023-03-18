package com.applydigital.challenge.dto;

import java.util.List;

public record HitsResponseDTO(
        List<ArticleDTO> hits,
        int nbHits,
        int page,
        int nbPages,
        int hitsPerPage,
        boolean exhaustiveNbHits,
        boolean exhaustiveTypo,
        ExhaustiveDTO exhaustive,
        String query,
        String params,
        int processingTimeMS,
        ProcessingTimingsMSDTO processingTimingsMS,
        int serverTimeMS) {
}
