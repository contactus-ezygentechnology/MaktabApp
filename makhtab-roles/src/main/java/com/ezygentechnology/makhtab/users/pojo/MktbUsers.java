package com.ezygentechnology.makhtab.users.pojo;

import java.io.Serializable;

public class MktbUsers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long roleId;
	private String user_id;
	private String userName;
	private String password;
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return user_id;
	}
	public void setUserId(String refId) {
		this.user_id = refId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
