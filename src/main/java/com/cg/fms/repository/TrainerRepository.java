package com.cg.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{

}
