package com.niit.orgvalley_backend.daoimpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.orgvalley_backend.dao.UsersDao;
import com.niit.orgvalley_backend.model.Users;



public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Users users;
	
	public UsersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory= sessionFactory;
	}
	@Transactional
	public List<Users> list() {
		@SuppressWarnings("unchecked")
		
		String hql = "from Users";
//		List<Users> list = (List<Users>) sessionFactory.getCurrentSession().createQuery(hql);
		
		
		
		List<Users> list = (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class).list();
		return list;
	}
	@Transactional
	public Users getUser(int id) {
		String hql = "from Users where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Users> listUsers = (List<Users>) query.list();
		
		if (listUsers != null && !listUsers.isEmpty()) {
			return listUsers.get(0);
		}
		return null;
	}
	@Transactional
	public void insertORupdate(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		}
	@Transactional
	public void delUsers(int id) {
		users.setId(id);	
		sessionFactory.getCurrentSession().delete(users);
		
	}

}
