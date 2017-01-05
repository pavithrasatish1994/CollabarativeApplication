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
import com.niit.orgvalley_backend.daoimpl.UsersDaoImpl;
import com.niit.orgvalley_backend.model.Users;


@Configuration
@ComponentScan("com.niit.orgvalley_backend")
@EnableTransactionManagement   
public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:8081:XE");//Tried this but not connecte
//		dataSource.setUrl("jdbc:oracle:thin:@localhost:8081:ORGDB");//Tried this but not connecte
		dataSource.setUsername("system");
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
}