package com.niit.orgvalley_backend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Blog_ResponseTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.orgvalley_backend");
	ctx.refresh();
	System.out.println("DONE");
}
}
