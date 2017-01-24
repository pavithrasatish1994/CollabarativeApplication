package com.niit.OrgValleyBackend.dao;
import java.util.List;

import com.niit.OrgValleyBackend.model.Friend;
public interface FriendDao {

	public List<Friend> list();
	public Friend getFriend(int friend_id);
	public void SaveOrUpdate(Friend friend);
	public void delete(int friend_id);
}
