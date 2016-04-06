package com.hanbit.web.subject;

import org.springframework.stereotype.Component;

@Component
public class SubjectDTO {
	private int subjSeq;
	private String subName;
	
	public int getSubjSeq() {
		return subjSeq;
	}
	public void setSubjSeq(int subjSeq) {
		this.subjSeq = subjSeq;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
}
