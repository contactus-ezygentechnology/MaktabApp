package com.ezygentechnology.maktab.teachersalary.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

public class MktbTeacherSalary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int teacherId;
	private String compensation;
	private Timestamp date;
	private String increment;
	
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getCompensation() {
		return compensation;
	}
	public void setCompensation(String compensation) {
		this.compensation = compensation;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = Timestamp.valueOf(date);
	}
	public String getIncrement() {
		return increment;
	}
	public void setIncrement(String increment) {
		this.increment = increment;
	}
}
