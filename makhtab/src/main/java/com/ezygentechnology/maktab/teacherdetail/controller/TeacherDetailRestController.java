package com.ezygentechnology.maktab.teacherdetail.controller;

import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezygentechnology.maktab.teacherdetails.pojo.MktbTeacherDetails;
import com.ezygentechnology.maktab.teacherdetails.service.ITeacherDetailService;

@RestController
public class TeacherDetailRestController {

	private static Logger LOGGER = LoggerFactory.getLogger(TeacherDetailRestController.class);

	@Autowired
	ITeacherDetailService teacherDetailService;

	@RequestMapping(value = "/teacherdetail", method = RequestMethod.PUT)
	public MktbTeacherDetails upsertTeacherDetail(@RequestBody MktbTeacherDetails teacherDetail)
			throws AuthenticationException {
		String SchemaName = "makhtab";
		LOGGER.info("Inside TeacherDetailRestController-> upsertTeacherDetail -> Schema:" + SchemaName);
		LOGGER.info("@RequestBody" + teacherDetail);
		return teacherDetailService.upsertTeacherDetails(teacherDetail, SchemaName);

	}

	@RequestMapping(value = "/teacherdetail/id", method = RequestMethod.GET)
	public MktbTeacherDetails getTeacher(@RequestParam String teacherId) {
		String SchemaName = "makhtab";
		return teacherDetailService.getTeacherDetail(Integer.parseInt(teacherId), SchemaName);
	}

}
