package com.ezygentechnology.maktab.role.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ezygentechnology.maktab.role.pojo.MktbRole;

/**
 * 
 * @author vaqua
 *
 */
//TODO template for select 
public class mktbRoleRowMapper implements RowMapper<MktbRole> {

	@Override
	public MktbRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MktbRole role = new MktbRole();
		//
		role.setRoleName(rs.getString("roleName"));
		role.setRoleId(rs.getLong("roleId"));
		return role;
	}

}
