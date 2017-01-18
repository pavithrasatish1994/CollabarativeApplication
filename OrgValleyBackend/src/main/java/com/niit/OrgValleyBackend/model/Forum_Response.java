package com.niit.OrgValleyBackend.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum_Response {
@Id
private int rid;
private int fid;
private String rpl;
private String fusr;
private Date rdat;
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getRpl() {
	return rpl;
}
public void setRpl(String rpl) {
	this.rpl = rpl;
}
public String getFusr() {
	return fusr;
}
public void setFusr(String fusr) {
	this.fusr = fusr;
}
public Date getRdat() {
	return rdat;
}
public void setRdat(Date rdat) {
	this.rdat = rdat;
}


}
