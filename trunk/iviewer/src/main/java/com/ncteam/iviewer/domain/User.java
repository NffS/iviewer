package com.ncteam.iviewer.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Users")
public class User {

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

@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
private Form form;

@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
private Set<HR_mark> hr_mark;

@ManyToOne
@JoinColumn(name="user_type_id", referencedColumnName = "user_type_id", insertable=false, updatable=false)
private Users_type users_type;


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
	this.form = form;
}

public Users_type getUsers_type() {
	return users_type;
}

public void setUsers_type(Users_type users_type) {
	this.users_type = users_type;
}

public Set<HR_mark> getHR_mark() {
	return hr_mark;
}

public void setHR_mark(Set<HR_mark> hr_mark) {
	this.hr_mark = hr_mark;
}


}
