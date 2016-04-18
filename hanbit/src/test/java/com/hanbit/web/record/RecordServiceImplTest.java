package com.hanbit.web.record;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanbit.web.global.Command;
import com.hanbit.web.mapper.MemberMapper;
import com.hanbit.web.mapper.RecordMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/*-context.xml")
public class RecordServiceImplTest {

	@Autowired RecordDTO record;
	@Autowired Command command;
	@Autowired SqlSession session;

	
	@Test
	public void testGetByIdWithExamDate() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		record.setId("hong");
		record.setExamDate("2016-03-31");
		list = mapper.selectByIdWithExamDate(record);
		assertNotNull(list);
	}

	
}
