package com.niit.OrgValleyBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OrgValleyBackend.dao.Job_CommentDao;
import com.niit.OrgValleyBackend.model.Job_Comment;
import com.niit.OrgValleyBackend.model.Users;

public class Job_CommentDaoImpl implements Job_CommentDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	Job_Comment job_comment;
	
	public Job_CommentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void SaveOrUpdate(Job_Comment cmt) {
	this.sessionFactory.getCurrentSession().saveOrUpdate(cmt);
		
	}
@Transactional
	public List<Job_Comment> getCmts(int id) {
		String hql = "from Job_Comment where jid="+id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Job_Comment> listCmt = (List<Job_Comment>) query.list();
		
		if (listCmt != null && !listCmt.isEmpty()) {
			return listCmt;
		}
		return null;
	}
@Transactional
	public List<Job_Comment> getAll() {
String hql = "from JobComment";
         @SuppressWarnings("unchecked")
		List<Job_Comment> list = (List<Job_Comment>) sessionFactory.getCurrentSession().createCriteria(Job_Comment.class).list();
		return list;
	}

}
