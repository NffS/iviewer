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
@Table(name="Tech_mark")
public class TechMark implements Serializable{
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="tech_mark_id")
	private Integer techMarkId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="form_id")
	private Integer formId;
	
	@Column(name="prog_lang")
	private Integer progLang;
	
	@Column(name="oop")
	private Integer oop;
	
	@Column(name="patterns")
	private Integer patterns;
	
	@Column(name="db")
	private Integer db;
	
	@Column(name="cs")
	private Integer cs;
	
	@Column(name="experience")
	private Integer experience;
	
	@Column(name="other")
	private Integer other;
	
	@Column(name="general_mark")
	private String generalMark;
	
	@OneToOne
	@JoinColumn(name="form_id", insertable=false, updatable=false)
	private Form form;
	
	@OneToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false)
	private User user;

	public Integer getTechMarkId() {
		return techMarkId;
	}

	public void setTechMarkId(Integer techMarkId) {
		this.techMarkId = techMarkId;
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

	public Integer getProgLang() {
		return progLang;
	}

	public void setProgLang(Integer progLang) {
		this.progLang = progLang;
	}

	public Integer getOop() {
		return oop;
	}

	public void setOop(Integer oop) {
		this.oop = oop;
	}

	public Integer getPatterns() {
		return patterns;
	}

	public void setPatterns(Integer patterns) {
		this.patterns = patterns;
	}

	public Integer getDb() {
		return db;
	}

	public void setDb(Integer db) {
		this.db = db;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getOther() {
		return other;
	}

	public void setOther(Integer other) {
		this.other = other;
	}

	public String getGeneralMark() {
		return generalMark;
	}

	public void setGeneralMark(String generalMark) {
		this.generalMark = generalMark;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
