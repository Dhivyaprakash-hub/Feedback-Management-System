package com.cg.fms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.entities.Feedback;
import com.cg.fms.service.IFeedbackService;
import com.cg.fms.repository.ICourseRepository;
import com.cg.fms.repository.IFeedbackRepository;
import com.cg.fms.repository.ProgramRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;
import com.cg.fms.entities.Course;
import com.cg.fms.repository.IFeedbackRepository;
import com.cg.fms.service.IFeedbackService;


@Service
public class IFeedbackServiceImplementation implements IFeedbackService {

	@Id
	@Autowired
	private IFeedbackRepository fdr;
	ProgramRepository pr;
	
	@Override
	public String addFeedback(Feedback fd) {
		Optional<Feedback> newFeedback = fdr.findById(fd.getFid());
		if(newFeedback.isPresent()){
			return"Feedback with participant named: "+fd.getFid()+" already exists!!";
		}
		else {
		fdr.save(fd);
		return "Feedback added successfully";
		}
	}

	@Override
	public String updateFeedback(Feedback fd) {
		try {
			Feedback f=fdr.getById(fd.getFid());
			f.setTid(fd.getTid());
			f.setParticipantid(fd.getParticipantid());
            f.setFeedbackCriteria1(fd.getFeedbackCriteria1());
            f.setFeedbackCriteria2(fd.getFeedbackCriteria2());
            f.setFeedbackCriteria3(fd.getFeedbackCriteria3());
            f.setFeedbackCriteria4(fd.getFeedbackCriteria4());
            f.setFeedbackCriteria5(fd.getFeedbackCriteria5());
			f.setComments(fd.getComments());
			f.setSuggestions(fd.getSuggestions());
			fdr.save(f);
			return "Feedback Updated!!!";
		}
		catch(Exception e){
			return "Feedback does not exist!!!";
		}
	}

	@Override
	public List<Feedback> viewTrainerFeedback(int trainerid) {
		
		List<String> a=pr.findAll().stream().filter(p->p.getFacultyid()==trainerid).map(s->s.getTrainingId()).collect(Collectors.toList());
		List<Feedback> f=new ArrayList<Feedback>();
		for(String b:a)
		{
			f.add(fdr.getById(b));
		}
		return f;
	}

	@Override
	public List<Feedback> viewProgramFeedback(Program program) {
		Optional<List<Feedback>> f=Optional.of(fdr.findAll().stream().filter(s->s.getTid()==Integer.parseInt(program.getTrainingId())).collect(Collectors.toList()));
		return f.get();
	}


}