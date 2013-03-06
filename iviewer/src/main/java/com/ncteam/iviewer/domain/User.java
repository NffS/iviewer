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
private Integer user_id;

@Column(name="email")
private String email;

@Column(name="password")
private String password;

@Column(name="first_name")
private String first_name;

@Column(name="surname")
private String surname;

@Column(name="last_name")
private String last_name;

@Column(name="foto")
private String foto;

@Column(name="user_type_id")
private Integer user_type_id;

@Column(name="reg_date")
private String stringReg_date;

@Column(name="reg_date", updatable=false, insertable=false)
private Date reg_date;

@OneToOne
@JoinColumn(name="user_id")
private Form form;

@OneToOne
@JoinColumn(name="user_id")
private HRMark hr_mark;

@OneToOne
@JoinColumn(name="user_id")
private TechMark tech_mark;

@ManyToOne
@JoinColumn(name="user_type_id", referencedColumnName = "user_type_id", insertable=false, updatable=false)
private UsersType users_type;


public void setUser_id(Integer id){
	this.user_id=id;
}


public Integer getUser_id(){
	return user_id;
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


public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}


public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}


public Integer getUser_type_id() {
	return user_type_id;
}

public void setUser_type_id(Integer user_type_id) {
	this.user_type_id = user_type_id;
}


public String getPassword() {
	return password;
}


public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
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

public UsersType getUsers_type() {
	return users_type;
}

public void setUsers_type(UsersType users_type) {
	this.users_type = users_type;
}

public HRMark getHR_mark() {
	return hr_mark;
}

public void setHR_mark(HRMark hr_mark) {
	this.hr_mark = hr_mark;
}


public HRMark getHr_mark() {
	return hr_mark;
}


public void setHr_mark(HRMark hr_mark) {
	this.hr_mark = hr_mark;
}


public TechMark getTech_mark() {
	return tech_mark;
}


public void setTech_mark(TechMark tech_mark) {
	this.tech_mark = tech_mark;
}


public String getStringReg_date() {
	return stringReg_date;
}


public void setStringReg_date(String stringReg_date) {
	this.stringReg_date = stringReg_date;
}


public Date getReg_date() {
	return reg_date;
}


public void setReg_date(Date reg_date) {
	this.reg_date = reg_date;
}


}
