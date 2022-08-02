package com.ezygentechnology.makhtab.users.dao;

import java.util.List;

import com.ezygentechnology.makhtab.users.pojo.MktbUsers;

public interface IUsersDAO {
	
	
	/**
	 * 
	 * @param users
	 * @param schema
	 * @return
	 */
	MktbUsers upsertUsers(MktbUsers users,String schema);
	
	List<MktbUsers> getAllUsers(String schema);
	
	MktbUsers getUser(Long user_id,String schema);

}
