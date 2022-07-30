package com.ezygentechnology.makhtab.users.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezygentechnology.makhtab.users.pojo.MktbUsers;
import com.ezygentechnology.makhtab.utils.Util;

@Repository("mktbUsersDao")
public class UsersDaoImpl implements IUsersDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(UsersDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private Environment env;

	@Override
	public MktbUsers upsertUsers(MktbUsers users, String schema) {
		String sql = env.getProperty("INSERT_USERS");
		sql = Util.replaceSchema(sql, schema);// TODO

		Map<String, Object> args = new HashMap<String, Object>();

		args.put("refId", users.getRefId());
		args.put("roleId", users.getRoleId());
		args.put("username", users.getUserName());
		args.put("password", users.getPassword());
		// update count
		try {
			int i = jdbcTemplate.update(sql, args);
			// logger
			LOGGER.info("Schema:" + schema);
			LOGGER.info("Users Created/Updated successfully", users.getUserName());
			LOGGER.info("record inserted {}", i);
		} catch (Exception e) {

			e.printStackTrace();

		}

		return users;

	}

}
