package com.niit.orgvalley_backend.config;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.orgvalley_backend.dao.UsersDao;
import com.niit.orgvalley_backend.dao.Blog_MasterDao;
import com.niit.orgvalley_backend.dao.Forum_MasterDao;
import com.niit.orgvalley_backend.dao.Forum_ResponseDao;
import com.niit.orgvalley_backend.daoimpl.UsersDaoImpl;
import com.niit.orgvalley_backend.daoimpl.Blog_MasterDaoImpl;
import com.niit.orgvalley_backend.daoimpl.Forum_MasterDaoImpl;
import com.niit.orgvalley_backend.daoimpl.Forum_ResponseDaoImpl;
import com.niit.orgvalley_backend.model.Users;
import com.niit.orgvalley_backend.model.Blog_Master;
import com.niit.orgvalley_backend.model.Forum_Master;
import com.niit.orgvalley_backend.model.Forum_Response;


@Configuration
@ComponentScan("com.niit.orgvalley_backend")
@EnableTransactionManagement   
public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("XE");
		dataSource.setPassword("root");
		System.out.println("*******Oracle Data source initialized****");

		return dataSource;
	}

	
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
//		properties.put("hibernate.hbm2ddl.auto", "create");
		System.out.println("*******HibernateProperties initialized****");
		return properties;
	}
	

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
//		SessionFactory sessionFactory=null;
		try{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		
		sessionBuilder.addAnnotatedClasses(Users.class);
		sessionBuilder.addAnnotatedClass(Forum_Master.class);
		sessionBuilder.addAnnotatedClass(Forum_Response.class);
		sessionBuilder.addAnnotatedClass(Blog_Master.class);
		System.out.println("********SessionFactory initialized**************");
		return sessionBuilder.buildSessionFactory();
		}catch(Exception e){System.out.println("Hellloooooooooo "+e.toString());}
		return null;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("******HibernateTransactionManager intialized****");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name="usersDao")
	public UsersDao getUsersDao(SessionFactory sessionFactory)
	{
		return new UsersDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="forum_masterDao")
	public Forum_MasterDao getForum_MasterDao(SessionFactory sessionFactory)
	{
		return new Forum_MasterDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="forum_responseDao")
	public Forum_ResponseDao getForum_ResponseDao(SessionFactory sessionFactory)
	{
		return new Forum_ResponseDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="blog_masterDao")
	public Blog_MasterDao getBlog_MasterDao (SessionFactory sessionFactory)
	{
		return new Blog_MasterDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="users")
	 public Users getUsers()
    {
   	 return new Users();
    }
	@Autowired
	@Bean(name="forum_master")
	public Forum_Master getForum_Master()
	{
		return new Forum_Master();
	}
	@Autowired
	@Bean(name="forum_response")
	public Forum_Response getForum_Response()
	{
		return new Forum_Response();
	}
	
	
}