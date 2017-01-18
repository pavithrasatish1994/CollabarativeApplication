package com.niit.OrgValleyBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OrgValleyBackend.dao.JobDao;
import com.niit.OrgValleyBackend.model.Job;

public class JobTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.OrgValleyBackend");
	ctx.refresh();
	System.out.println("done");
	
	JobDao jobDao = (JobDao) ctx.getBean("jobDao");
	Job job = (Job) ctx.getBean("job");
	List <Job> lst = jobDao.list();
	System.out.println(lst.size());
	
}
}
