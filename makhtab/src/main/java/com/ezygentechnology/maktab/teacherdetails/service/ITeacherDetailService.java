package com.ezygentechnology.maktab.teacherdetails.service;

import com.ezygentechnology.maktab.teacherdetails.pojo.MktbTeacherDetails;

public interface ITeacherDetailService {

	MktbTeacherDetails upsertTeacherDetails(MktbTeacherDetails teacherDetails, String schema);

	MktbTeacherDetails getTeacherDetail(int teacherId, String schema);

}
