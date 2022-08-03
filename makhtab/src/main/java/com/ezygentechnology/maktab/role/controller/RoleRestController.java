package com.ezygentechnology.maktab.role.controller;


import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezygentechnology.maktab.role.dao.IRoleDAO;
import com.ezygentechnology.maktab.role.pojo.MktbRole;
import com.ezygentechnology.maktab.role.service.IRoleService;

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
		
		//return role;
		return service.upsertRole(role, "makhtab");

	}
	
	@RequestMapping(value = "/role", method = RequestMethod.GET)
	public List<MktbRole> getAllRoles()
			throws AuthenticationException {
		String SchemaName="makhtab";
		LOGGER.info("Inside RoleRestController-> getAllRoles -> Schema:"+SchemaName);
		
		
		//return role;
		return service.getAllRoles(SchemaName);

	}
}
