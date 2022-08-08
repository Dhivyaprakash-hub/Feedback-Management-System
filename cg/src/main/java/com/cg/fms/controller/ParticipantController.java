package com.cg.fms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.entities.Feedback;
import com.cg.fms.service.IFeedbackService;

@RestController
public class ParticipantController {

	IFeedbackService fs;
	@PostMapping("/paddfeedback")
	public String addfeedback(@RequestParam Feedback f)
	{
		return fs.addFeedback(f);
	}

}
