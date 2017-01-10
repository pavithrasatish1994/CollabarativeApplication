package com.niit.orgvalley_backend.dao;

import java.util.List;

import com.niit.orgvalley_backend.model.Blog_Response;

public interface Blog_ResponseDao {

	
public List<Blog_Response> list();
Blog_Response getForum_Response(int response_id);
public void insertORupdate(Blog_Response blog_response);
public void delBlog_Response(int blog_response);
}
