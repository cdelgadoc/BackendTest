package com.applydigital.challenge.utils;

import java.util.Arrays;

import com.applydigital.challenge.dto.ArticleDTO;
import com.applydigital.challenge.dto.HighlightResultDTO;
import com.applydigital.challenge.model.Article;

public class ArticleConversor {
	
	public static Article getArticle(ArticleDTO articleDTO) {
		Article article = new Article();
		article.setId(null);
		article.setObjectID(articleDTO.objectID());
		article.setCreated(articleDTO.createdAt());
		article.setUrl(getLimitedText(articleDTO.url(), 200));
		article.setPoints(articleDTO.points());
		article.setStoryText(getLimitedText(articleDTO.storyText(), 5000));
		article.setCommentText(getLimitedText(articleDTO.commentText(), 5000));
		article.setNumComments(articleDTO.numComments());
		article.setStoryID(articleDTO.storyId());
		article.setStoryTitle(getLimitedText(articleDTO.storyTitle(), 200));
		article.setStoryURL(getLimitedText(articleDTO.storyURL(), 200));
		article.setParentID(articleDTO.parentID());
		article.setCreatedAtI(articleDTO.createdAtI());
		article.setAuthor(getLimitedText(articleDTO.author(), 100));
		article.setTags(getLimitedText(articleDTO.tags().stream().reduce((a, b) -> a + ", " + b).get(), 200));
		article.setTitle(getLimitedText(articleDTO.title(), 200));
		article.setMonth(UtilDate.getMonthName(articleDTO.createdAt()));
		article.setActive(true);
		
		return article;
	}
	
	public static ArticleDTO getArticleDTO(Article article, HighlightResultDTO highlightResult) {
		ArticleDTO articleDTO = new ArticleDTO(
				article.getObjectID(),
				article.getCreated(),
				article.getTitle(),
				article.getUrl(),
				article.getAuthor(),
				article.getPoints(),
				article.getStoryText(),
				article.getCommentText(),
				article.getNumComments(),
				article.getStoryID(),
				article.getStoryTitle(),
				article.getStoryURL(),
				article.getParentID(),
				article.getCreatedAtI(),
				Arrays.asList(article.getTags()),
				highlightResult);
						
		return articleDTO;
	}
	
	private static String getLimitedText(String text, int size) {
		return (text != null && text.length() > size) ? text.substring(0, size) : text;
	}

}
