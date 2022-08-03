package com.ezygentechnology.maktab.role.pojo;



import java.io.Serializable;


/**
 * The persistent class for the mktb_roles database table.
 * 
 */

public class MktbRole implements Serializable {
	private static final long serialVersionUID = 1L;


	private long roleId;

	private String roleName;

	public MktbRole() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}