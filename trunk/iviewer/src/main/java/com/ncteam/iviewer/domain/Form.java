package com.ncteam.iviewer.domain;

import java.io.Serializable;
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
	private Integer formId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="university_id")
	private Integer universityId;
	
	@Column(name="faculty_id")
	private Integer facultyId;
	
	@Column(name="course")
	private Integer course;
	
	@Column(name="end_year")
	private String endYear;
	
	@Column(name="email2")
	private String email2;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="another_contact")
	private String anotherContact;
	
	@Column(name="interest_tc")
	private String interestTc;
	
	@Column(name="interest_nc")
	private String interestNc;
	
	@Column(name="interest_area_po")
	private String interestAreaPo;
	
	@Column(name="interest_area_other")
	private String interestAreaOther;
	
	@Column(name="job_ar_deep_spec")
	private String jobArDeepSpec;
	
	@Column(name="job_ar_varied")
	private String jobArVaried;
	
	@Column(name="job_ar_manage")
	private String jobArManage;
	
	@Column(name="job_ar_sales")
	private String jobArSales;
	
	@Column(name="job_ar_other")
	private String jobArOther;
	
	@Column(name="prog_lang_c")
	private Integer progLangC;
	
	@Column(name="prog_lang_java")
	private Integer progLangJava;
	
	@Column(name="prog_lang_other")
	private String  progLangOther;
	
	@Column(name="prog_lang_other_mark")
	private Integer  progLangOtherMark;
	
	@Column(name="cs_network_tech")
	private Integer csNetworkTech;
	
	@Column(name="cs_algorithms")
	private Integer csAlgorithms;
	
	@Column(name="cs_oop")
	private Integer csOop;
	
	@Column(name="cs_gui")
	private Integer csGui;
	
	@Column(name="cs_db")
	private Integer csDb;
	
	@Column(name="cs_web")
	private Integer csWeb;
	
	@Column(name="cs_network_prog")
	private Integer csNetworkProg;
	
	@Column(name="cs_design")
	private Integer csDesign;
	
	@Column(name="cs_other")
	private String  csOther;
	
	@Column(name="cs_other_mark")
	private Integer csOtherMark;
	
	@Column(name="experience")
	private String experience;
	
	@Column(name="english_read")
	private Integer englishRead;
	
	@Column(name="english_write")
	private Integer englishWrite;
	
	@Column(name="english_spoken")
	private Integer englishSpoken;
	
	@Column(name="source_id")
	private Integer sourceId;
	
	@Column(name="motivation_comment")
	private String motivation_comment;
	
	@Column(name="comment2")
	private String comment2;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="interview_id")
	private Integer interviewId;
	
	@Column(name="visit_status")
	private Integer visitStatus;
	
	@OneToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false)
    private User user;
	
	@OneToOne
	@JoinColumn(name="hr_mark_id", insertable=false, updatable=false)
	private HRMark hrMark;
	
	@OneToOne
	@JoinColumn(name="form_id", insertable=false, updatable=false)
	private TechMark techMark;	
	
	@ManyToOne
	@JoinColumn(name="interview_id", insertable=false, updatable=false)
	private Interview interview;
	
	@ManyToOne
	@JoinColumn(name="university_id", insertable=false, updatable=false)
	private University university;
	
	@ManyToOne
	@JoinColumn(name="faculty_id", insertable=false, updatable=false)
	private Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name="source_id", insertable=false, updatable=false)
	private Source source;



	@Override
	public int compareTo(Form comparedForm) {
		return this.user.getSurname().compareTo(comparedForm.getUser().getSurname());
	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
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

	public String getAnotherContact() {
		return anotherContact;
	}

	public void setAnotherContact(String anotherContact) {
		this.anotherContact = anotherContact;
	}

	public String getInterestTc() {
		return interestTc;
	}

	public void setInterestTc(String interestTc) {
		this.interestTc = interestTc;
	}

	public String getInterestNc() {
		return interestNc;
	}

	public void setInterestNc(String interestNc) {
		this.interestNc = interestNc;
	}

	public String getInterestAreaPo() {
		return interestAreaPo;
	}

	public void setInterestAreaPo(String interestAreaPo) {
		this.interestAreaPo = interestAreaPo;
	}

	public String getInterestAreaOther() {
		return interestAreaOther;
	}

	public void setInterestAreaOther(String interestAreaOther) {
		this.interestAreaOther = interestAreaOther;
	}

	public String getJobArDeepSpec() {
		return jobArDeepSpec;
	}

	public void setJobArDeepSpec(String jobArDeepSpec) {
		this.jobArDeepSpec = jobArDeepSpec;
	}

	public String getJobArVaried() {
		return jobArVaried;
	}

	public void setJobArVaried(String jobArVaried) {
		this.jobArVaried = jobArVaried;
	}

	public String getJobArManage() {
		return jobArManage;
	}

	public void setJobArManage(String jobArManage) {
		this.jobArManage = jobArManage;
	}

	public String getJobArSales() {
		return jobArSales;
	}

	public void setJobArSales(String jobArSales) {
		this.jobArSales = jobArSales;
	}

	public String getJobArOther() {
		return jobArOther;
	}

	public void setJobArOther(String jobArOther) {
		this.jobArOther = jobArOther;
	}

	public Integer getProgLangC() {
		return progLangC;
	}

	public void setProgLangC(Integer progLangC) {
		this.progLangC = progLangC;
	}

	public Integer getProgLangJava() {
		return progLangJava;
	}

	public void setProgLangJava(Integer progLangJava) {
		this.progLangJava = progLangJava;
	}

	public String getProgLangOther() {
		return progLangOther;
	}

	public void setProgLangOther(String progLangOther) {
		this.progLangOther = progLangOther;
	}

	public Integer getProgLangOtherMark() {
		return progLangOtherMark;
	}

	public void setProgLangOther(Integer progLangOtherMark) {
		this.progLangOtherMark = progLangOtherMark;
	}


	public Integer getCsNetworkTech() {
		return csNetworkTech;
	}

	public void setCsNetworkTech(Integer csNetworkTech) {
		this.csNetworkTech = csNetworkTech;
	}

	public Integer getCsAlgorithms() {
		return csAlgorithms;
	}

	public void setCsAlgorithms(Integer csAlgorithms) {
		this.csAlgorithms = csAlgorithms;
	}

	public Integer getCsOop() {
		return csOop;
	}

	public void setCsOop(Integer csOop) {
		this.csOop = csOop;
	}

	public Integer getCsGui() {
		return csGui;
	}

	public void setCsGui(Integer csGui) {
		this.csGui = csGui;
	}

	public Integer getCsDb() {
		return csDb;
	}

	public void setCsDb(Integer csDb) {
		this.csDb = csDb;
	}

	public Integer getCsWeb() {
		return csWeb;
	}

	public void setCsWeb(Integer csWeb) {
		this.csWeb = csWeb;
	}

	public Integer getCsNetworkProg() {
		return csNetworkProg;
	}

	public void setCsNetworkProg(Integer csNetworkProg) {
		this.csNetworkProg = csNetworkProg;
	}

	public Integer getCsDesign() {
		return csDesign;
	}

	public void setCsDesign(Integer csDesign) {
		this.csDesign = csDesign;
	}

	public String getCsOther() {
		return csOther;
	}

	public void setCsOther(String csOther) {
		this.csOther = csOther;
	}

	public Integer getCsOtherMark() {
		return csOtherMark;
	}

	public void setCsOtherMark(Integer csOtherMark) {
		this.csOtherMark = csOtherMark;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Integer getEnglishRead() {
		return englishRead;
	}

	public void setEnglishRead(Integer englishRead) {
		this.englishRead = englishRead;
	}

	public Integer getEnglishWrite() {
		return englishWrite;
	}

	public void setEnglishWrite(Integer englishWrite) {
		this.englishWrite = englishWrite;
	}

	public Integer getEnglishSpoken() {
		return englishSpoken;
	}

	public void setEnglishSpoken(Integer englishSpoken) {
		this.englishSpoken = englishSpoken;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
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

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public Integer getVisitStatus() {
		return visitStatus;
	}

	public void setVisitStatus(Integer visitStatus) {
		this.visitStatus = visitStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HRMark getHrMark() {
		return hrMark;
	}

	public void setHrMark(HRMark hrMark) {
		this.hrMark = hrMark;
	}

	public TechMark getTechMark() {
		return techMark;
	}

	public void setTechMark(TechMark techMark) {
		this.techMark = techMark;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
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
}
