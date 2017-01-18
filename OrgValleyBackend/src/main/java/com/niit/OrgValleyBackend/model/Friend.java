package com.niit.OrgValleyBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Friend {
@Id
private int id;
private String userId;
private String friendId;
private String status;
private char isOnline;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getFriendId() {
	return friendId;
}
public void setFriendId(String friendId) {
	this.friendId = friendId;
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
