package com.niit.orgvalley_backend.dao;

import java.util.List;

import com.niit.orgvalley_backend.model.Users;

public interface UsersDao {
	
public List<Users> list();
Users getUser(int id);
public void insertORupdate(Users users);
public void delUsers(int id);

}


