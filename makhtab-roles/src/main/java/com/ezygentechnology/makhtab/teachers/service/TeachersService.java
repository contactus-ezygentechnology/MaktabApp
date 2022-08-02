package com.ezygentechnology.makhtab.teachers.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezygentechnology.makhtab.teacher.dao.ITeacherDAO;
import com.ezygentechnology.makhtab.teacher.pojo.MktbTeachers;

@Service("mktbTeachersService")
public class TeachersService implements ITeachersService {

	private static Logger LOGGER = LoggerFactory.getLogger(TeachersService.class);
	@Autowired
	ITeacherDAO teachersDao;
	
	@Override
	public MktbTeachers upsertTeachers(MktbTeachers users, String schema) {
		
		LOGGER.info("Inside TeachersService->Schema:"+schema+"->:upsertTeachers");
		return teachersDao.upsertTeacher(users, schema);
		
	}
	
	@Override
	public List<MktbTeachers> getAllTeachers(String schema)
	{
		LOGGER.info("Inside TeachersService->Schema:"+schema+"->:getAllTeachers");
		return teachersDao.getAllTeachers(schema);
	}

	@Override
	public MktbTeachers getTeacher(int teacherId, String schema) {
		
		LOGGER.info("Inside TeachersService->Schema:"+schema+"->:getTeacher");
		return teachersDao.getTeacher(teacherId, schema);
	}

}
