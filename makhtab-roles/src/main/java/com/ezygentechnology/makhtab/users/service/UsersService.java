package com.ezygentechnology.makhtab.users.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezygentechnology.makhtab.users.dao.IUsersDAO;
import com.ezygentechnology.makhtab.users.pojo.MktbUsers;

@Service("mktbUsersService")
public class UsersService implements IUsersService {

	private static Logger LOGGER = LoggerFactory.getLogger(UsersService.class);
	@Autowired
	IUsersDAO userDao;
	
	@Override
	public MktbUsers upsertUsers(MktbUsers users, String schema) {
		
		LOGGER.info("Inside UserService->Schema:"+schema+"->:upsertUser");
		return userDao.upsertUsers(users, schema);
		
	}
	
	@Override
	public List<MktbUsers> getAllUsers(String schema)
	{
		LOGGER.info("Inside UserService->Schema:"+schema+"->:getAllUsers");
		return userDao.getAllUsers(schema);
	}

	@Override
	public MktbUsers getUser(Long user_id, String schema) {
		LOGGER.info("Inside UserService->Schema:"+schema+"->:getUser");
		return userDao.getUser(user_id, schema);
	}

}
