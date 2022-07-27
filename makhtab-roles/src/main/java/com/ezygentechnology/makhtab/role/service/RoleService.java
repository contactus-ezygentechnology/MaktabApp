package com.ezygentechnology.makhtab.role.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezygentechnology.makhtab.role.dao.IRoleDAO;
import com.ezygentechnology.makhtab.role.pojo.MktbRole;




/**
 * 
 * @author vaqua
 *
 */
@Service("mktbRoleService")
public class RoleService implements IRoleService {

	private static Logger LOGGER = LoggerFactory.getLogger(RoleService.class);
	@Autowired
	IRoleDAO dao;

	@Override
	public MktbRole upsertRole(MktbRole role,String schemaName) {
		// TODO Auto-generated method stub
		
		LOGGER.info("Inside RoleService->Schema:"+schemaName+"->:upsertRole");
		return dao.upsertRole(role, schemaName);
	}

	
	
}
