package com.ezygentechnology.maktab.users.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezygentechnology.maktab.users.dao.mapper.mktbUsersRowMapper;
import com.ezygentechnology.maktab.users.pojo.MktbUsers;
import com.ezygentechnology.maktab.utils.Util;

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
        LOGGER.info("UserName is: "+users.getUserName());
		args.put("user_id", users.getUserId()>0?users.getUserId():null);
		args.put("roleId", users.getRoleId());
		args.put("userName", users.getUserName());
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

	@Override
	public List<MktbUsers> getAllUsers(String schema) {
		String sql = env.getProperty("SELECT_ALLUSERS");
		sql = Util.replaceSchema(sql, schema);// TODO
		Map<String, Object> args = new HashMap<String, Object>();
		LOGGER.info("Query is:" + sql);
		
			List<MktbUsers> users = jdbcTemplate.query(sql, args, new mktbUsersRowMapper());
			// logger
			LOGGER.info("Schema:" + schema);

		return users;
	}
	
	@Override
	public MktbUsers getUser(Long user_id, String schema) {
		
		String sql = env.getProperty("SELECT_USER");
		sql = Util.replaceSchema(sql, schema);// TODO
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("user_id", user_id);
		MktbUsers user = null;
		List<MktbUsers> users = jdbcTemplate.query(sql, args, new mktbUsersRowMapper());
		
		if(users.size() > 0)
		{
			user=users.get(0);
		}
		
		return user;
	}

}
