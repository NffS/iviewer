package test;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
private String email;
private String password;
private String first_name;
private String surname;
private String last_name;
private String foto;
private Integer user_type_id;

@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
private Form form;

@OneToOne
@PrimaryKeyJoinColumn
private Users_type users_type;

public User(){}

public void setUserId(Integer id){
	this.user_id=id;
}


public Integer getUserId(){
	return user_id;
}

public void setPassword(String password){
	this.password=password;
}

@Column(name="surname")
public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

@Column(name="last_name")
public String getLast_name() {
	return last_name;
}

public void setLast_name(String last_name) {
	this.last_name = last_name;
}

@Column(name="foto")
public String getFoto() {
	return foto;
}

public void setFoto(String foto) {
	this.foto = foto;
}

@Column(name="user_type_id")
public Integer getUser_type_id() {
	return user_type_id;
}

public void setUser_type_id(Integer user_type_id) {
	this.user_type_id = user_type_id;
}

@Column(name="password")
public String getPassword() {
	return password;
}

@Column(name="first_name")
public String getFirst_name() {
	return first_name;
}

public void setFirst_name(String first_name) {
	this.first_name = first_name;
}

@Column(name="email")
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


}
