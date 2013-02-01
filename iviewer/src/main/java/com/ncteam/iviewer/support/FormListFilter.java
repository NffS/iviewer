package com.ncteam.iviewer.support;

/*
 * Класс используется для передачи полей, необходимых для поиска по фильтру,
 * со страницы form_list.jsp в контроллер.
 */
public class FormListFilter {

	private String lastName;
	private String interviewDate;
	private String university;
	private boolean requiredConfirmOnly;
	
	public FormListFilter(){
		lastName="";
		interviewDate="";
		requiredConfirmOnly=false;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(String interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public boolean isRequiredConfirmOnly() {
		return requiredConfirmOnly;
	}
	public void setRequiredConfirmOnly(boolean requiredConfirmOnly) {
		this.requiredConfirmOnly = requiredConfirmOnly;
	}
}
