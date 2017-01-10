package com.niit.orgvalley_backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum_Response {
@Id
private int response_id;
private int post_id;
private String response_tag;
private String response_date;
private String response_user;
private int p_like;
private int p_dislike;
public int getResponse_id() {
	return response_id;
}
public void setResponse_id(int response_id) {
	this.response_id = response_id;
}
public int getPost_id() {
	return post_id;
}
public void setPost_id(int post_id) {
	this.post_id = post_id;
}
public String getResponse_tag() {
	return response_tag;
}
public void setResponse_tag(String response_tag) {
	this.response_tag = response_tag;
}
public String getResponse_date() {
	return response_date;
}
public void setResponse_date(String response_date) {
	this.response_date = response_date;
}
public String getResponse_user() {
	return response_user;
}
public void setResponse_user(String response_user) {
	this.response_user = response_user;
}
public int getP_like() {
	return p_like;
}
public void setP_like(int p_like) {
	this.p_like = p_like;
}
public int getP_dislike() {
	return p_dislike;
}
public void setP_dislike(int p_dislike) {
	this.p_dislike = p_dislike;
}

}
