package com.cg.fms.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Trainer")
public class Trainer {
	@Id
	@Column(name="Tid")
	int Tid;
	@Column(name="Tname")
	String Tname;
	@Column(name="Password")
	String Password;
	@Column(name="Skills")
	String Skills;
	
	Trainer(Employee E)
	{
		this.Tid=E.getEid();
		this.Tname=E.getEname();
		this.Password=E.getPassword();
	}

	public int getTid() {
		return Tid;
	}

	public void setTid(int tid) {
		Tid = tid;
	}

	public String getTname() {
		return Tname;
	}

	public void setTname(String tname) {
		Tname = tname;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getSkills() {
		return Skills;
	}

	public void setSkills(String skills) {
		Skills = skills;
	}
	

}
