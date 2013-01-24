package com.ncteam.iviewer.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Users_type")
public class Users_type {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="user_type_id")
	private Integer user_type_id;
	
	@Column(name="type_name")
	private String type_name;
	
	@OneToMany(mappedBy="users_type", cascade=CascadeType.ALL)
	private Set<User> users;
	

	public Integer getUser_type_id() {
		return user_type_id;
	}
	
	public void setUser_type_id(Integer user_type_id) {
		this.user_type_id = user_type_id;
	}
	
	
	public String getType_name() {
		return type_name;
	}
	
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
