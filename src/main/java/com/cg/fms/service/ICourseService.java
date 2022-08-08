package com.cg.fms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.cg.fms.entities.*;


public interface ICourseService {
	@Autowired
	public String addcourse(Course c);
	public String updatecourse(String id,Course c);
	public String removeCourse(String id);
	public Course viewcourse(String id);
	public List<Course> viewallcourses();

}