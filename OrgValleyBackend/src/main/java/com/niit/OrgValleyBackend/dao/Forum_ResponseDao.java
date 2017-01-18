package com.niit.OrgValleyBackend.dao;

import java.util.List;

import com.niit.OrgValleyBackend.model.Forum_Master;
import com.niit.OrgValleyBackend.model.Forum_Response;

public interface Forum_ResponseDao {

	public void SaveOrUpdate(Forum_Response rpl);
	public List<Forum_Response> list();
	public Forum_Response getFrm(int rid);
}
