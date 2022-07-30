package com.ezygentechnology.makhtab.users.controller;

import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezygentechnology.makhtab.users.pojo.MktbUsers;
import com.ezygentechnology.makhtab.users.service.IUsersService;

@RestController("/")
public class UsersRestController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UsersRestController.class);
	
	@Autowired
	IUsersService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public MktbUsers upsertRole(@RequestBody MktbUsers users)
			throws AuthenticationException {
		String SchemaName="makhtab";
		LOGGER.info("Inside UsersRestController-> upsertUsers -> Schema:"+SchemaName);
		LOGGER.info("@RequestBody"+users);
		return userService.upsertUsers(users, SchemaName);

	}

}
