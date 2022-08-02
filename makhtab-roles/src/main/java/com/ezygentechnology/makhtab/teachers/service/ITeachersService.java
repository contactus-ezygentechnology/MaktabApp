package com.ezygentechnology.makhtab.teachers.service;

import java.util.List;

import com.ezygentechnology.makhtab.teacher.pojo.MktbTeachers;

public interface ITeachersService {
	
	MktbTeachers upsertTeachers(MktbTeachers teachers,String schema);
	
	List<MktbTeachers> getAllTeachers(String Schema);
	
	MktbTeachers getTeacher(int teacherId, String schema);
}
