package com.cg.fms.entities;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@Column(name="Eid")
	private int Eid;
	@Column(name="Ename")
	String Ename;
	@Column(name="password")
	String password;
	@Column(name="Role")
	Role role;
	public Employee() {}
	public Employee(Map<String,String> login)
	{
		
	}
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		this.Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		this.Ename = ename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	

}
