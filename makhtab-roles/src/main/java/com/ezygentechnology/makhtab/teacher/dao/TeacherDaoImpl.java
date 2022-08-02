package com.ezygentechnology.makhtab.teacher.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ezygentechnology.makhtab.teacher.dao.mapper.mktbTeachersRowMapper;
import com.ezygentechnology.makhtab.teacher.pojo.MktbTeachers;
import com.ezygentechnology.makhtab.utils.Util;

@Repository("mktbTeacherssDao")
public class TeacherDaoImpl implements ITeacherDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(TeacherDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private Environment env;

	@Override
	public MktbTeachers upsertTeacher(MktbTeachers teacher, String schema) {
		String sql = env.getProperty("INSERT_TEACHER");
		sql = Util.replaceSchema(sql, schema);// TODO

		Map<String, Object> args = new HashMap<String, Object>();

		args.put("teacherId", teacher.getTeacherId() > 0 ? teacher.getTeacherId() : null);
		args.put("teacherName", teacher.getTeacherName());
		args.put("DOB", teacher.getDateOfBirth());
		args.put("idProof", teacher.getIdProof());
		args.put("registrationDate", teacher.getRegistrationDate());
		args.put("isActive", teacher.getIsActive());

		// update count
		try {
			int i = jdbcTemplate.update(sql, args);
			// logger
			LOGGER.info("Schema:" + schema);
			LOGGER.info("Teachers Created/Updated successfully", teacher.getTeacherName());
			LOGGER.info("record inserted {}", i);
		} catch (Exception e) {

			e.printStackTrace();

		}

		return teacher;

	}

	@Override
	public List<MktbTeachers> getAllTeachers(String schema) {
		String sql = env.getProperty("SELECT_ALLTEACHERS");
		sql = Util.replaceSchema(sql, schema);// TODO
		Map<String, Object> args = new HashMap<String, Object>();

		List<MktbTeachers> teachers = jdbcTemplate.query(sql, args, new mktbTeachersRowMapper());
		// logger
		LOGGER.info("Schema:" + schema);

		return teachers;
	}

	@Override
	public MktbTeachers getTeacher(int teacherId, String schema) {

		String sql = env.getProperty("SELECT_TEACHER");
		sql = Util.replaceSchema(sql, schema);// TODO
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("teacherId", teacherId);
		MktbTeachers teacher = null;
		List<MktbTeachers> teachers = jdbcTemplate.query(sql, args, new mktbTeachersRowMapper());

		if (teachers.size() > 0) {
			teacher = teachers.get(0);
		}

		return teacher;

	}

}
