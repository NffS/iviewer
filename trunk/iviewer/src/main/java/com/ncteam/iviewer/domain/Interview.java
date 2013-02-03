package com.ncteam.iviewer.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
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
@Table(name="Interview")
public class Interview implements Serializable{
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="interview_id")
	private Integer interview_id;
	
	@Column(name="start_date")
	private String stringStart_date;
	
	@Column(name="end_date")
	private String stringEnd_date;
	
	@Column(name="start_date", updatable=false, insertable=false)
	private Date start_date;
	
	@Column(name="end_date", updatable=false, insertable=false)
	private Date end_date;
	
	@Column(name="seats")
	private Integer seats;
		
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="interview_id")
	private List<Form> forms;
	
	
	public Integer getInterview_id() {
		return interview_id;
	}
	
	public void setInterview_id(Integer interview_id) {
		this.interview_id = interview_id;
	}
	
	public Date  getStart_date() {
		return start_date;
	}
	
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	public Date  getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	public Integer getSeats() {
		return seats;
	}
	
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	
	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public String getStringStart_date() {
		return stringStart_date;
	}

	public void setStringStart_date(String stringStart_date) {
		this.stringStart_date = stringStart_date;
	}

	public String getStringEnd_date() {
		return stringEnd_date;
	}

	public void setStringEnd_date(String stringEnd_date) {
		this.stringEnd_date = stringEnd_date;
	}

}