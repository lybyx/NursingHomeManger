package com.lybxxx.model;

/**
 * @author lybxxx
 * 
 */
public class User {
	String id;
    String userName;
    String userPassword;
    
    
    
public User() {
		super();
	}
public User(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
@Override
public String toString() {
	return this.getUserName();
}
  
}