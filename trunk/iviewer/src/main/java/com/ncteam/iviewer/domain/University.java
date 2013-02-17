package com.ncteam.iviewer.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Universities")
public class University implements Serializable{
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="university_id")
	private Integer university_id;
	
	@Column(name="university_name")
	private String university_name;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="university_id")
	private Set<Form> forms;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="university_id")
	private Set<Faculty> faculties;

	public Integer getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(Integer university_id) {
		this.university_id = university_id;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public Set<Form> getForms() {
		return forms;
	}

	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

}
