package com.hanbit.web.record;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hanbit.web.global.Command;
@Component
@Qualifier("recordCommand")
public class RecordCommand extends Command{
	private String id;
	private String examDate;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
	
}
