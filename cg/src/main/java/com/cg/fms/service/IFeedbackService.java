package com.cg.fms.service;


import java.util.List;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;

public interface IFeedbackService 
{

	public String addFeedback(Feedback fd);
	public String updateFeedback(Feedback fd);

	public List<Feedback> viewTrainerFeedback(int trainerid);
	public List<Feedback> viewProgramFeedback(Program program);

}