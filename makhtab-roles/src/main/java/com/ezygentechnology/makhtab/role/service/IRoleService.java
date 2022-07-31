package com.ezygentechnology.makhtab.role.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ezygentechnology.makhtab.role.pojo.MktbRole;

/**
 * 
 * @author vaqua
 *
 */

public interface IRoleService {

	MktbRole upsertRole(MktbRole role,String schemaName);
	
	List< MktbRole > getAllRoles(String schemaName);



}
