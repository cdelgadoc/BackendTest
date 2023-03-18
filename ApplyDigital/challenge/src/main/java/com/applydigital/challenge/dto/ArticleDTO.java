package com.applydigital.challenge.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ArticleDTO(
		String objectID,
		@JsonProperty("created_at") String createdAt,
        String title,
        String url,
        String author,
        Integer points,
        @JsonProperty("story_text") String storyText,
        @JsonProperty("comment_text") String commentText,
        @JsonProperty("num_comments") Integer numComments,
        @JsonProperty("story_id") Integer storyId,
        @JsonProperty("story_title") String storyTitle,
        @JsonProperty("story_url") String storyURL,
        @JsonProperty("parent_id") Integer parentID,
        @JsonProperty("created_at_i") long createdAtI,
        @JsonProperty("_tags") List<String> tags,
        @JsonProperty("_highlightResult") HighlightResultDTO highlightResult) {
}