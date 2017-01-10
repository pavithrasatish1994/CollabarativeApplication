package com.niit.orgvalley_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.orgvalley_backend.dao.Blog_MasterDao;
import com.niit.orgvalley_backend.model.Blog_Master;

public class Blog_MasterDaoImpl implements Blog_MasterDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Blog_MasterDao blog_masterDao;
	
	public Blog_MasterDaoImpl(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Blog_Master> list() {
		// TODO Auto-generated method stub
		return null;
	}
@Transactional
	public Blog_Master getBlog_Master(int blog_id) {
		// TODO Auto-generated method stub
		return null;
	}
@Transactional
	public void insertORupdate(Blog_Master blog_master) {
		// TODO Auto-generated method stub
		
	}
@Transactional
	public void delBlog_Master(int blog_id) {
		// TODO Auto-generated method stub
		
	}

}
