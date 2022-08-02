package com.ezygentechnology.makhtab.users.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ezygentechnology.makhtab.users.pojo.MktbUsers;

public class mktbUsersRowMapper implements RowMapper<MktbUsers> {

	@Override
	public MktbUsers mapRow(ResultSet rs, int rowNum) throws SQLException {

		MktbUsers users = new MktbUsers();
		//
		users.setUserId(rs.getLong("user_id"));
		users.setRoleId(rs.getLong("roleId"));
		users.setUserName(rs.getString("userName"));
		users.setPassword(rs.getString("password"));
		return users;
	}

}
