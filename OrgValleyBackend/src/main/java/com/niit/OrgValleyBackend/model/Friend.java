package com.niit.OrgValleyBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Friend {
@Id
private int friend_id;
private int user_id;
private String status;
private char isOnline;


public int getFriend_id() {
	return friend_id;
}
public void setFriend_id(int friend_id) {
	this.friend_id = friend_id;
}


public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public char getIsOnline() {
	return isOnline;
}
public void setIsOnline(char isOnline) {
	this.isOnline = isOnline;
}
}
