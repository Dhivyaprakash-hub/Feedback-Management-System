package com.cg.fms.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.fms.entities.*;

@Service
public interface ParticipantService {
	String enrollParticipant(Employee emp,Program course);
	List<Participant> viewParticipant(Course course);

}
