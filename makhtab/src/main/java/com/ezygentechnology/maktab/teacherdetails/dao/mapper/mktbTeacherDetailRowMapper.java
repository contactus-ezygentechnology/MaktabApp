package com.ezygentechnology.maktab.teacherdetails.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ezygentechnology.maktab.teacherdetails.pojo.MktbTeacherDetails;

public class mktbTeacherDetailRowMapper implements RowMapper<MktbTeacherDetails> {

	@Override
	public MktbTeacherDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		MktbTeacherDetails teacherDetails = new MktbTeacherDetails();

		teacherDetails.setTeacherId(rs.getInt("teacherId"));
		teacherDetails.setPinCode(rs.getString("pinCode"));
		teacherDetails.setAddress(rs.getString("address"));
		teacherDetails.setCity(rs.getString("city"));
		teacherDetails.setState(rs.getString("state"));
		teacherDetails.setCountry(rs.getString("country"));
		teacherDetails.setPhNumber(rs.getString("phNumber"));

		return teacherDetails;
	}

}
