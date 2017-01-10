package com.niit.orgvalley_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.orgvalley_backend.dao.Blog_ResponseDao;
import com.niit.orgvalley_backend.model.Blog_Response;

public class Blog_ResponseDaoImpl implements Blog_ResponseDao {
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Blog_Response blog_response;
	
	 public Blog_ResponseDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	}
	

	public List<Blog_Response> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Blog_Response getForum_Response(int response_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertORupdate(Blog_Response blog_response) {
		// TODO Auto-generated method stub
		
	}

	public void delBlog_Response(int blog_response) {
		// TODO Auto-generated method stub
		
	}

}
