package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hanbit.web.mapper.GradeMapper;
import com.hanbit.web.mapper.MemberMapper;
import com.hanbit.web.member.MemberController;


public class GradeServiceImpl implements GradeService{
	private static final Logger logger = LoggerFactory.getLogger(GradeServiceImpl.class);
	// 멤버 필드
	@Autowired SqlSession session;
	// 멤버 메소드 에어리어
	@Override
	public int input(GradeDTO grade) {
		// 성적표 등록 
		logger.info("===gradeService : input()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.insert(grade);
	}

	@Override
	public List<GradeDTO> getList() {
		// 성적표 리스트 출력
		logger.info("===gradeService : getList()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.selectAll();
	}

	@Override
	public GradeMemberDTO getGradeByHak(int hak) {
		// 성적표 조회(학번)
		logger.info("===gradeService : getGradeByHak()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.selectGradeByHak(hak);
	}

	@Override
	public List<GradeMemberDTO> getGradesByName(String name) {
		// 성적표 조회(이름)
		logger.info("===gradeService : getGradesByName()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.selectGradesByName(name);
		
	}

	@Override
	public int update(GradeDTO grade) {
		// 성적표 수정
		logger.info("===gradeService : update()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.update(grade);
	}

	@Override
	public int delete(int hak) {
		// 성적표 삭제
		logger.info("===gradeService : delete()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.delete(hak);
	}

	@Override
	public int getCount() {
		// 카운트 조회
		logger.info("===gradeService : getCount()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return mapper.count();
	}

	@Override
	public int getCountByName() {
		// 이름조회시 카운트 조회
		logger.info("===gradeService : getCountByName()===");
		GradeMapper mapper = session.getMapper(GradeMapper.class);
		return 0;
	}

}
