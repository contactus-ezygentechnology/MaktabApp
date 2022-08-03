package com.ezygentechnology.maktab.teachersalary.service;

import com.ezygentechnology.maktab.teachersalary.pojo.MktbTeacherSalary;

public interface ITeacherSalaryService {
	
	MktbTeacherSalary upsertTeacherSalary(MktbTeacherSalary teacherSalary, String schema);

	MktbTeacherSalary getTeacherSalary(int teacherId, String schema);

}
