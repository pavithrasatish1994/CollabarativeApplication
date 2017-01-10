package com.niit.orgvalley_backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.orgvalley_backend.dao.Forum_ResponseDao;
import com.niit.orgvalley_backend.model.Forum_Response;


public class Forum_ResponseTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.orgvalley_backend");
	ctx.refresh();
	System.out.println("DONE");
	
	Forum_ResponseDao forum_reponseDao = (Forum_ResponseDao) ctx.getBean("forum_responseDao");
	System.out.println("doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	Forum_Response forum_response=(Forum_Response) ctx.getBean("forum_response");
	System.out.println("22222222222222222222222222222222222222222");
//	forum_response.setResponse_date("1");
//	forum_response.setResponse_id(1);
//	forum_response.setResponse_tag("aaa");
//	forum_response.setResponse_user("aaa");
//	forum_response.setP_like(1);
//	forum_response.setP_dislike(1);
	
//	forum_reponseDao.insertORupdate(forum_response);// to insert
//	forum_reponseDao.delForum_Respone(100);// to delete
	forum_response=forum_reponseDao.getForum_Response(1);
	System.out.println(forum_response.getResponse_user());
//	List <Forum_Master> lst = fm.list();
//	System.out.println(lst.size());
}
}
