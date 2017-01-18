package com.niit.OrgValleyBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OrgValleyBackend.dao.Blog_CommentDao;

import com.niit.OrgValleyBackend.model.Blog_Comment;




public class Blog_CommentTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.OrgValleyBackend");
	ctx.refresh();
	System.out.println("DONE");
	
	Blog_CommentDao bc = (Blog_CommentDao) ctx.getBean("blog_commentDao");
	System.out.println("doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
	Blog_Comment blog_comment=(Blog_Comment) ctx.getBean("blog_comment");
	System.out.println("22222222222222222222222222222222222222222");
//	forum_response.setResponse_date("1");
//	forum_response.setResponse_id(1);
//	forum_response.setResponse_tag("aaa");
//	forum_response.setResponse_user("aaa");
//	forum_response.setP_like(1);
//	forum_response.setP_dislike(1);
	
//	forum_reponseDao.insertORupdate(forum_response);// to insert
//	forum_reponseDao.delForum_Respone(100);// to delete
//	forum_response=forum_reponseDao.getFrm(1);
////	System.out.println(forum_response.getFusr());
	List <Blog_Comment> lst = bc.getAll();
	System.out.println(lst.size());
}
}
