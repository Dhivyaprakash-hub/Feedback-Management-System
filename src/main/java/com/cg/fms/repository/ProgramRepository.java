package com.cg.fms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, String>{
	
}