package com.cg.fms.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.fms.entities.Program;
import com.cg.fms.repository.ProgramRepository;
import com.cg.fms.service.ITrainingProgramService;

@Service
@RequestMapping
public class IProgramServiceImplementation implements ITrainingProgramService{

	@Id
	@Autowired
	private ProgramRepository pre;
	
	@Override
	public String createProgram(Program pr) {
		Optional<Program> newProgram = pre.findById(pr.getTrainingId());
		if(newProgram.isPresent()){
			return"Program with id "+pr.getTrainingId()+" already exists!!";
		}
		else {
		pre.save(pr);
		return "Program added successfully";
		}
	}

	@Override
	public String updateProgram(Program pr) {
		Optional<Program> newProgram = pre.findById(pr.getTrainingId());
		if(newProgram.isPresent())
		{
			Program np=newProgram.get();
			np.setCourseid(pr.getCourseid());
			np.setEndDate(pr.getEndDate());
			np.setFaculty(pr.getFacultyid());
			np.setStartDate(pr.getStartDate());
			pre.save(newProgram.get());
			return "Program updated successfully";
		}
		return "No program with ID found";
		
	}

	@Override
	public String removeProgram(Program programid) {
		try {
			pre.delete(programid);
			return "Deleted the details of id "+programid;
		}
		catch(Exception e) {
			return "No Course Found with id "+programid;
		}
	}

	@Override
	public Program viewProgram(String programid) {
		return pre.findById(programid).get();
	}
	@Override
	public List<Program> viewAllPrograms() {
		return pre.findAll();
	}

	@Override
	public List<Program> viewAllProgramsByDate(LocalDate date) {
		return pre.findAll();
	}

	@Override
	public List<Program> viewAllProgramsByFaculty(int facultyid) {
		return pre.findAll();
	}

}