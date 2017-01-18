package com.niit.OrgValleyBackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Job {
@Id
private int jid;
private String title;
private String qualification;
private String description;
private Date jdat;
public int getJid() {
	return jid;
}
public void setJid(int jid) {
	this.jid = jid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getjdat() {
	return jdat;
}
public void setjdat(Date jdat) {
	this.jdat = jdat;
}

}
