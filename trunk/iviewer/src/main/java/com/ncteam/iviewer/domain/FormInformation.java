package com.ncteam.iviewer.domain;

/*
 * This class is used to get not full information about candidate not from only Form table,
 * but from Users and Universities tables too. The class is used in the FormDAO class.
 */
public class FormInformation implements Comparable<FormInformation> {

	private String firstName;
	private String surname;
	private String lastName;
	private Integer userId;
	private String startDate;
	private Integer status;
	private Integer visitStatus;
	private Integer formId;
	private String universityName;
	private Integer universityId;
	
	public FormInformation(String first_name, String surname, String last_name, Integer userId,
			String start_date, Integer status, Integer visit_status, Integer form_id, 
			String university_name, Integer university_id){
		this.firstName=first_name;
		this.surname=surname;
		this.lastName=last_name;
		this.userId=userId;
		this.startDate=start_date;
		this.status=status;
		this.visitStatus=visit_status;
		this.formId=form_id;
		this.universityName=university_name;
		this.universityId=university_id;
	}
	
	@Override
	public int compareTo(FormInformation comparedFormInformation) {
		return this.surname.compareTo(comparedFormInformation.surname);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(Integer visitStatus) {
		this.visitStatus = visitStatus;
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
