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
import static org.hamcrest.CoreMatchers.*;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.mapper.GradeMapper;
import com.hanbit.web.mapper.RecordMapper;
import com.hanbit.web.util.ExamDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/*-context.xml")
public class RecordServiceImplTest {

	@Autowired RecordDTO record;
	@Autowired GradeDTO grade;
	@Autowired SqlSession session;
	@Autowired RecordCommand command;

	@Test
	public void testInput() {
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		grade.setExamDate(ExamDate.getDate());
		grade.setId("hye");
		grade.setScore(80);
		grade.setSubjSeq(1);
		assertThat(mapper.insert(grade),is(1));
	}

	@Test
	public void testGetById() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		command.setId("hong");
		list = mapper.selectById(command);
		assertThat(list.size(),is(not(0)));
	}
	@Test
	public void testGetByIdWithExamDate() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		record.setId("hong");
		record.setExamDate("2016-03-31");
		list = mapper.selectByIdWithExamDate(record);
		assertThat(list.get(0).getName(),is(equalTo("홍길동")));
	}

	@Test
	public void testGetByName() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		command.setName("홍길동");
		list = mapper.selectByName(command);
		assertThat(list.get(0).getName(), is(equalTo("홍길동"))); // null이면 빨간불 null아니면 초록불~
	}

	@Test
	public void testGetList() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		List<RecordDTO> list = new ArrayList<RecordDTO>();
		list = mapper.selectList(command);
		assertThat(list.size(), is(not(0))); // null이면 빨간불 null아니면 초록불~
	}

	@Test
	public void testCount() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		int count = mapper.count();
		assertThat(count,is(not(0))); // null이면 빨간불 null아니면 초록불~
	}

	@Test
	public void testUpdate() {
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		record.setId("kim");
		record.setExamDate("2016-03-31");
		record.setSubject("java");
		record.setScore(50);
		int count = mapper.update(record);
		assertThat(count, is(not(0))); // null이면 빨간불 null아니면 초록불~
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
