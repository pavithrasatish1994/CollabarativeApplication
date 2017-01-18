package com.niit.OrgValleyBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Blog_Comment {

	@Id
	
	private int cid;
	private int bid;
	private String cmt;
	private String busr;
	private String cdat;
	
	public Blog_Comment() {
		
	}


	public Blog_Comment(int cid, int bid, String cmt, String busr, String cdat) {
		
		this.cid = cid;
		this.bid = bid;
		this.cmt = cmt;
		this.busr = busr;
		this.cdat = cdat;
	}
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public String getBusr() {
		return busr;
	}

	public void setBusr(String busr) {
		this.busr = busr;
	}

	public String getCdat() {
		return cdat;
	}

	public void setCdat(String cdat) {
		this.cdat = cdat;
	}

	
}
