package com.ezygentechnology.maktab.teachersalary.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezygentechnology.maktab.teacherdetails.dao.mapper.mktbTeacherDetailRowMapper;
import com.ezygentechnology.maktab.teachersalary.dao.mapper.mktbTeacherSalaryRowMapper;
import com.ezygentechnology.maktab.teachersalary.pojo.MktbTeacherSalary;
import com.ezygentechnology.maktab.utils.Util;

@Repository("mktbTeacherSalaryDao")
public class TeacherSalaryDaoImpl implements ITeacherSalaryDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(TeacherSalaryDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private Environment env;

	@Override
	public MktbTeacherSalary upsertTeacherSalary(MktbTeacherSalary teacherSalary, String schema) {
		String sql = env.getProperty("INSERT_TEACHERSALARY");
		sql = Util.replaceSchema(sql, schema);// TODO

		Map<String, Object> args = new HashMap<String, Object>();

		args.put("teacherId", teacherSalary.getTeacherId());
		args.put("compensation", teacherSalary.getCompensation());
		args.put("date", teacherSalary.getDate());
		args.put("increment", teacherSalary.getIncrement());

		// update count
		try {
			int i = jdbcTemplate.update(sql, args);
			// logger
			LOGGER.info("Schema:" + schema);
			LOGGER.info("Teacher Record Created/Updated successfully", teacherSalary.getTeacherId());
			LOGGER.info("record inserted {}", i);
		} catch (Exception e) {

			e.printStackTrace();

		}

		return teacherSalary;
	}

	@Override
	public MktbTeacherSalary getTeacherSalary(int teacherId, String schema) {
		String sql = env.getProperty("SELECT_TEACHERSALARY");
		sql = Util.replaceSchema(sql, schema);// TODO
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("teacherId", teacherId);
		MktbTeacherSalary teacherSalary = null;
		List<MktbTeacherSalary> teacherSalarys = jdbcTemplate.query(sql, args, new mktbTeacherSalaryRowMapper());

		if (teacherSalarys.size() > 0) {
			teacherSalary = teacherSalarys.get(0);
		}

		return teacherSalary;
	}

}
