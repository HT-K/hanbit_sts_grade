package com.hanbit.web.record;

import java.util.List;

import org.springframework.stereotype.Service;

public interface RecordService {
	public int input(RecordDTO record);
	public RecordDTO getById(RecordDTO record);
	public List<RecordDTO> getByName(RecordDTO record);
	public List<RecordDTO> getList();
	public int count();
	public int update(RecordDTO record);
	public int delete(RecordDTO record);	
	
}

