package com.mod.bean;

import org.springframework.stereotype.Component;

@Component("roleBean")
public class RoleBean {
	
	private int roleid;
	private String rolename;
	
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	
}
