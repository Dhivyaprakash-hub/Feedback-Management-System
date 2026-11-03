package com.cg.fms.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;
import com.cg.fms.entities.Trainer;
import com.cg.fms.service.IFeedbackService;
import com.cg.fms.service.ITrainingProgramService;

@RestController
@RequestMapping("/coo")
public class CoordinatorController {
	@Autowired
	private IFeedbackService fs;
	@Autowired
	private ITrainingProgramService tps;
	
	@PutMapping("/cupdateFeedback")
	public String updatefeedback(@RequestBody Feedback f)
	{
		return fs.updateFeedback(f);
	}

	@PostMapping("/cviewprogfeed")
	public List<Feedback> viewprogfeed(@RequestBody Program p)
	{
		return fs.viewProgramFeedback(p);
	}
	
	@PostMapping("/cviewtrafeed")
	public List<Feedback> viewtrafees(@RequestBody Trainer t)
	{
		return fs.viewTrainerFeedback(t.getTid());
	}
	
	@GetMapping("/cviewallprog")
	public List<Program> viewallprog()
	{
		return tps.viewAllPrograms();
	}
	
	@PostMapping("/ccreateprog")
	public String createprog(@RequestBody Program p)
	{
		return tps.createProgram(p);
	}
	
	
	@GetMapping("/cviewprogbydate")
	public List<Program> viewprogbydate(@RequestParam LocalDate d)
	{
		return tps.viewAllProgramsByDate(d);
	}
	
	@GetMapping("/cviewprogby")
	public List<Program> viewprogby(@RequestParam int id)
	{
		return tps.viewAllProgramsByFaculty(id);
	}
	
	@GetMapping("/cviewprog")
	public Program viewprog(@RequestParam String id)
	{
		return tps.viewProgram(id);
	}
	

}
