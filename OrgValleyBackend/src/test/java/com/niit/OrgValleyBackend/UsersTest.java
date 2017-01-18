package com.niit.OrgValleyBackend;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.OrgValleyBackend.dao.UsersDao;
import com.niit.OrgValleyBackend.model.Users;

public class UsersTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.OrgValleyBackend");
		ctx.refresh();
		System.out.println("DONE");

		UsersDao ud = (UsersDao) ctx.getBean("usersDao");
		Users users=(Users) ctx.getBean("users");
//		users.setId(100);// to insert the data
//		users.setLogin_id(100);
//		users.setName("zzz");xxxxxxxxxxxxxx
//		users.setPwd("zzz");
//		usersDao.insertORupdate(users);// to insert
//		usersDao.delUsers(1);// to delete
	//	users=usersDao.getUser(2);// to fetch 
	//	System.out.println(users.getName());// to fetch
		
		List <Users> lst = ud.list();
		System.out.println(lst.size());
//		
		
}
}
