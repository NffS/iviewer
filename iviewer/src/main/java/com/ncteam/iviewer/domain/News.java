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
	private Integer news_id;
	
	@Column(name="text")
	private String text;
	
	
	public Integer getNews_id() {
		return news_id;
	}
	
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}