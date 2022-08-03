package com.ezygentechnology.maktab.teacher.dao;

import java.util.List;

import com.ezygentechnology.maktab.teacher.pojo.MktbTeachers;
import com.ezygentechnology.maktab.users.pojo.MktbUsers;

public interface ITeacherDAO {
	
MktbTeachers upsertTeacher(MktbTeachers teacher,String schema);
	
	List<MktbTeachers> getAllTeachers(String schema);
	
	MktbTeachers getTeacher(int teacherId,String schema);

}
