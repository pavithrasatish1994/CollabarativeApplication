package com.niit.OrgValleyBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OrgValleyBackend.dao.FriendDao;
import com.niit.OrgValleyBackend.model.Friend;

public class FriendTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.OrgValleyBackend");
	ctx.refresh();
	System.out.println("Doneeeeeeeeeee");
	
	FriendDao friendDao = (FriendDao) ctx.getBean("friendDao");
	Friend friend = (Friend) ctx.getBean("friend");
//	friend.setFriend_id(1);
//	friend.setUser_id(1);
//	friend.setStatus("s");
//	friend.setIsOnline('s');
//	friendDao.SaveOrUpdate(friend);
	friendDao.delete(1);
	
}
}
