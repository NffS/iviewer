package com.ncteam.iviewer.domain;

public class FormInformation implements Comparable<FormInformation> {

	private String first_name;
	private String surname;
	private String last_name;
	private String start_date;
	private Integer status;
	private Integer form_id;
	private String university_name;
	
	public FormInformation(String first_name, String surname, String last_name,
			String start_date, Integer status, Integer form_id, String university_name){
		this.first_name=first_name;
		this.surname=surname;
		this.last_name=last_name;
		this.start_date=start_date;
		this.status=status;
		this.form_id=form_id;
		this.university_name=university_name;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getForm_id() {
		return form_id;
	}
	public void setForm_id(Integer form_id) {
		this.form_id = form_id;
	}
	public String getUniversity_name() {
		return university_name;
	}
	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
	

	@Override
	public int compareTo(FormInformation comparedFormInformation) {
		return this.surname.compareTo(comparedFormInformation.surname);
	}
}
