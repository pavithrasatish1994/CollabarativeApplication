package com.niit.orgvalley_backend.dao;

import java.util.List;

import com.niit.orgvalley_backend.model.Forum_Master;

public interface Forum_MasterDao {

	
public List<Forum_Master> list();
Forum_Master getForum_Master(int forum_id);
public void insertORupdate(Forum_Master forum_master);
public void delForum_Master(int forum_id);

	
	
}
