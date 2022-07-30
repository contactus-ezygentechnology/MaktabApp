package com.ezygentechnology.makhtab.users.service;

import com.ezygentechnology.makhtab.users.pojo.MktbUsers;

public interface IUsersService {
	
	MktbUsers upsertUsers(MktbUsers users,String schema);

}
