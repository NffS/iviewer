package com.ncteam.iviewer.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="HR_mark")
public class HRMark implements Serializable{
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="hr_mark_id")
	private Integer hrMarkId;
	
	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;
	
	@Column(name="form_id", insertable=false, updatable=false)
	private Integer formId;
	
	@Column(name="motivation")
	private Integer motivation;
	
	@Column(name="english")
	private Integer english;
	
	@Column(name="general_mark")
	private String generalMark;
		
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
    @JoinColumn(name="form_id")
    private Form Form;

	public Integer getHrMarkId() {
		return hrMarkId;
	}

	public void setHrMarkId(Integer hrMarkId) {
		this.hrMarkId = hrMarkId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Integer getMotivation() {
		return motivation;
	}

	public void setMotivation(Integer motivation) {
		this.motivation = motivation;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public String getGeneralMark() {
		return generalMark;
	}

	public void setGeneralMark(String generalMark) {
		this.generalMark = generalMark;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Form getForm() {
		return Form;
	}

	public void setForm(Form form) {
		Form = form;
	}
}