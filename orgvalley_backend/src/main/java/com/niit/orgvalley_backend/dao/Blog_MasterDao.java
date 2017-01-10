package com.niit.orgvalley_backend.dao;

import java.util.List;

import com.niit.orgvalley_backend.model.Blog_Master;

public interface Blog_MasterDao {
	
public List<Blog_Master> list();
Blog_Master getBlog_Master(int blog_id);
public void insertORupdate(Blog_Master blog_master);
public void delBlog_Master(int blog_id);

}
