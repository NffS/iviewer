package com.ncteam.iviewer.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Form")
public class Form implements Serializable, Comparable<Form>{
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column(name="form_id")
	private Integer form_id;
	
	@Column(name="user_id", insertable=false, updatable=false)
	private Integer user_id;
	
	@Column(name="university_id", insertable=false, updatable=false)
	private Integer university_id;
	
	@Column(name="faculty_id", insertable=false, updatable=false)
	private Integer faculty_id;
	
	@Column(name="course")
	private Integer course;
	
	@Column(name="end_year")
	private String end_year;
	
	@Column(name="email2")
	private String email2;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="another_contact")
	private String another_contact;
	
	@Column(name="interest_tc")
	private String interest_tc;
	
	@Column(name="interest_nc")
	private String interest_nc;
	
	@Column(name="interest_area_po")
	private String interest_area_po;
	
	@Column(name="interest_area_other")
	private String interest_area_other;
	
	@Column(name="job_ar_deep_spec")
	private String job_ar_deep_spec;
	
	@Column(name="job_ar_varied")
	private String job_ar_varied;
	
	@Column(name="job_ar_manage")
	private String job_ar_manage;
	
	@Column(name="job_ar_sales")
	private String job_ar_sales;
	
	@Column(name="job_ar_other")
	private String job_ar_other;
	
	@Column(name="prog_lang_c")
	private Integer prog_lang_c;
	
	@Column(name="prog_lang_java")
	private Integer prog_lang_java;
	
	@Column(name="prog_lang_other")
	private String  prog_lang_other;
	
	@Column(name="cs_network_tech")
	private Integer cs_network_tech;
	
	@Column(name="cs_algorithms")
	private Integer cs_algorithms;
	
	@Column(name="cs_oop")
	private Integer cs_oop;
	
	@Column(name="cs_gui")
	private Integer cs_gui;
	
	@Column(name="cs_db")
	private Integer cs_db;
	
	@Column(name="cs_web")
	private Integer cs_web;
	
	@Column(name="cs_network_prog")
	private Integer cs_network_prog;
	
	@Column(name="cs_design")
	private Integer cs_design;
	
	@Column(name="experience")
	private String experience;
	
	@Column(name="english_read")
	private Integer english_read;
	
	@Column(name="english_write")
	private Integer english_write;
	
	@Column(name="english_spoken")
	private Integer english_spoken;
	
	@Column(name="source_id", insertable=false, updatable=false)
	private Integer source_id;
	
	@Column(name="motivation_comment")
	private String motivation_comment;
	
	@Column(name="comment2")
	private String comment2;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="interview_id", insertable=false, updatable=false)
	private Integer interview_id;
	
	@Column(name="visit_status")
	private Integer visit_status;
	
	@OneToOne
	@JoinColumn(name="user_id")
    private User user;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hr_mark_id")
	private HR_mark hr_mark;
	
	@OneToOne
	@JoinColumn(name="form_id")
	private Tech_mark tech_mark;	
	
	@ManyToOne
	@JoinColumn(name="interview_id")
	private Interview interview;
	
	@ManyToOne
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name="source_id")
	private Source source;

	public Integer getForm_id() {
		return form_id;
	}

	public void setForm_id(Integer form_id) {
		this.form_id = form_id;
	}


	public Integer getUniversity_id() {
		return university_id;
	}

	public void setUniversity_id(Integer university_id) {
		this.university_id = university_id;
	}

	public Integer getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public String getEnd_year() {
		return end_year;
	}

	public void setEnd_year(String end_year) {
		this.end_year = end_year;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAnother_contact() {
		return another_contact;
	}

	public void setAnother_contact(String another_contact) {
		this.another_contact = another_contact;
	}

	public String getInterest_tc() {
		return interest_tc;
	}

	public void setInterest_tc(String interest_tc) {
		this.interest_tc = interest_tc;
	}

	public String getInterest_nc() {
		return interest_nc;
	}

	public void setInterest_nc(String interest_nc) {
		this.interest_nc = interest_nc;
	}

	public String getInterest_area_po() {
		return interest_area_po;
	}

	public void setInterest_area_po(String interest_area_po) {
		this.interest_area_po = interest_area_po;
	}

	public String getInterest_area_other() {
		return interest_area_other;
	}

	public void setInterest_area_other(String interest_area_other) {
		this.interest_area_other = interest_area_other;
	}

	public String getJob_ar_deep_spec() {
		return job_ar_deep_spec;
	}

	public void setJob_ar_deep_spec(String job_ar_deep_spec) {
		this.job_ar_deep_spec = job_ar_deep_spec;
	}

	public String getJob_ar_varied() {
		return job_ar_varied;
	}

	public void setJob_ar_varied(String job_ar_varied) {
		this.job_ar_varied = job_ar_varied;
	}

	public String getJob_ar_manage() {
		return job_ar_manage;
	}

	public void setJob_ar_manage(String job_ar_manage) {
		this.job_ar_manage = job_ar_manage;
	}

	public String getJob_ar_sales() {
		return job_ar_sales;
	}

	public void setJob_ar_sales(String job_ar_sales) {
		this.job_ar_sales = job_ar_sales;
	}

	public String getJob_ar_other() {
		return job_ar_other;
	}

	public void setJob_ar_other(String job_ar_other) {
		this.job_ar_other = job_ar_other;
	}

	public Integer getProg_lang_c() {
		return prog_lang_c;
	}

	public void setProg_lang_c(Integer prog_lang_c) {
		this.prog_lang_c = prog_lang_c;
	}

	public Integer getProg_lang_java() {
		return prog_lang_java;
	}

	public void setProg_lang_java(Integer prog_lang_java) {
		this.prog_lang_java = prog_lang_java;
	}

	public String getProg_lang_other() {
		return prog_lang_other;
	}

	public void setProg_lang_other(String prog_lang_other) {
		this.prog_lang_other = prog_lang_other;
	}

	public Integer getCs_network_tech() {
		return cs_network_tech;
	}

	public void setCs_network_tech(Integer cs_network_tech) {
		this.cs_network_tech = cs_network_tech;
	}

	public Integer getCs_algorithms() {
		return cs_algorithms;
	}

	public void setCs_algorithms(Integer cs_algorithms) {
		this.cs_algorithms = cs_algorithms;
	}

	public Integer getCs_oop() {
		return cs_oop;
	}

	public void setCs_oop(Integer cs_oop) {
		this.cs_oop = cs_oop;
	}

	public Integer getCs_gui() {
		return cs_gui;
	}

	public void setCs_gui(Integer cs_gui) {
		this.cs_gui = cs_gui;
	}

	public Integer getCs_db() {
		return cs_db;
	}

	public void setCs_db(Integer cs_db) {
		this.cs_db = cs_db;
	}

	public Integer getCs_web() {
		return cs_web;
	}

	public void setCs_web(Integer cs_web) {
		this.cs_web = cs_web;
	}

	public Integer getCs_network_prog() {
		return cs_network_prog;
	}

	public void setCs_network_prog(Integer cs_network_prog) {
		this.cs_network_prog = cs_network_prog;
	}

	public Integer getCs_design() {
		return cs_design;
	}

	public void setCs_design(Integer cs_design) {
		this.cs_design = cs_design;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Integer getEnglish_read() {
		return english_read;
	}

	public void setEnglish_read(Integer english_read) {
		this.english_read = english_read;
	}

	public Integer getEnglish_write() {
		return english_write;
	}

	public void setEnglish_write(Integer english_write) {
		this.english_write = english_write;
	}

	public Integer getEnglish_spoken() {
		return english_spoken;
	}

	public void setEnglish_spoken(Integer english_spoken) {
		this.english_spoken = english_spoken;
	}

	public Integer getSource_id() {
		return source_id;
	}

	public void setSource_id(Integer source_id) {
		this.source_id = source_id;
	}

	public String getMotivation_comment() {
		return motivation_comment;
	}

	public void setMotivation_comment(String motivation_comment) {
		this.motivation_comment = motivation_comment;
	}

	public String getComment2() {
		return comment2;
	}

	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getVisit_status() {
		return visit_status;
	}

	public void setVisit_status(Integer visit_status) {
		this.visit_status = visit_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	
	public HR_mark getHR_mark() {
		return hr_mark;
	}

	public void setHR_mark(HR_mark hr_mark) {
		this.hr_mark = hr_mark;
	}


	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public HR_mark getHr_mark() {
		return hr_mark;
	}

	public void setHr_mark(HR_mark hr_mark) {
		this.hr_mark = hr_mark;
	}

	public Tech_mark getTech_mark() {
		return tech_mark;
	}

	public void setTech_mark(Tech_mark tech_mark) {
		this.tech_mark = tech_mark;
	}

	@Override
	public int compareTo(Form comparedForm) {
		return this.user.getSurname().compareTo(comparedForm.getUser().getSurname());
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public Integer getInterview_id() {
		return interview_id;
	}

	public void setInterview_id(Integer interview_id) {
		this.interview_id = interview_id;
	}
}
