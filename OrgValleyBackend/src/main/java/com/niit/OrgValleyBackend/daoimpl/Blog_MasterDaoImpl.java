package com.niit.OrgValleyBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import com.niit.OrgValleyBackend.dao.Blog_MasterDao;
import com.niit.OrgValleyBackend.model.Blog_Master;


public class Blog_MasterDaoImpl implements Blog_MasterDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Blog_MasterDao blog_masterDao;
	@Autowired
	Blog_Master blog_master;
	
	public Blog_MasterDaoImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void SaveOrUpdate(Blog_Master blog_Master) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(blog_Master);
		
	}
	@Transactional
	public List<Blog_Master> list() {
		@SuppressWarnings("unchecked")
		List<Blog_Master> listBlog = (List<Blog_Master>) sessionFactory.getCurrentSession()
				.createCriteria(Blog_Master.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listBlog;
	}

	@Transactional
	public void delete(int id) {
		Blog_Master Blog_MasterToDelete = new Blog_Master();
		Blog_MasterToDelete.setBid(id);
		sessionFactory.getCurrentSession().delete(Blog_MasterToDelete);
		
	}
	@Transactional
	public Blog_Master getBlog(int id) {
		String hql = "from blogmaster where bbid=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Blog_Master> listBlog = (List<Blog_Master>) query.list();
		
		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		
		return null;
	}

}
