package com.cg.fms.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Course;
import com.cg.fms.entities.Employee;
import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Participant;
import com.cg.fms.entities.Program;
import com.cg.fms.entities.Trainer;
import com.cg.fms.service.ICourseService;
import com.cg.fms.service.IFeedbackService;
import com.cg.fms.service.ITrainingProgramService;
import com.cg.fms.service.ParticipantService;
import com.cg.fms.service.TrainerManagementService;


@RestController
public class AdminController {
	@Autowired
	ParticipantService ps;
	@Autowired
	ICourseService cs;
	@Autowired
	IFeedbackService fs;
	@Autowired
	ITrainingProgramService tps;
	@Autowired
	TrainerManagementService tms;
	
	@PostMapping("/enroll")
	public String enroll(@RequestBody Employee e,@RequestBody Program c)
	{
		return ps.enrollParticipant(e,c);
	}
	
	@GetMapping("/Viewpar")
	public List<Participant> viewpar(@RequestBody Course c)
	{
		return ps.viewParticipant(c);
	}
	
	@PostMapping("/addc")
	public String Addcourse(@RequestBody Course c)
	{
		return cs.addcourse(c);
	}

	@GetMapping("/viewcourse/{id}")
	public Course viewcourse(@PathVariable String id)
	{
		return cs.viewcourse(id);
	}
	
	@GetMapping("/viewallcourse")
	public List<Course> viewallcourse()
	{
		return cs.viewallcourses();
	}
	
	@PutMapping("/updatecourse")
	public String updatecourse(@RequestBody String id,@RequestBody Course c)
	{
		return cs.updatecourse(id,c);
	}
	
	@DeleteMapping("/removecourse")
	public String removecourse(@RequestBody String id)
	{
		return cs.removeCourse(id);
	}
	
	@PostMapping("/addfeedback")
	public String addfeedback(@RequestBody Feedback f)
	{
		return fs.addFeedback(f);
	}

	
	@PutMapping("/updateFeedback")
	String updatefeedback(@RequestBody Feedback f)
	{
		return fs.updateFeedback(f);
	}

	@GetMapping("/viewprogfeed")
	public List<Feedback> viewprogfeed(@RequestBody Program p)
	{
		return fs.viewProgramFeedback(p);
	}
	
	@GetMapping("/viewtrafeed")
	public List<Feedback> viewtrafees(@RequestBody Trainer t)
	{
		return fs.viewTrainerFeedback(t.getTid());
	}
	
	@GetMapping("/viewallprog")
	public List<Program> viewallprog()
	{
		return tps.viewAllPrograms();
	}
	
	@PostMapping("/createprog")
	public String createprog(Program p)
	{
		return tps.createProgram(p);
	}
	
	@DeleteMapping("/removeprog")
	public String removdprog(Program p)
	{
		return tps.removeProgram(p);
	}
	
	@GetMapping("/viewprogbydate")
	public List<Program> viewprogbydate(@RequestBody LocalDate d)
	{
		return tps.viewAllProgramsByDate(d);
	}
	
	@GetMapping("/viewprogby")
	public List<Program> viewprogby(@RequestParam int id)
	{
		return tps.viewAllProgramsByFaculty(id);
	}
	
	@GetMapping("/viewprog")
	public Program viewprog(@RequestParam String id)
	{
		return tps.viewProgram(id);
	}
	
	@GetMapping("/viewtrainer")
	public Trainer viewtrainer(@RequestParam Employee e)
	{
		return tms.viewTrainer(e);
	}
	
	@GetMapping("/viewalltrainer")
	public List<Trainer> viewalltrainer()
	{
		return tms.viewAllTrainer();
	}
	
	@GetMapping("/viewalltrainerbyskill")
	public List<Trainer> viewtrainerbyskill(@RequestParam String s)
	{
		return tms.viewAllTrainer(s);
	}
	
	@PostMapping("/addtrainer")
	public String addtrainer(@RequestParam Trainer t)
	{
		return tms.addTrainer(t);
	}
	
	@DeleteMapping("/removetrainer")
	public String removetrainer(@RequestParam Employee e)
	{
		return tms.removeTrainer(e);
	}
}
