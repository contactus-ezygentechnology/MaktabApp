package com.ezygentechnology.maktab.users.service;

import java.util.List;

import com.ezygentechnology.maktab.users.pojo.MktbUsers;

public interface IUsersService {
	
	MktbUsers upsertUsers(MktbUsers users,String schema);
	
	List<MktbUsers> getAllUsers(String Schema);
	
	MktbUsers getUser(Long user_id, String schema);

}
