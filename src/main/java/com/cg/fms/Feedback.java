package com.cg.fms;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
@Entity @Table(name="feedback_responses",indexes=@Index(name="idx_feedback_survey",columnList="survey_id")) public class Feedback {
 @Id private UUID id=UUID.randomUUID();
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="survey_id",nullable=false) private Survey survey;
 @Column(name="content_score",nullable=false) private int contentScore;
 @Column(name="trainer_score",nullable=false) private int trainerScore;
 @Column(name="materials_score",nullable=false) private int materialsScore;
 @Column(name="would_recommend",nullable=false) private boolean wouldRecommend;
 @Column(name="submitted_at",nullable=false) private Instant submittedAt=Instant.now();
 protected Feedback(){}
 public Feedback(Survey survey,int contentScore,int trainerScore,int materialsScore,boolean wouldRecommend){this.survey=survey;this.contentScore=contentScore;this.trainerScore=trainerScore;this.materialsScore=materialsScore;this.wouldRecommend=wouldRecommend;}
}
