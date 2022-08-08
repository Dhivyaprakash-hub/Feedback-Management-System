package com.cg.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Course;
import com.cg.fms.entities.Employee;
import com.cg.fms.entities.Participant;
import com.cg.fms.entities.Program;
import com.cg.fms.entities.Role;
import com.cg.fms.repository.EmployeeRepository;
import com.cg.fms.repository.ParticipantRepository;

@Service
public class IParticipantService implements ParticipantService{
	
	@Autowired
	EmployeeRepository er;
	@Autowired
	ParticipantRepository pr;
	@Override
	public String enrollParticipant(Employee e, Program course) {
		Optional<Employee> emp=er.findById(e.getEid());
		if(emp.isPresent())
		{
			Optional<Participant> p=pr.findById(e.getEid());
			if(p.isPresent())
			{
				if(p.get().getCid().contains(course.getCourseid()))
				{
					return "Already enrolled for this course";
				}
				p.get().setCid(p.get().getCid()+","+course.getCourseid());
				return "Successfully enrolled";
			}
			Participant par=new Participant(e,course);
			pr.save(par);
		}
		e.setRole(Role.Participant);
		er.save(e);
		Participant par=new Participant(e,course);
		pr.save(par);
		return "Successfully Registered and enrolled";
	}

	@Override
	public List<Participant> viewParticipant(Course course) {
		
		Optional<List<Participant>> p=Optional.of(pr.findAll().stream().filter(s->s.getCid().equals(course.getCourseId())).collect(Collectors.toList()));
		if(p.isPresent())
		{
			return p.get();
		}
		return null;
	}

}
