package com.ezygentechnology.maktab.teachersalary.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ezygentechnology.maktab.teachersalary.pojo.MktbTeacherSalary;

public class mktbTeacherSalaryRowMapper implements RowMapper<MktbTeacherSalary> {

	@Override
	public MktbTeacherSalary mapRow(ResultSet rs, int rowNum) throws SQLException {

		MktbTeacherSalary teacherSalary = new MktbTeacherSalary();

		teacherSalary.setTeacherId(rs.getInt("teacherId"));
		teacherSalary.setCompensation(rs.getString("compensation"));
		teacherSalary.setDate(String.valueOf(rs.getTimestamp("date")));
		teacherSalary.setIncrement(rs.getString("increment"));

		return teacherSalary;
	}

}
