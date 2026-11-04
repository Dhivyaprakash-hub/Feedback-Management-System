package com.cg.fms;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Entity @Table(name="surveys") public class Survey {
 @Id private UUID id=UUID.randomUUID();
 @Column(nullable=false,length=140) private String title;
 @Column(nullable=false,length=140) private String course;
 @Column(nullable=false,length=120) private String trainer;
 @Column(name="opens_on",nullable=false) private LocalDate opensOn;
 @Column(name="closes_on",nullable=false) private LocalDate closesOn;
 @Column(nullable=false,length=16) private String status="OPEN";
 protected Survey(){}
 public Survey(String title,String course,String trainer,LocalDate opensOn,LocalDate closesOn){this.title=title;this.course=course;this.trainer=trainer;this.opensOn=opensOn;this.closesOn=closesOn;}
 public UUID getId(){return id;} public String getTitle(){return title;} public String getCourse(){return course;} public String getTrainer(){return trainer;} public LocalDate getOpensOn(){return opensOn;} public LocalDate getClosesOn(){return closesOn;} public String getStatus(){return status;}
 public boolean isAccepting(LocalDate today){return status.equals("OPEN")&&!today.isBefore(opensOn)&&!today.isAfter(closesOn);}
}
