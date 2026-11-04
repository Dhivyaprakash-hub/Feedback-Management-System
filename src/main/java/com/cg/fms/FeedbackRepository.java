package com.cg.fms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
public interface FeedbackRepository extends JpaRepository<Feedback,UUID>{
 @Query("select count(f) as responseCount, avg(f.contentScore) as contentAverage, avg(f.trainerScore) as trainerAverage, avg(f.materialsScore) as materialsAverage, sum(case when f.wouldRecommend=true then 1 else 0 end) as recommendCount from Feedback f where f.survey.id=:surveyId")
 FeedbackAggregate aggregate(@Param("surveyId") UUID surveyId);
 interface FeedbackAggregate { Long getResponseCount(); Double getContentAverage(); Double getTrainerAverage(); Double getMaterialsAverage(); Long getRecommendCount(); }
}
