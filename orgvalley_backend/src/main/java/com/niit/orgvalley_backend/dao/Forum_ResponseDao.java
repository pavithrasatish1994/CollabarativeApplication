package com.niit.orgvalley_backend.dao;

import java.util.List;

import com.niit.orgvalley_backend.model.Forum_Response;

public interface Forum_ResponseDao {
	
public List<Forum_Response> list();
Forum_Response getForum_Response(int response_id);
public void insertORupdate(Forum_Response forum_response);
public void delForum_Respone(int forum_response);
}
