package com.ncteam.iviewer.domain;

import java.io.Serializable;
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
	private Integer universityId;
	
	@Column(name="university_name")
	private String universityName;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="university_id")
	private Set<Form> forms;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="university_id")
	private Set<Faculty> faculties;

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer university_id) {
		this.universityId = university_id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String university_name) {
		this.universityName = university_name;
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
