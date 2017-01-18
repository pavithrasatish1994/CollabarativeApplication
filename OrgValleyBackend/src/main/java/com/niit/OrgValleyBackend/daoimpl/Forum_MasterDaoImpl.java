package com.niit.OrgValleyBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OrgValleyBackend.model.Forum_Master;
import com.niit.OrgValleyBackend.dao.Forum_MasterDao;

	
public class Forum_MasterDaoImpl implements Forum_MasterDao{

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Forum_Master forum_master;
	
	public Forum_MasterDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public void SaveOrUpdate(Forum_Master frm) {
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(frm);
	}
	@Transactional
	public List<Forum_Master> list() {
		
		@SuppressWarnings("unchecked")
		List<Forum_Master> listFrms = (List<Forum_Master>) sessionFactory.getCurrentSession()
				.createCriteria(Forum_Master.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listFrms;
	}
	@Transactional
	public void delete(int fid) {
		Forum_Master ForumMasterToDelete = new Forum_Master();
		ForumMasterToDelete.setFid(fid);
		sessionFactory.getCurrentSession().delete(ForumMasterToDelete);
		
	}
	@Transactional
	public Forum_Master getFrm(int fid) {
		String hql = "from ForumMaster where fid=" + fid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Forum_Master> listFrm = (List<Forum_Master>) query.list();
		
		if (listFrm != null && !listFrm.isEmpty()) {
			return listFrm.get(0);
		}
		
		return null;
	}
	@Transactional
	public int getlikes(int fid) {
		String hql = "from ForumMaster where fid=" + fid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Forum_Master> listFrm = (List<Forum_Master>) query.list();
		
		if (listFrm != null && !listFrm.isEmpty()) {
			return listFrm.get(0).getFcmtct();
		}
		return 0;
	}
	
}
