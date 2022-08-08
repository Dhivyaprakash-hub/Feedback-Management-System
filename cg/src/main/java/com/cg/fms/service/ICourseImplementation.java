package com.cg.fms.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Course;
import com.cg.fms.repository.ICourseRepository;

@Service
public class ICourseImplementation implements ICourseService{
	@Autowired
	private ICourseRepository cr;

	@Override
	public String addcourse(Course c) {
		Optional<Course> r = cr.findById(c.getCourseId());
		if(r.isPresent()){
			return "Party with id "+c.getCourseId()+" already exists!";
		}
		else {
		cr.save(c);
		return "Party added succesfully";
		}
	}

	@Override
	public String updatecourse(String id, Course c) {
		try {
			Course co=cr.getById(id);
			co.setCourseName(c.getCourseName());
			co.setCourseDescription(c.getCourseDescription());
			co.setCourseId(c.getCourseId());
			co.setNoOfDays(c.getNoOfDays());
			cr.save(co);
			return "Course Updated Succesfully";
		}
		catch(Exception e){
			return "No Course with id "+id+" exists!";
		}
	}

	@Override
	public String removeCourse(String id) {
		try {
			cr.deleteById(id);
			return "Deleted the details of id "+id;
		}
		catch(Exception e) {
			return "No Course Found with id "+id;
		}
	}

	@Override
	public Course viewcourse(String id) {
		return cr.findById(id).get();
	}

	@Override
	public List<Course> viewallcourses() {
		return cr.findAll();
	}


}
