package com.niit.OrgValleyBackend.dao;

import java.util.List;


import com.niit.OrgValleyBackend.model.Forum_Master;

public interface Forum_MasterDao {

	public void SaveOrUpdate(Forum_Master frm);
	public List<Forum_Master> list();//all view
	public void delete(int fid);
	public Forum_Master getFrm(int fid);//singl view
	public int getlikes(int fid);
}
