package com.ezygentechnology.maktab.teachersalary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezygentechnology.maktab.teachersalary.dao.ITeacherSalaryDAO;
import com.ezygentechnology.maktab.teachersalary.pojo.MktbTeacherSalary;

@Service("mktbTeacherSalaryService")
public class TeacherSalaryService implements ITeacherSalaryService {

	private static Logger LOGGER = LoggerFactory.getLogger(TeacherSalaryService.class);

	@Autowired
	ITeacherSalaryDAO teacherSalaryDao;

	@Override
	public MktbTeacherSalary upsertTeacherSalary(MktbTeacherSalary teacherSalary, String schema) {
		LOGGER.info("Inside TeacherSalaryService->Schema:" + schema + "->:upsertTeacherSalary");
		return teacherSalaryDao.upsertTeacherSalary(teacherSalary, schema);
	}

	@Override
	public MktbTeacherSalary getTeacherSalary(int teacherId, String schema) {
		LOGGER.info("Inside TeacherSalaryService->Schema:" + schema + "->:getTeacherSalary");
		return teacherSalaryDao.getTeacherSalary(teacherId, schema);
	}

}
