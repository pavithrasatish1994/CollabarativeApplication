package com.niit.OrgValleyBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OrgValleyBackend.dao.Job_CommentDao;
import com.niit.OrgValleyBackend.model.Job_Comment;

public class Job_CommentTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.OrgValleyBackend");
	ctx.refresh();
	System.out.println("done");
	Job_CommentDao job_commentDao = (Job_CommentDao) ctx.getBean("job_commentDao");
	Job_Comment job_comment = (Job_Comment)ctx.getBean("job_comment");
	job_comment.setCid(6);
	job_comment.setJid(1);
    job_comment.setJusr("aaa");
    job_commentDao.SaveOrUpdate(job_comment);
//	List <Job_Comment> lst = job_commentDao.getAll();
//	System.out.println(lst.size());
}
}
