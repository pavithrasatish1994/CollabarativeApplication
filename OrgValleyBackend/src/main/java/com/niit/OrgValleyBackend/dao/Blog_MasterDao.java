package com.niit.OrgValleyBackend.dao;

import java.util.List;

import com.niit.OrgValleyBackend.model.Blog_Master;

public interface Blog_MasterDao {
public  void SaveOrUpdate(Blog_Master blog);
	
	public List<Blog_Master> list();
	
	public void delete(int id);
	
	public Blog_Master getBlog(int id);

}
