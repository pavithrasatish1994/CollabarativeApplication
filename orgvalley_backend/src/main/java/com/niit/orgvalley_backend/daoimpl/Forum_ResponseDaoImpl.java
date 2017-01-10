package com.niit.orgvalley_backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.niit.orgvalley_backend.dao.Forum_ResponseDao;
import com.niit.orgvalley_backend.model.Forum_Response;

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
			List<Forum_Response> list = (List<Forum_Response>) sessionFactory.getCurrentSession()
					.createCriteria(Forum_Response.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
			
		}
@Transactional
	public Forum_Response getForum_Response(int response_id) {
	String hql = "from forum_response where id=" + response_id;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Forum_Response> listForum_Response = (List<Forum_Response>) query.list();
	
	if (listForum_Response != null && !listForum_Response.isEmpty()) {
		return listForum_Response.get(0);
	}
	return null;

}
@Transactional
	public void insertORupdate(Forum_Response forum_response) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum_response);
		
	}

@Transactional
public void delForum_Respone(int response_id) {
	forum_response.setResponse_id(response_id);
	sessionFactory.getCurrentSession().delete(forum_response);
	
}


	
	
}
