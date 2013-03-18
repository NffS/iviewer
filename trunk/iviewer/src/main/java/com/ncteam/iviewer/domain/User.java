package com.ncteam.iviewer.domain;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="Users")
public class User implements Serializable{

@Id
@GeneratedValue(generator="increment")
@GenericGenerator(name="increment", strategy = "increment")
@Column(name="user_id")
private Integer userId;

@Column(name="email")
private String email;

@Column(name="password")
private String password;

@Column(name="first_name")
private String firstName;

@Column(name="surname")
private String surname;

@Column(name="last_name")
private String lastName;

@Column(name="foto")
private String foto;

@Column(name="user_type_id")
private Integer userTypeId;

@Column(name="reg_date")
private String stringRegDate;

@Column(name="reg_date", updatable=false, insertable=false)
private Date regDate;

@OneToOne
@JoinColumn(name="user_id")
private Form form;

@OneToOne
@JoinColumn(name="user_id")
private HRMark hrMark;

@OneToOne
@JoinColumn(name="user_id")
private TechMark techMark;

@ManyToOne
@JoinColumn(name="user_type_id", referencedColumnName = "user_type_id", insertable=false, updatable=false)
private UsersType usersType;


public void setUserId(Integer id){
	this.userId=id;
}


public Integer getUserId(){
	return userId;
}

public void setPassword(String password){
	this.password=password;
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

public void setLastName(String last_name) {
	this.lastName = last_name;
}


public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}


public Integer getUserTypeId() {
	return userTypeId;
}

public void setUserTypeId(Integer user_type_id) {
	this.userTypeId = user_type_id;
}


public String getPassword() {
	return password;
}


public String getFirstName() {
	return firstName;
}

public void setFirstName(String first_name) {
	this.firstName = first_name;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Form getForm() {
	return form;
}

public void setForm(Form form) {
	this.form=form;
}

public UsersType getUsersType() {
	return usersType;
}

public void setUsersType(UsersType users_type) {
	this.usersType = users_type;
}

public HRMark getHR_mark() {
	return hrMark;
}

public void setHR_mark(HRMark hr_mark) {
	this.hrMark = hr_mark;
}


public HRMark getHrMark() {
	return hrMark;
}


public void setHrMark(HRMark hr_mark) {
	this.hrMark = hr_mark;
}


public TechMark getTechMark() {
	return techMark;
}


public void setTechMark(TechMark tech_mark) {
	this.techMark = tech_mark;
}


public String getStringRegDate() {
	return stringRegDate;
}


public void setStringRegDate(String stringReg_date) {
	this.stringRegDate = stringReg_date;
}


public Date getRegDate() {
	return regDate;
}


public void setRegDate(Date reg_date) {
	this.regDate = reg_date;
}


}
