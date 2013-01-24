package com.ncteam.iviewer.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Interview")
public class Interview {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="interview_id")
	private Integer interview_id;
	
	@Column(name="start_date")
	private Date start_date;
	
	@Column(name="end_date")
	private Date end_date;
	
	@Column(name="seats")
	private Integer seats;
		
	@OneToMany(mappedBy="interview", cascade=CascadeType.ALL)
	private Set<Form> Form;
	
	
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
	
	public Set<Form> getForm() {
		return Form;
	}

	public void setForm(Set<Form> Form) {
		this.Form = Form;
	}

}