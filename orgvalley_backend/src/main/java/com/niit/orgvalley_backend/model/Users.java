package com.niit.orgvalley_backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Users {
@Id
private int id;
private int login_id;
private String name;
private String pwd;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getLogin_id() {
	return login_id;
}
public void setLogin_id(int login_id) {
	this.login_id = login_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}

}
