package com.niit.orgvalley_backend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.orgvalley_backend.dao.Forum_MasterDao;
import com.niit.orgvalley_backend.model.Forum_Master;

public class Forum_MasterTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.orgvalley_backend");
	ctx.refresh();
	System.out.println("DONE");
	
	Forum_MasterDao forum_masterDao = (Forum_MasterDao) ctx.getBean("forum_masterDao");
	System.out.println("doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	Forum_Master forum_master=(Forum_Master) ctx.getBean("forum_master");
	System.out.println("22222222222222222222222222222222222222222");
//	forum_master.setForum_id(10);
//	forum_master.setPost("abcd");
//	forum_master.setPost_date("10");
//	forum_master.setPost_id("10");
//	forum_master.setPosted_by("abcd");
//	forum_master.setTopic("abcd");
//	forum_masterDao.insertORupdate(forum_master);// to insert
	//forum_masterDao.delForum_Master(10);// to delete
	forum_master = forum_masterDao.getForum_Master(1);
	System.out.println(forum_master.getPosted_by());
	
//	List <Forum_Master> lst = fm.list();
//	System.out.println(lst.size());
	
}
}
