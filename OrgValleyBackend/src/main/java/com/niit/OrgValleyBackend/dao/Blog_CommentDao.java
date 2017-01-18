package com.niit.OrgValleyBackend.dao;

import java.util.List;

import com.niit.OrgValleyBackend.model.Blog_Comment;



public interface Blog_CommentDao {

	public void SaveOrUpdate(Blog_Comment cmt);
	public List<Blog_Comment> getCmts(int id);
	public List<Blog_Comment> getAll();
}
