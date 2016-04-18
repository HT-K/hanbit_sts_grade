package com.hanbit.web.record;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.global.Command;
import com.hanbit.web.mapper.RecordMapper;
@Service
public class RecordServiceImpl implements RecordService {
private static final Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);
	
	@Autowired SqlSession session;
	@Autowired RecordDTO record;
	
	@Override
	public int input(RecordDTO record) {
		logger.info("RecordService-input()");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.insert(record);
	}

	@Override
	public List<RecordDTO> getById(Command command) {
		logger.info("RecordService-getById()");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectById(command);
	}

	@Override
	public List<RecordDTO> getByName(Command command) {
		logger.info("RecordService-getByName");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectByName(command);
	}

	@Override
	public List<RecordDTO> getList(Command command) {
		logger.info("RecordService-getList");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectList(command);
	}

	@Override
	public int count() {
		logger.info("RecordService-cout");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.count();
	}

	@Override
	public int update(RecordDTO record) {
		logger.info("RecordService-update");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.update(record);
	}

	@Override
	public int delete(RecordDTO record) {
		logger.info("RecordService-delete");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.delete(record);
	}

	@Override
	public List<RecordDTO> getByIdWithExamDate(RecordDTO record) {
		logger.info("RecordService-getByIdWithExamDate()");
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		return mapper.selectByIdWithExamDate(record);
	}

}
