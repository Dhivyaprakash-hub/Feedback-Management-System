package com.cg.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.Employee;
import com.cg.fms.entities.Trainer;

@Service
public interface TrainerManagementService {
	String addTrainer(Trainer t);
	String updateTrainer(Trainer t);
	String removeTrainer(Employee e);
	Trainer viewTrainer(Employee e);
	List<Trainer> viewAllTrainer(String skills);
	List<Trainer> viewAllTrainer();

}
