package com.myallocation.allocator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class Users {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="user_id")
private int userId;

@Column(name="first_name")
@NotNull
@Size(min=2,max=12)
private String firstName;

@Column(name="last_name")
@NotNull
@Size(min=2,max=12)
private String lastName;

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Column(name="email")
@Email
@NotNull
private String email;

@Column(name="user_name")
@NotNull
@Size(min=2,max=12)
private String userName;

@Column(name="user_password")
@NotNull
@Size(min=5,max=15)
private String userPassword;

public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}


	
}
