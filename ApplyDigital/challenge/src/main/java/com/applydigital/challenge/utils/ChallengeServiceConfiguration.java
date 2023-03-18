package com.applydigital.challenge.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "challenge-service")
@Component(value = "challengeServiceConfiguration")
public class ChallengeServiceConfiguration {

	private String authorization;
	private String userNotExistError;
	private String login;
	private String urlHN;
	private String articleNotExistError;
	private int articlesPerPage;
	private String full;
	private String none;
	private String author;
	private String tags;
	private String title;
	private String month;
	
	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getUserNotExistError() {
		return userNotExistError;
	}

	public void setUserNotExistError(String userNotExistError) {
		this.userNotExistError = userNotExistError;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUrlHN() {
		return urlHN;
	}

	public void setUrlHN(String urlHN) {
		this.urlHN = urlHN;
	}

	public String getArticleNotExistError() {
		return articleNotExistError;
	}

	public void setArticleNotExistError(String articleNotExistError) {
		this.articleNotExistError = articleNotExistError;
	}

	public int getArticlesPerPage() {
		return articlesPerPage;
	}

	public void setArticlesPerPage(int articlesPerPage) {
		this.articlesPerPage = articlesPerPage;
	}

	public String getFull() {
		return full;
	}

	public void setFull(String full) {
		this.full = full;
	}

	public String getNone() {
		return none;
	}

	public void setNone(String none) {
		this.none = none;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
