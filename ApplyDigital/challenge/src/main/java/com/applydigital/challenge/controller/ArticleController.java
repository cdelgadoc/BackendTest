package com.applydigital.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.applydigital.challenge.dto.ArticleResponseDTO;
import com.applydigital.challenge.dto.FilterDTO;
import com.applydigital.challenge.exception.ArticleNotExistException;
import com.applydigital.challenge.service.ArticleManagerService;

@RestController
public class ArticleController {
	
	@Autowired
	private ArticleManagerService service;

	@DeleteMapping("/article/{objectID}")
	public ResponseEntity<Boolean> delete(@PathVariable String objectID) throws ArticleNotExistException {
		return new ResponseEntity<Boolean>(service.deleteArticle(objectID), HttpStatus.OK);
	}
	
	@PostMapping("/article/{page}")
	public ResponseEntity<ArticleResponseDTO> getArticles(@RequestBody FilterDTO filter, @PathVariable int page) {
		return new ResponseEntity<ArticleResponseDTO>(service.getArticles(filter, page), HttpStatus.OK);
    }
	
}
