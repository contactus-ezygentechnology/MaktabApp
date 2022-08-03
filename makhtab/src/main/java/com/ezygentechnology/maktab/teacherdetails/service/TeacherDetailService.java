package com.ezygentechnology.maktab.teacherdetails.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezygentechnology.maktab.teacherdetails.dao.ITeacherDetailsDAO;
import com.ezygentechnology.maktab.teacherdetails.pojo.MktbTeacherDetails;

@Service("mktbTeacherDetailService")
public class TeacherDetailService implements ITeacherDetailService {

	private static Logger LOGGER = LoggerFactory.getLogger(TeacherDetailService.class);
	@Autowired
	ITeacherDetailsDAO teacherDetailDao;

	@Override
	public MktbTeacherDetails upsertTeacherDetails(MktbTeacherDetails teacherDetails, String schema) {

		LOGGER.info("Inside TeacherDetailService->Schema:" + schema + "->:upsertTeacherDetails");
		return teacherDetailDao.upsertTeacherDetails(teacherDetails, schema);
	}

	@Override
	public MktbTeacherDetails getTeacherDetail(int teacherId, String schema) {

		LOGGER.info("Inside TeacherDetailService->Schema:" + schema + "->:getTeacherDetail");
		return teacherDetailDao.getTeacherDetail(teacherId, schema);
	}

}
