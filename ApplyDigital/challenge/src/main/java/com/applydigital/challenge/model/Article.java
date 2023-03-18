package com.applydigital.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "object_id", nullable = false, unique = true, length = 50)
	private String objectID;

	@Column(name = "created_at", nullable = false, length = 30)
	private String created;

	@Column(nullable = false)
	private Boolean active;

	@Column(length = 200)
	private String url;

	private Integer points;

	@Column(name = "story_text", length = 5000)
	private String storyText;

	@Column(name = "comment_text", length = 5000)
	private String commentText;

	@Column(name = "num_comments")
	private Integer numComments;

	@Column(name = "story_id")
	private Integer storyID;

	@Column(name = "story_title", length = 200)
	private String storyTitle;

	@Column(name = "story_url", length = 200)
	private String storyURL;

	@Column(name = "parent_id")
	private Integer parentID;

	@Column(name = "created_at_i")
	private Long createdAtI;

	@Column(length = 100)
	private String author;

	@Column(length = 200)
	private String tags;

	@Column(length = 200)
	private String title;

	@Column(nullable = false, length = 9)
	private String month;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getStoryText() {
		return storyText;
	}

	public void setStoryText(String storyText) {
		this.storyText = storyText;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Integer getNumComments() {
		return numComments;
	}

	public void setNumComments(Integer numComments) {
		this.numComments = numComments;
	}

	public Integer getStoryID() {
		return storyID;
	}

	public void setStoryID(Integer storyID) {
		this.storyID = storyID;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

	public String getStoryURL() {
		return storyURL;
	}

	public void setStoryURL(String storyURL) {
		this.storyURL = storyURL;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Long getCreatedAtI() {
		return createdAtI;
	}

	public void setCreatedAtI(Long createdAtI) {
		this.createdAtI = createdAtI;
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
