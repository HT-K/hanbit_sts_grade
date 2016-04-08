package com.hanbit.web.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hanbit.web.grade.GradeDTO;
import com.hanbit.web.grade.GradeMemberDTO;
@Repository
public interface GradeMapper {
	// C 성적표 등록 
		public int insert(GradeDTO grade); // 추상 메소드
		// R 성적표 리스트 출력
		public List<GradeDTO> selectAll();
		// R 성적표 조회(학번)
		public GradeMemberDTO selectGradeByHak(int hak);
		// R 성적표 조회(이름)
		public List<GradeMemberDTO> selectGradesByName(String name);
		// R 카운트 조회
		public int count();
		// U 성적표 수정
		public int update(GradeDTO grade);
		// D 성적표 삭제
		public int delete(int hak);
}
