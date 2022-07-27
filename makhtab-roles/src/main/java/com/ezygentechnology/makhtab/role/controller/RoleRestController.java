package com.ezygentechnology.makhtab.role.controller;


import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezygentechnology.makhtab.role.dao.IRoleDAO;
import com.ezygentechnology.makhtab.role.pojo.MktbRole;
import com.ezygentechnology.makhtab.role.service.IRoleService;

/**
 * This is first api call once user login
 * 
 * @author vaqua
 *
 */
@RestController("/")
public class RoleRestController {

	private static Logger LOGGER = LoggerFactory.getLogger(RoleRestController.class);
	
	@Autowired
	IRoleService service;
	
	
	
	
	@RequestMapping(value = "/role", method = RequestMethod.PUT)
	public MktbRole upsertRole(@RequestBody MktbRole role)
			throws AuthenticationException {
		String SchemaName="makhtab";
		LOGGER.info("Inside RoleRestController-> upsertRole -> Schema:"+SchemaName);
		LOGGER.info("@RequestBody"+role);
		return service.upsertRole(role, "makhtab");

	}
}
