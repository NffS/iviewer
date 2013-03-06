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
	private Integer tech_mark_id;
	
	@Column(name="user_id")
	private Integer user_id;
	
	@Column(name="form_id")
	private Integer form_id;
	
	@Column(name="prog_lang")
	private Integer prog_lang;
	
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
	private String general_mark;
	
	@OneToOne
	@JoinColumn(name="form_id", insertable=false, updatable=false)
	private Form form;
	
	@OneToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false)
	private User user;

	public Integer getTech_mark_id() {
		return tech_mark_id;
	}

	public void setTech_mark_id(Integer tech_mark_id) {
		this.tech_mark_id = tech_mark_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getForm_id() {
		return form_id;
	}

	public void setForm_id(Integer form_id) {
		this.form_id = form_id;
	}

	public Integer getProg_lang() {
		return prog_lang;
	}

	public void setProg_lang(Integer prog_lang) {
		this.prog_lang = prog_lang;
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

	public String getGeneral_mark() {
		return general_mark;
	}

	public void setGeneral_mark(String general_mark) {
		this.general_mark = general_mark;
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
