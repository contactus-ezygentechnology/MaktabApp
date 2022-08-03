package com.ezygentechnology.maktab.teacherdetails.dao;

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
import com.ezygentechnology.maktab.teacherdetails.pojo.MktbTeacherDetails;
import com.ezygentechnology.maktab.utils.Util;

@Repository("mktbTeacherDetailDao")
public class TeacherDetailDaoImpl implements ITeacherDetailsDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(TeacherDetailDaoImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private Environment env;

	@Override
	public MktbTeacherDetails upsertTeacherDetails(MktbTeacherDetails teacherDetails, String schema) {
		String sql = env.getProperty("INSERT_TEACHERDETAIL");
		sql = Util.replaceSchema(sql, schema);// TODO

		Map<String, Object> args = new HashMap<String, Object>();

		args.put("teacherId", teacherDetails.getTeacherId());
		args.put("pinCode", teacherDetails.getPinCode());
		args.put("address", teacherDetails.getCity());
		args.put("city", teacherDetails.getCity());
		args.put("state", teacherDetails.getState());
		args.put("country", teacherDetails.getCountry());
		args.put("phNumber", teacherDetails.getPhNumber());
		// update count
		try {
			int i = jdbcTemplate.update(sql, args);
			// logger
			LOGGER.info("Schema:" + schema);
			LOGGER.info("Teacher Record Created/Updated successfully", teacherDetails.getTeacherId());
			LOGGER.info("record inserted {}", i);
		} catch (Exception e) {

			e.printStackTrace();

		}

		return teacherDetails;

	}

	@Override
	public MktbTeacherDetails getTeacherDetail(int teacherId, String schema) {
		String sql = env.getProperty("SELECT_TEACHERDETAIL");
		sql = Util.replaceSchema(sql, schema);// TODO
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("teacherId", teacherId);
		MktbTeacherDetails teacherDetail = null;
		List<MktbTeacherDetails> teacherDetails = jdbcTemplate.query(sql, args, new mktbTeacherDetailRowMapper());

		if (teacherDetails.size() > 0) {
			teacherDetail = teacherDetails.get(0);
		}

		return teacherDetail;

	}

}
