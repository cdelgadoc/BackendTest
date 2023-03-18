package com.applydigital.challenge.service;

import com.applydigital.challenge.dto.ArticleResponseDTO;
import com.applydigital.challenge.dto.FilterDTO;
import com.applydigital.challenge.exception.ArticleNotExistException;

public interface ArticleManagerService {

	boolean deleteArticle(String objectID) throws ArticleNotExistException;
	
	ArticleResponseDTO getArticles(FilterDTO filter, int page);
	
}
