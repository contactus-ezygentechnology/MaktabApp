package com.ezygentechnology.maktab.role.dao;

import java.util.List;

import com.ezygentechnology.maktab.role.pojo.MktbRole;

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
	List<MktbRole> getAllRoles(String schemaName);


	
}
