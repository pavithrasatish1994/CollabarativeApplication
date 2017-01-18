package com.niit.OrgValleyBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.niit.OrgValleyBackend.dao.Forum_ResponseDao;
import com.niit.OrgValleyBackend.model.Forum_Master;
import com.niit.OrgValleyBackend.model.Forum_Response;
import com.niit.OrgValleyBackend.model.Users;

public class Forum_ResponseDaoImpl implements Forum_ResponseDao {

	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Forum_Response forum_response;
	
	public Forum_ResponseDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


@Transactional
public List<Forum_Response> list() {
	
		@SuppressWarnings("unchecked")
		
		String hql = "from Users";
//		List<Users> list = (List<Users>) sessionFactory.getCurrentSession().createQuery(hql);
		
		
		
		List<Forum_Response> list = (List<Forum_Response>) sessionFactory.getCurrentSession().createCriteria(Forum_Response.class).list();
		return list;
	}


@Transactional
public void SaveOrUpdate(Forum_Response rpl) {
	this.sessionFactory.getCurrentSession().saveOrUpdate(rpl);
	
}


public Forum_Response getFrm(int rid) {
	String hql = "from Forum_Response where rid=" + rid;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Forum_Response> listFrm = (List<Forum_Response>) query.list();
	
	if (listFrm != null && !listFrm.isEmpty()) {
		return listFrm.get(0);
	}
	
	return null;
}
	
	
}
