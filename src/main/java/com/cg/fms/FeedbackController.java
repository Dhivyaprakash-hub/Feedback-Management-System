package com.cg.fms;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@RestController @RequestMapping("/api/v1") public class FeedbackController {
 private final FeedbackService service; private final String submissionKey; private final String adminKey;
 public FeedbackController(FeedbackService service,@Value("${feedback.submission-key}") String submissionKey,@Value("${feedback.admin-key}") String adminKey){this.service=service;this.submissionKey=submissionKey;this.adminKey=adminKey;}
 @GetMapping("/surveys") public List<SurveyView> surveys(){return service.listSurveys().stream().map(SurveyView::from).toList();}
 @PostMapping("/surveys") @ResponseStatus(HttpStatus.CREATED) public SurveyView create(@RequestHeader(value="X-Admin-Key",required=false) String key,@Valid @RequestBody CreateSurvey request){requireKey(key,adminKey);return SurveyView.from(service.createSurvey(request.title(),request.course(),request.trainer(),request.opensOn(),request.closesOn()));}
 @PostMapping("/surveys/{id}/responses") @ResponseStatus(HttpStatus.NO_CONTENT) public void submit(@PathVariable UUID id,@RequestHeader(value="X-Submission-Key",required=false) String key,@Valid @RequestBody Response request){requireKey(key,submissionKey);service.submit(id,request.contentScore(),request.trainerScore(),request.materialsScore(),request.wouldRecommend());}
 @GetMapping("/surveys/{id}/summary") public FeedbackService.Summary summary(@PathVariable UUID id){return service.summary(id);}
 private void requireKey(String supplied,String expected){if(supplied==null||!MessageDigest.isEqual(supplied.getBytes(StandardCharsets.UTF_8),expected.getBytes(StandardCharsets.UTF_8)))throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"A valid API key is required");}
 public record CreateSurvey(@NotBlank @Size(max=140) String title,@NotBlank @Size(max=140) String course,@NotBlank @Size(max=120) String trainer,@NotNull LocalDate opensOn,@NotNull LocalDate closesOn){}
 public record Response(@Min(1) @Max(5) int contentScore,@Min(1) @Max(5) int trainerScore,@Min(1) @Max(5) int materialsScore,boolean wouldRecommend){}
 public record SurveyView(UUID id,String title,String course,String trainer,LocalDate opensOn,LocalDate closesOn,String status){static SurveyView from(Survey s){return new SurveyView(s.getId(),s.getTitle(),s.getCourse(),s.getTrainer(),s.getOpensOn(),s.getClosesOn(),s.getStatus());}}
}
