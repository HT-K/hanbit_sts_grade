package com.hanbit.web.grade;

import org.springframework.stereotype.Component;

@Component
public class GradeDTO {
	private String id,examDate;
	private int subjSeq,scoreSeq,score;
	public String getId() {
		return id;
	}
	public String getExamDate() {
		return examDate;
	}
	public int getSubjSeq() {
		return subjSeq;
	}
	public int getScoreSeq() {
		return scoreSeq;
	}
	public int getScore() {
		return score;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public void setSubjSeq(int subjSeq) {
		this.subjSeq = subjSeq;
	}
	public void setScoreSeq(int scoreSeq) {
		this.scoreSeq = scoreSeq;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
