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
@Table(name="Sources")
public class Source  implements Serializable{

	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="source_id")
	private Integer source_id;
	
	@Column(name="source_name")
	private String source_name;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="source_id")
	private Set<Form> forms;

	public Integer getSource_id() {
		return source_id;
	}

	public void setSource_id(Integer source_id) {
		this.source_id = source_id;
	}

	public String getSource_name() {
		return source_name;
	}

	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}

	public Set<Form> getForms() {
		return forms;
	}

	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}
}
