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
	
	List<MktbUsers> selectAllUsers(String schema);

}
