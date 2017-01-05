package com.niit.orgvalley_backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.orgvalley_backend.dao.UsersDao;
import com.niit.orgvalley_backend.model.Users;


public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UsersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Users> list() {
		@SuppressWarnings("unchecked")
		List<Users> list = (List<Users>) sessionFactory.getCurrentSession()
				.createCriteria(Users.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
	}

}
