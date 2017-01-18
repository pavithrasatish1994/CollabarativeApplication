package com.niit.OrgValleyBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OrgValleyBackend.dao.Blog_CommentDao;
import com.niit.OrgValleyBackend.model.Blog_Comment;

public class Blog_CommentDaoImpl implements Blog_CommentDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Blog_Comment blog_comment;
	
	public Blog_CommentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void SaveOrUpdate(Blog_Comment cmt) {
	
		this.sessionFactory.getCurrentSession().saveOrUpdate(cmt);
	}
	@Transactional
	public List<Blog_Comment> getCmts(int id) {
	
		String hql = "from BComment where bid="+id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog_Comment> listCmt = (List<Blog_Comment>) query.list();
		
		if (listCmt != null && !listCmt.isEmpty()) {
			return listCmt;
		}
		
		return null;
	
	}
	@Transactional
	public List<Blog_Comment> getAll() {
	
		@SuppressWarnings("unchecked")
		List<Blog_Comment> listCmts = (List<Blog_Comment>) sessionFactory.getCurrentSession()
				.createCriteria(Blog_Comment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listCmts;
	
	}

}
