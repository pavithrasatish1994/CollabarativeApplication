package com.niit.OrgValleyBackend.config;
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

import com.niit.OrgValleyBackend.dao.UsersDao;
import com.niit.OrgValleyBackend.dao.Blog_CommentDao;
import com.niit.OrgValleyBackend.dao.Blog_MasterDao;
import com.niit.OrgValleyBackend.dao.Forum_MasterDao;
import com.niit.OrgValleyBackend.dao.Forum_ResponseDao;
import com.niit.OrgValleyBackend.dao.FriendDao;
import com.niit.OrgValleyBackend.dao.JobDao;
import com.niit.OrgValleyBackend.dao.Job_CommentDao;
import com.niit.OrgValleyBackend.daoimpl.UsersDaoImpl;
import com.niit.OrgValleyBackend.daoimpl.Blog_CommentDaoImpl;
import com.niit.OrgValleyBackend.daoimpl.Blog_MasterDaoImpl;
import com.niit.OrgValleyBackend.daoimpl.Forum_MasterDaoImpl;
import com.niit.OrgValleyBackend.daoimpl.Forum_ResponseDaoImpl;
import com.niit.OrgValleyBackend.daoimpl.FriendDaoImpl;
import com.niit.OrgValleyBackend.daoimpl.JobDaoImpl;
import com.niit.OrgValleyBackend.daoimpl.Job_CommentDaoImpl;
import com.niit.OrgValleyBackend.model.Users;
import com.niit.OrgValleyBackend.model.Blog_Comment;
import com.niit.OrgValleyBackend.model.Blog_Master;
import com.niit.OrgValleyBackend.model.Forum_Master;
import com.niit.OrgValleyBackend.model.Forum_Response;
import com.niit.OrgValleyBackend.model.Friend;
import com.niit.OrgValleyBackend.model.Job;
import com.niit.OrgValleyBackend.model.Job_Comment;


@Configuration
@ComponentScan("com.niit.OrgValleyBackend")
@EnableTransactionManagement   
public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("XEDB");
		dataSource.setPassword("root");
		System.out.println("*******Oracle Data source initialized****");

		return dataSource;
	}

	
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.hbm2ddl.auto", "update");
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
		sessionBuilder.addAnnotatedClass(Blog_Comment.class);
		sessionBuilder.addAnnotatedClass(Job.class);
		sessionBuilder.addAnnotatedClass(Job_Comment.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
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
	@Bean(name="blog_commentDao")
	public Blog_CommentDao getBlog_ResponseDao(SessionFactory sessionFactory)
	{
		return new Blog_CommentDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean(name="jobDao")
	public JobDao getJobDao(SessionFactory sessionFactory)
	{
		return new JobDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="job_commentDao")
	public Job_CommentDao getJob_CommentDao(SessionFactory sessionFactory)
	{
		return new Job_CommentDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="friendDao")
	public FriendDao getFriendDao(SessionFactory sessionFactory)
	{
		return new FriendDaoImpl(sessionFactory);
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
	@Autowired
	@Bean(name="blog_master")
	public Blog_Master getBlog_Master()
	{
		return new Blog_Master();
	}
	@	Autowired
	@Bean(name="blog_comment")
	public Blog_Comment getBlog_Response()
	{
		return new Blog_Comment();
	}
	@Autowired
	@Bean(name="job")
	public Job getJob()
	{
		return new Job();
	}
	@Autowired
	@Bean(name="job_comment")
	public Job_Comment getJob_Comment()
	{
		return new Job_Comment();
	}
	
	@Autowired
	@Bean(name="friend")
	public Friend getFriend()
	{
		return new Friend();
	}
}