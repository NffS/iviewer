package com.ncteam.iviewer.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Users_type")
public class UsersType implements Serializable{

	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="user_type_id")
	private Integer userTypeId;
	
	@Column(name="type_name")
	private String typeName;
	
	@OneToMany
	@JoinColumn(name="user_type_id")
	private Set<User> users;
	

	public Integer getUserTypeId() {
		return userTypeId;
	}
	
	public void setUserTypeId(Integer user_type_id) {
		this.userTypeId = user_type_id;
	}
	
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String type_name) {
		this.typeName = type_name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
