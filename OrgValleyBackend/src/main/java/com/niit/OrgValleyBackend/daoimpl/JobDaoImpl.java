package com.niit.OrgValleyBackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OrgValleyBackend.dao.JobDao;
import com.niit.OrgValleyBackend.model.Job;

public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	JobDao jobDao;
	@Autowired
	Job job;
	
	public JobDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Job> list() {
		String hql = "from Job";
		@SuppressWarnings("unchecked")
		List<Job> list = (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).list();
		return list;
	}
    @Transactional
	public void SaveOrUpdate(Job job) {
    	sessionFactory.getCurrentSession().saveOrUpdate(job);	
	}
    @Transactional
	public void delete(int jid) {
    	job.setJid(jid);	
		sessionFactory.getCurrentSession().delete(job);
		
	}
    @Transactional
	public Job getJob(int jid) {
    	String hql = "from Job where id=" + jid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Job> listJob = (List<Job>) query.list();
		
		if (listJob != null && !listJob.isEmpty()) {
			return listJob.get(0);
		}
		return null;
	}
    
}
