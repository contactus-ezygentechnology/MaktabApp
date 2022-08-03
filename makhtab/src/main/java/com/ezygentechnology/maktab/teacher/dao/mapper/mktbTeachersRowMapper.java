package com.ezygentechnology.maktab.teacher.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ezygentechnology.maktab.teacher.pojo.MktbTeachers;

public class mktbTeachersRowMapper implements RowMapper<MktbTeachers> {

	@Override
	public MktbTeachers mapRow(ResultSet rs, int rowNum) throws SQLException {
		MktbTeachers teachers = new MktbTeachers();
		//
		teachers.setTeacherId(rs.getInt("teacherId"));
		teachers.setTeacherName(rs.getString("teacherName"));
		teachers.setDateOfBirth(String.valueOf(rs.getTimestamp("DOB")));
		teachers.setIdProof(rs.getString("idProof"));
		teachers.setRegistrationDate(String.valueOf(rs.getTimestamp("registrationDate")));
		teachers.setIsActive(rs.getInt("isActive"));
		
		return teachers;
	}
	
	

}
