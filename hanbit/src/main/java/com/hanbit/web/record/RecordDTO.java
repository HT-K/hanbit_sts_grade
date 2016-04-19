package com.hanbit.web.record;

import org.springframework.stereotype.Component;

@Component
public class RecordDTO {
	private int seq, score;
	private String id, name, subject, examDate,profId, profName;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getProfId() {
		return profId;
	}
	public String getProfName() {
		return profName;
	}
	public void setProfId(String profId) {
		this.profId = profId;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}
	
}