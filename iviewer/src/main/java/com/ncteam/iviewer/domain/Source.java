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
	private Integer sourceId;
	
	@Column(name="source_name")
	private String sourceName;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="source_id")
	private Set<Form> forms;

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer source_id) {
		this.sourceId = source_id;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String source_name) {
		this.sourceName = source_name;
	}

	public Set<Form> getForms() {
		return forms;
	}

	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}
}
