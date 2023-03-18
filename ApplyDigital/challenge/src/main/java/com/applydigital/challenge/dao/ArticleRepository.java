package com.applydigital.challenge.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.applydigital.challenge.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	Optional<Article> findOneByObjectID(String objectID);
	
}
