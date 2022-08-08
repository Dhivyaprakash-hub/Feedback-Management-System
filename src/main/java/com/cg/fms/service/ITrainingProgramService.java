package com.cg.fms.service;

import java.time.LocalDate;


import java.util.List;

import com.cg.fms.entities.Program;

public interface ITrainingProgramService {

	public String createProgram(Program pr);
	public String updateProgram(Program pr);
	public Program viewProgram(String programid);
	public List<Program> viewAllPrograms();
	public List<Program> viewAllProgramsByDate(LocalDate date);
	public List<Program> viewAllProgramsByFaculty(int facultyid);
	public String removeProgram(Program programid);
}