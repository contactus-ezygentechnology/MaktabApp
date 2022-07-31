package com.ezygentechnology.makhtab.role.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


import com.ezygentechnology.makhtab.role.dao.mapper.mktbRoleRowMapper;
import com.ezygentechnology.makhtab.role.pojo.MktbRole;
import com.ezygentechnology.makhtab.utils.Util;

/**
 * 
 * @author vaqua
 *
 */
@Repository("mktbRoleDao")
public class RoleDaoImpl implements IRoleDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(RoleDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private Environment env;


	@Override
	public MktbRole upsertRole(MktbRole role,String schema) {
		String sql= env.getProperty("INSERT_ROLE");
		sql=Util.replaceSchema(sql,schema);//TODO 

	
		Map<String, Object> args = new HashMap<String, Object>();


		args.put("roleName", role.getRoleName());
		args.put("roleId", role.getRoleId()>0?role.getRoleId():null);
		// update count
		try {
			int i = jdbcTemplate.update(sql, args);
			// logger
			LOGGER.info("Schema:"+schema);
			LOGGER.info("Role Created/Updated successfully", role.getRoleName());
			LOGGER.info("record inserted {}", i);
		}catch (Exception e) {
			
			e.printStackTrace();

		}
		

		return role;

	}


	@Override
	public List<MktbRole> getAllRoles(String schemaName) {
		String sql="";
		
			sql= env.getProperty("SELECT_ROLE");
		
			sql=Util.replaceSchema(sql,schemaName);//TODO 
			
			Map<String, Object> args = new HashMap<String, Object>();
			
			List<MktbRole> mktbRoles = jdbcTemplate.query(sql, args, new mktbRoleRowMapper());

		return mktbRoles;
	}




}
