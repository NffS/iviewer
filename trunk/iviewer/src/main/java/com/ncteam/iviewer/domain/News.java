package com.ncteam.iviewer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="News")
public class News{

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="news_id")
	private Integer newsId;
	
	@Column(name="text")
	private String text;
	
	
	public Integer getNewsId() {
		return newsId;
	}
	
	public void setNewsId(Integer news_id) {
		this.newsId = news_id;
	}
	
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}