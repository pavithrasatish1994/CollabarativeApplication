package com.niit.OrgValleyBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OrgValleyBackend.dao.Blog_MasterDao;
import com.niit.OrgValleyBackend.model.Blog_Master;


public class Blog_MasterTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.OrgValleyBackend");
		ctx.refresh();
		System.out.println("DONE");
	
		Blog_MasterDao blog_masterDao = (Blog_MasterDao) ctx.getBean("blog_masterDao");
		Blog_Master blog_master = (Blog_Master) ctx.getBean("blog_master");
		blog_master.setBid(3);
		blog_master.setBtitle("NIIT");
		blog_master.setBusr("aaa");
		
		List <Blog_Master> lst = blog_masterDao.list();
		System.out.println(lst.size());
		
		blog_masterDao.SaveOrUpdate(blog_master);
	
		
		List <Blog_Master> lst1 = blog_masterDao.list();
		System.out.println(lst.size());
	}

}
