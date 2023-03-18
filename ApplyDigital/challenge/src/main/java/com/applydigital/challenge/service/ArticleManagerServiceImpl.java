package com.applydigital.challenge.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.applydigital.challenge.dao.ArticleRepository;
import com.applydigital.challenge.dto.ArticleDTO;
import com.applydigital.challenge.dto.ArticleResponseDTO;
import com.applydigital.challenge.dto.FilterDTO;
import com.applydigital.challenge.dto.HighlightResultDTO;
import com.applydigital.challenge.dto.HitsResponseDTO;
import com.applydigital.challenge.dto.SearchResultValueDTO;
import com.applydigital.challenge.exception.ArticleNotExistException;
import com.applydigital.challenge.model.Article;
import com.applydigital.challenge.utils.ArticleConversor;
import com.applydigital.challenge.utils.ChallengeServiceConfiguration;

import jakarta.annotation.PostConstruct;

@EnableScheduling
@Service
public class ArticleManagerServiceImpl implements ArticleManagerService {

	@Autowired
	private ChallengeServiceConfiguration configuration;

	private final RestTemplate restTemplate;

	@Autowired
	private ArticleRepository articleRepository;
	
	public ArticleManagerServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@PostConstruct
	public void init() {
		readArticles();
	}

	/**
	 * runs every hour
	 */
	@Scheduled(cron = "0 0 * * * *")
	private void readArticles() {
		ResponseEntity<HitsResponseDTO> responseEntity = 
				restTemplate.getForEntity(
						configuration.getUrlHN(), 
						HitsResponseDTO.class);
		saveArticles(responseEntity.getBody().hits());
	}
	
	private void saveArticles(List<ArticleDTO> articlesDTO) {
		articlesDTO.forEach(articleDTO -> {
			Article article  = ArticleConversor.getArticle(articleDTO);
			
			if (articleRepository.findOneByObjectID(article.getObjectID()).isEmpty()) {
				articleRepository.save(article);
			}
		});
	}

	@Override
	public boolean deleteArticle(String objectID) throws ArticleNotExistException {
		Article article = getArticleByObjectID(objectID);
		if (article != null && article.getActive()) {
			article.setActive(false);
			articleRepository.saveAndFlush(article);
			return true;
		} else {
			throw new ArticleNotExistException(configuration.getArticleNotExistError());
		}
	}

	private Article getArticleByObjectID(String objectID) {
		Optional<Article> article = articleRepository.findOneByObjectID(objectID);
		return article.isPresent() ? article.get() : null;
	}

	@Override
	public ArticleResponseDTO getArticles(FilterDTO filter, int page) {
		Article articleFilter = new Article(); 
		articleFilter.setAuthor(filter.author());
		articleFilter.setTags(filter.tags());
		articleFilter.setTitle(filter.title());
		articleFilter.setMonth(filter.month());
		articleFilter.setActive(true);
		
		ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAll()
			      .withMatcher(configuration.getAuthor(), ExampleMatcher.GenericPropertyMatchers.ignoreCase())
			      .withMatcher(configuration.getTags(), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher(configuration.getTitle(), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			      .withMatcher(configuration.getMonth(), ExampleMatcher.GenericPropertyMatchers.ignoreCase());
		
		Example<Article> example = Example.of(articleFilter, customExampleMatcher);

	    Page<Article> results = articleRepository.findAll(example, 
	    		PageRequest.of(page, configuration.getArticlesPerPage()));
	    
	    List<ArticleDTO> articlesDTO = new ArrayList<>();

	    results.forEach(article -> {
	    	HighlightResultDTO highlightResultDTO = getHighlightResultDTO(
	    			filter, 
	    			article.getAuthor(), 
	    			article.getTags(), 
	    			article.getTitle(), 
	    			article.getMonth());
	    	
			ArticleDTO articleDTO  = ArticleConversor.getArticleDTO(article, highlightResultDTO);
			articlesDTO.add(articleDTO);
		});
	    
	    return getResponse(articlesDTO, page, articlesDTO.size(), 
	    		configuration.getArticlesPerPage(), filter);
	}
	
	private ArticleResponseDTO getResponse(List<ArticleDTO> articlesDTO,
			int page, int nbPages, int hitsPerPage, FilterDTO filter) {
		return new ArticleResponseDTO(articlesDTO, page, nbPages, hitsPerPage, filter.toString());		
	}
	
	private HighlightResultDTO getHighlightResultDTO(FilterDTO filter,
			String author, String tags, String title, String month) {
		return new HighlightResultDTO(
				getSearchResultValueDTO(author, filter.author()), 
				getSearchResultValueDTO(tags, filter.tags()), 
				getSearchResultValueDTO(title, filter.title()), 
				getSearchResultValueDTO(month, filter.month()));
	}
	
	private SearchResultValueDTO getSearchResultValueDTO(String value, String filter) {
		return new SearchResultValueDTO(value, 
				((filter != null && !filter.isEmpty()) ? configuration.getFull() : configuration.getNone()),
				(filter != null ? Arrays.asList(filter) : Collections.<String> emptyList()));
	}

}
