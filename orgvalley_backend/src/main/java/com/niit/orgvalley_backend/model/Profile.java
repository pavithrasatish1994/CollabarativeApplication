package com.niit.orgvalley_backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Profile {
@Id

private int pid;
private String name;
private String skills;
private String profile;
private String location;
private String phone_no;
private String image;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSkills() {
	return skills;
}
public void setSkills(String skills) {
	this.skills = skills;
}
public String getProfile() {
	return profile;
}
public void setProfile(String profile) {
	this.profile = profile;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
}
