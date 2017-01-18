package com.niit.OrgValleyBackend.dao;

import java.util.List;

import com.niit.OrgValleyBackend.model.Job;

public interface JobDao {
	
	
public List<Job> list();
public void SaveOrUpdate (Job job);
public void delete (int jid);
public Job getJob(int jid);

}

