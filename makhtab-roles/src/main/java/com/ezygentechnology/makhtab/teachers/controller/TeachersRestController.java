package com.ezygentechnology.makhtab.teachers.controller;

import java.util.List;

import javax.security.sasl.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ezygentechnology.makhtab.teacher.pojo.MktbTeachers;
import com.ezygentechnology.makhtab.teachers.service.ITeachersService;

@RestController
public class TeachersRestController {

	private static Logger LOGGER = LoggerFactory.getLogger(TeachersRestController.class);

	@Autowired
	ITeachersService teacherService;

	@RequestMapping(value = "/teachers", method = RequestMethod.PUT)
	public MktbTeachers upsertTeacher(@RequestBody MktbTeachers teachers) throws AuthenticationException {
		String SchemaName = "makhtab";
		LOGGER.info("Inside UsersRestController-> upsertUsers -> Schema:" + SchemaName);
		LOGGER.info("@RequestBody" + teachers);
		return teacherService.upsertTeachers(teachers, SchemaName);

	}

	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public List<MktbTeachers> getAllTeachers() {
		String SchemaName = "makhtab";
		return teacherService.getAllTeachers(SchemaName);
	}

	@RequestMapping(value = "/teacher/id", method = RequestMethod.GET)
	public MktbTeachers getTeacher(@RequestParam String teacherId) {
		String SchemaName = "makhtab";
		return teacherService.getTeacher(Integer.parseInt(teacherId), SchemaName);
	}

}
