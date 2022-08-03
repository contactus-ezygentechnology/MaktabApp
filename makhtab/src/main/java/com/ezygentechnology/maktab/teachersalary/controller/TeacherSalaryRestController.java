package com.ezygentechnology.maktab.teachersalary.controller;

import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezygentechnology.maktab.teachersalary.pojo.MktbTeacherSalary;
import com.ezygentechnology.maktab.teachersalary.service.ITeacherSalaryService;

@RestController
public class TeacherSalaryRestController {

	private static Logger LOGGER = LoggerFactory.getLogger(TeacherSalaryRestController.class);

	@Autowired
	ITeacherSalaryService teacherSalaryService;

	@RequestMapping(value = "/teachersalary", method = RequestMethod.PUT)
	public MktbTeacherSalary upsertTeacherSalary(@RequestBody MktbTeacherSalary teacherSalary)
			throws AuthenticationException {
		String SchemaName = "makhtab";
		LOGGER.info("Inside TeacherSalaryRestController-> upsertTeacherDetail -> Schema:" + SchemaName);
		LOGGER.info("@RequestBody" + teacherSalary);
		return teacherSalaryService.upsertTeacherSalary(teacherSalary, SchemaName);

	}

	@RequestMapping(value = "/teachersalary/id", method = RequestMethod.GET)
	public MktbTeacherSalary getTeacher(@RequestParam String teacherId) {
		String SchemaName = "makhtab";
		return teacherSalaryService.getTeacherSalary(Integer.parseInt(teacherId), SchemaName);
	}

}
