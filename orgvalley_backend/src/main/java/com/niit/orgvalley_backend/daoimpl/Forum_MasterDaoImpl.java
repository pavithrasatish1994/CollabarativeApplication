package com.niit.orgvalley_backend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.orgvalley_backend.dao.Forum_MasterDao;
import com.niit.orgvalley_backend.model.Forum_Master;
import com.niit.orgvalley_backend.model.Users;

public class Forum_MasterDaoImpl implements Forum_MasterDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Forum_Master forum_master;
	
	public Forum_MasterDaoImpl(SessionFactory sessionFactory)
	{
		 this .sessionFactory= sessionFactory;
	}
      @Transactional
	public List<Forum_Master> list() {
		@SuppressWarnings("unchecked")
		List<Forum_Master> list = (List<Forum_Master>) sessionFactory.getCurrentSession()
				.createCriteria(Forum_Master.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;
		
	}
       @Transactional
	public Forum_Master getForum_Master(int forum_id) {
		String hql = "from forum_master where id=" + forum_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Forum_Master> listForum_Master = (List<Forum_Master>) query.list();
		
		if (listForum_Master != null && !listForum_Master.isEmpty()) {
			return listForum_Master.get(0);
		}
		return null;
	
	}
  @Transactional
	public void insertORupdate(Forum_Master forum_master) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum_master);
		
	}
   @Transactional
	public void delForum_Master(int forum_id) {
	   forum_master.setForum_id(forum_id);	
		sessionFactory.getCurrentSession().delete(forum_master);
		
	}
	
	
	
	
}
