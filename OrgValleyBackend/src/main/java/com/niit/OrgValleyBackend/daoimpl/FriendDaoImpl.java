package com.niit.OrgValleyBackend.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OrgValleyBackend.dao.FriendDao;
import com.niit.OrgValleyBackend.model.Friend;

public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	Friend friend;
	
    public FriendDaoImpl(SessionFactory sessionFactory)
    {
		this.sessionFactory = sessionFactory;
	}
	
  @Transactional
	public List<Friend> list() {
	  @SuppressWarnings("unchecked")
	List<Friend> listFrms = (List<Friend>) sessionFactory.getCurrentSession()
				.createCriteria(Friend.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listFrms;
	}
@Transactional
	public Friend getFriend(int friend_id) {
	String hql = "from ForumMaster where friend_id=" + friend_id;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Friend> listFrm = (List<Friend>) query.list();
	
	if (listFrm != null && !listFrm.isEmpty()) {
		return listFrm.get(0);
	}
	
	return null;
}
@Transactional
	public void SaveOrUpdate(Friend friend) {
	this.sessionFactory.getCurrentSession().saveOrUpdate(friend);
		
	}
@Transactional
	public void delete(int friend_id) {
	Friend friend = new Friend();
	friend.setFriend_id(friend_id);
	sessionFactory.getCurrentSession().delete(friend);
		
	}

}
