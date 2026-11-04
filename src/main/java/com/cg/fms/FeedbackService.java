package com.cg.fms;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Service public class FeedbackService {
 private final SurveyRepository surveys; private final FeedbackRepository feedback;
 public FeedbackService(SurveyRepository surveys,FeedbackRepository feedback){this.surveys=surveys;this.feedback=feedback;}
 @Transactional(readOnly=true) public List<Survey> listSurveys(){return surveys.findAll();}
 @Transactional public Survey createSurvey(String title,String course,String trainer,LocalDate opens,LocalDate closes){
  if(closes.isBefore(opens))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Survey close date must be on or after its open date");
  return surveys.save(new Survey(title.trim(),course.trim(),trainer.trim(),opens,closes));
 }
 @Transactional public void submit(UUID surveyId,int content,int trainer,int materials,boolean recommend){
  Survey survey=surveys.findById(surveyId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Survey not found"));
  if(!survey.isAccepting(LocalDate.now()))throw new ResponseStatusException(HttpStatus.CONFLICT,"This survey is not currently accepting responses");
  feedback.save(new Feedback(survey,content,trainer,materials,recommend));
 }
 @Transactional(readOnly=true) public Summary summary(UUID id){
  if(!surveys.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Survey not found");
  var result=feedback.aggregate(id); long count=result.getResponseCount()==null?0:result.getResponseCount();
  if(count<5)throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Aggregate results appear after at least five anonymous responses");
  long recommend=result.getRecommendCount()==null?0:result.getRecommendCount();
  return new Summary(count,round(result.getContentAverage()),round(result.getTrainerAverage()),round(result.getMaterialsAverage()),Math.round(recommend*100.0/count));
 }
 private double round(Double value){return value==null?0:Math.round(value*10.0)/10.0;}
 public record Summary(long responses,double contentAverage,double trainerAverage,double materialsAverage,long recommendPercent){}
}
