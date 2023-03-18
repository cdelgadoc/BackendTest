package com.applydigital.challenge.dto;

public record ProcessingTimingsMSDTO(
        TimingValueDTO afterFetch,
        TimingValueDTO fetch,
        TimingValueDTO getIdx,
        TimingValueDTO request,
        int total) {    
}