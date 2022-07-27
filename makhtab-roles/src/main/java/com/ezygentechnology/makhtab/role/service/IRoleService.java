package com.ezygentechnology.makhtab.role.service;

import com.ezygentechnology.makhtab.role.pojo.MktbRole;

/**
 * 
 * @author vaqua
 *
 */

public interface IRoleService {

	MktbRole upsertRole(MktbRole role,String schemaName);



}
