package com.hanbit.web.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.hanbit.web.global.Command;
import com.hanbit.web.record.RecordDTO;

@Repository
public interface RecordMapper {
	public List<RecordDTO> selectById(Command command);
	public List<RecordDTO> selectByIdWithExamDate(RecordDTO record);
	public List<RecordDTO> selectByName(Command command);
	public List<RecordDTO> selectList(Command command);
	public int count();
	public int update(RecordDTO record);
}