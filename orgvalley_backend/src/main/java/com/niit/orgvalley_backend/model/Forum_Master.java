package com.niit.orgvalley_backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum_Master {
@Id
private int forum_id;
private String post;
private String topic;
private String post_date;
private String posted_by;
private String post_id;
public int getForum_id() {
	return forum_id;
}
public void setForum_id(int forum_id) {
	this.forum_id = forum_id;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
public String getTopic() {
	return topic;
}
public void setTopic(String topic) {
	this.topic = topic;
}
public String getPost_date() {
	return post_date;
}
public void setPost_date(String post_date) {
	this.post_date = post_date;
}
public String getPosted_by() {
	return posted_by;
}
public void setPosted_by(String posted_by) {
	this.posted_by = posted_by;
}
public String getPost_id() {
	return post_id;
}
public void setPost_id(String post_id) {
	this.post_id = post_id;
}

}
