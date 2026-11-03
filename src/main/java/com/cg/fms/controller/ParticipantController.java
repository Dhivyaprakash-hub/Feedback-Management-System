package com.cg.fms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.fms.entities.Feedback;
import com.cg.fms.service.IFeedbackService;

@RestController
public class ParticipantController {

	@Autowired
	private IFeedbackService fs;
	@PostMapping("/paddfeedback")
	public String addfeedback(@RequestBody Feedback f)
	{
		return fs.addFeedback(f);
	}

}
