package com.hanbit.web.record;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hanbit.web.global.Command;
import com.hanbit.web.grade.GradeDTO;

public interface RecordService {
	public int input(GradeDTO grade);
	public List<RecordDTO> getByIdWithExamDate(RecordDTO record);
	public List<RecordDTO> getById(Command command);
	public List<RecordDTO> getByName(Command command);
	public List<RecordDTO> getList(Command command);
	public int count();
	public int update(RecordDTO record);
	public int delete(RecordDTO record);	
}

