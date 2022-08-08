package com.cg.fms.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Program")
public class Program {
	@Id
	@Column(name="trainingId")
    private String trainingId;
	@Column(name="startDate")
    private LocalDate startDate;
	@Column(name="endDate")
    private LocalDate endDate;
	@Column(name="courseid")
	private String courseid;
	@Column(name="facultyid")
    private int facultyid;
    
    public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public int getFacultyid() {
		return facultyid;
	}
	public void setFaculty(int facultyid) {
		this.facultyid = facultyid;
	}
}

