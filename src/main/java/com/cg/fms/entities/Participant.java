package com.cg.fms.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Participant")
public class Participant {
	@Id
	@Column(name="Pid")
	int Pid;
	@Column(name="Pname")
	String Pname;
	@Column(name="Password")
	String Password;
	@Column(name="Cid")
	String Cid;
	public Participant(Employee e,Program course)
	{
		this.Pid=e.getEid();
		this.Pname=e.getEname();
		this.Password=e.getPassword();
		this.Cid=course.getCourseid();
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}

}
