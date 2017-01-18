package com.niit.OrgValleyBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Controller;

@Entity
@Controller
public class Job_Comment {
@Id
private int cid;
private int jid;
private String jusr;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getJid() {
	return jid;
}
public void setJid(int jid) {
	this.jid = jid;
}
public String getJusr() {
	return jusr;
}
public void setJusr(String jusr) {
	this.jusr = jusr;
}

}
