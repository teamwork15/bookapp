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
@Table(name="store")
public class Storekeeper {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="store_id")
private int storeId;

@Column(name="first_name")
@NotNull
@Size(min=2,max=12)
private String firstName;

@Column(name="last_name")
@NotNull
@Size(min=2,max=12)
private String lastName;

@Column(name="email")
@Email
@NotNull
private String email;

@Column(name="store_name")
@NotNull
@Size(min=2,max=12)
private String storeName;

@Column(name="store_password")
@NotNull
@Size(min=5,max=15)
private String storePassword;

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



public int getStoreId() {
	return storeId;
}

public void setStoreId(int storeId) {
	this.storeId = storeId;
}

public String getStoreName() {
	return storeName;
}

public void setStoreName(String storeName) {
	this.storeName = storeName;
}

public String getStorePassword() {
	return storePassword;
}

public void setStorePassword(String storePassword) {
	this.storePassword = storePassword;
}


}
