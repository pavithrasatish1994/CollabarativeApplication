package com.niit.OrgValleyBackend.dao;

import java.util.List;

import com.niit.OrgValleyBackend.model.Job_Comment;

public interface Job_CommentDao {
	
	public void SaveOrUpdate(Job_Comment cmt);
	public List<Job_Comment> getCmts(int id);
	public List<Job_Comment> getAll();
}
