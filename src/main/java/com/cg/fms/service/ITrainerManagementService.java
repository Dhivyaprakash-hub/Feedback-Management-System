package com.cg.fms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Employee;
import com.cg.fms.entities.Trainer;
import com.cg.fms.repository.EmployeeRepository;
import com.cg.fms.repository.TrainerRepository;

@Service
public class ITrainerManagementService implements TrainerManagementService{
	
	@Autowired
	TrainerRepository tr;
	@Autowired
	EmployeeRepository er;
	@Override
	public String addTrainer(Trainer t) {
		Optional<Trainer> a=tr.findById(t.getTid());
		if(a.isPresent())
		{
			return "Trainer already exists";
		}
		Employee e=new Employee();
		e.setEid(t.getTid());
		e.setEname(t.getTname());
		e.setPassword(t.getPassword());
		tr.save(t);
		er.save(e);
		return "Trainer added successfully";
	}

	@Override
	public String updateTrainer(Trainer t) {
		Optional<Trainer> a=tr.findById(t.getTid());
		if(a.isPresent())
		{
			Trainer b=a.get();
			b.setTname(t.getTname());
			b.setPassword(t.getPassword());
			b.setSkills(t.getSkills());
			tr.save(b);
			return "Trainer updated successfully";
		}
		return "Trainer not found";
	}

	@Override
	public String removeTrainer(Employee e) {
		Optional<Trainer> a=tr.findById(e.getEid());
		if(a.isPresent())
		{
			Trainer b=a.get();
			tr.delete(b);
			return "Trainer deleted successfully";
		}
		return "Trainer not found";
	}

	@Override
	public Trainer viewTrainer(Employee e) {
		Optional<Trainer> a=tr.findById(e.getEid());
		return a.get();
	}

	@Override
	public List<Trainer> viewAllTrainer(String skills) {
		Optional<List<Trainer>> a=Optional.of(tr.findAll().stream().filter(s->s.getSkills().contains(skills)).collect(Collectors.toList()));
		return a.get();
	}

	@Override
	public List<Trainer> viewAllTrainer() {
		return tr.findAll();
	}

}
