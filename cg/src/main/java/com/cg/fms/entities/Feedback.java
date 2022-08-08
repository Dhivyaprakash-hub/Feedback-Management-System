package com.cg.fms.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Feedback")
public class Feedback {
	
	@Id
	@Column(name="fid")
	private String fid;

	@Column(name="participantid")
	private int participantid;
	
	@Column(name="trainingid")
	private int tid;
	
	@Column(name="feedbackCriteria1")
	private int feedbackCriteria1;
	
	@Column(name="feedbackCriteria2")
	private int feedbackCriteria2;
	
	@Column(name="feedbackCriteria3")
	private int feedbackCriteria3;
	
	@Column(name="feedbackCriteria4")
	private int feedbackCriteria4;
	
	@Column(name="feedbackCriteria5")
	private int feedbackCriteria5;

	
	@Column(name="comments")
	private String comments;
	
	@Column(name="suggestions")
	private String suggestions;	
	
	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}
	public int getParticipantid() {
		return participantid;
	}

	public void setParticipantid(int participantid) {
		this.participantid = participantid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getFeedbackCriteria1() {
		return feedbackCriteria1;
	}

	public void setFeedbackCriteria1(int feedbackCriteria1) {
		this.feedbackCriteria1 = feedbackCriteria1;
	}

	public int getFeedbackCriteria2() {
		return feedbackCriteria2;
	}

	public void setFeedbackCriteria2(int feedbackCriteria2) {
		this.feedbackCriteria2 = feedbackCriteria2;
	}

	public int getFeedbackCriteria3() {
		return feedbackCriteria3;
	}

	public void setFeedbackCriteria3(int feedbackCriteria3) {
		this.feedbackCriteria3 = feedbackCriteria3;
	}

	public int getFeedbackCriteria4() {
		return feedbackCriteria4;
	}

	public void setFeedbackCriteria4(int feedbackCriteria4) {
		this.feedbackCriteria4 = feedbackCriteria4;
	}

	public int getFeedbackCriteria5() {
		return feedbackCriteria5;
	}

	public void setFeedbackCriteria5(int feedbackCriteria5) {
		this.feedbackCriteria5 = feedbackCriteria5;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}
}
	

	

