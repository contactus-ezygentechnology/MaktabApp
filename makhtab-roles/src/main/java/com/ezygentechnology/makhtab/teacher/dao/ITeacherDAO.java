package com.ezygentechnology.makhtab.teacher.dao;

import java.util.List;

import com.ezygentechnology.makhtab.teacher.pojo.MktbTeachers;
import com.ezygentechnology.makhtab.users.pojo.MktbUsers;

public interface ITeacherDAO {
	
MktbTeachers upsertTeacher(MktbTeachers teacher,String schema);
	
	List<MktbTeachers> getAllTeachers(String schema);
	
	MktbTeachers getTeacher(int teacherId,String schema);

}
