package com.ezygentechnology.makhtab.role.dao;

import java.util.List;

import com.ezygentechnology.makhtab.role.pojo.MktbRole;

/**
 * 
 * @author vaqua
 *
 */
public interface IRoleDAO {
	
	/**
	 * @param role
	 * @param schema
	 * @return
	 */
	MktbRole upsertRole(MktbRole role, String schema);


	
}
