package com.project.dto;

public class Credential
{
private String email;
private String password;
public Credential(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
