package com.ezygentechnology.maktab.teacherdetails.dao;

import java.util.List;

import com.ezygentechnology.maktab.teacher.pojo.MktbTeachers;
import com.ezygentechnology.maktab.teacherdetails.pojo.MktbTeacherDetails;
import com.ezygentechnology.maktab.users.pojo.MktbUsers;

public interface ITeacherDetailsDAO {
	
	MktbTeacherDetails upsertTeacherDetails(MktbTeacherDetails teacherDetails,String schema);
	
	MktbTeacherDetails getTeacherDetail(int teacherId,String schema);

}
