package com.niit.OrgValleyBackend.dao;

import java.util.List;

import com.niit.OrgValleyBackend.model.Profile;


public interface ProfileDao {

	public List<Profile> list();
    Profile getProfile(int id);
    public void insertORupdate(Profile pro);
    public void delProfile(int id);
	
}
