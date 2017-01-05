package com.niit.orgvalley_backend;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.orgvalley_backend.dao.UsersDao;
import com.niit.orgvalley_backend.model.Users;

public class UsersTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.orgvalley_backend");
		ctx.refresh();
		System.out.println("DONE");

		UsersDao ud = (UsersDao) ctx.getBean("usersDao");
		
		List <Users> lst = ud.list();
		String x=lst!=null?"DOneeeeeeeeeeeeeeeeeeeeeeeeeee":"Notdon";
		System.out.println(x);
		
}
}
