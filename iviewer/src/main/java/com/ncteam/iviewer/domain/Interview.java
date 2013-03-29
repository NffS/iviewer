package com.ncteam.iviewer.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Interview")
public class Interview implements Serializable{
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="interview_id")
	private Integer interviewId;
	
	/*
	 * Field is added, because for column of the date data type in java there should be a
	 * field with java.sql.Date, which doesn't hold time of the day. And String does.
	 */
	@Column(name="start_date")
	private String stringStartDate;
	
	/*
	 * Field is added, because for column of the date data type in java there should be a
	 * field with java.sql.Date, which doesn't hold time of the day. And String does.
	 */
	@Column(name="end_date")
	private String stringEndDate;
	
	@Column(name="start_date", updatable=false, insertable=false)
	private Date startDate;
	
	@Column(name="end_date", updatable=false, insertable=false)
	private Date endDate;
	
	@Column(name="extra_time")
	private Integer extraTime;
	
	@Column(name="seats")
	private Integer seats;
		
	@OneToMany( fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH} )
	@Cascade( org.hibernate.annotations.CascadeType.SAVE_UPDATE )
	@JoinColumn(name="interview_id")
	private List<Form> forms;

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public String getStringStartDate() {
		return stringStartDate;
	}

	public void setStringStartDate(String stringStartDate) {
		this.stringStartDate = stringStartDate;
	}

	public String getStringEndDate() {
		return stringEndDate;
	}

	public void setStringEndDate(String stringEndDate) {
		this.stringEndDate = stringEndDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getExtraTime() {
		return extraTime;
	}

	public void setExtraTime(Integer extraTime) {
		this.extraTime = extraTime;
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
	
}