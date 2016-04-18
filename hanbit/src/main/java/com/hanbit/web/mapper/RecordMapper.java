package com.hanbit.web.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.hanbit.web.record.RecordDTO;

@Repository
public interface RecordMapper {

	public int insert(RecordDTO record);
	public RecordDTO selectById(RecordDTO record);
	public List<RecordDTO> selectByName(RecordDTO record);
	public List<RecordDTO> selectList();
	public int count();
	public int update(RecordDTO record);
	public int delete(RecordDTO record);
	
}