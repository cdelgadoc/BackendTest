package com.applydigital.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.applydigital.challenge.dto.FilterDTO;
import com.applydigital.challenge.exception.ArticleNotExistException;
import com.applydigital.challenge.service.ArticleManagerService;

@SpringBootTest
class ChallengeApplicationTests {

	@Autowired
	private ArticleManagerService service;
	
	private FilterDTO filter;
	
	@BeforeEach
	public void beforeEach() {
		filter = new FilterDTO(null, null, null, null);
	}
	
	@DisplayName("Validate the services response")
	@Test
	public void responseValidation() {
		assertNotNull(service.getArticles(filter, 0), "object should not be null");
	}
	
	@DisplayName("Validate the amount of articles for page")
	@Test
	public void pageSize() {
		assertEquals(service.getArticles(filter, 0).nbPages(), 5);
	}
	
	@DisplayName("Validate the delete article generated ArticleNotExistException")
	@Test
	public void generateArticleNotExistException() {
		
		assertThrows(ArticleNotExistException.class, () -> {
			service.deleteArticle("1");
		});
	}
	
}
