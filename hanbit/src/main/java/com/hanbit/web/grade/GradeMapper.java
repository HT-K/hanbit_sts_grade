package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.Map;

public interface GradeMapper {
	// C 성적표 등록 
		public void insert(GradeDTO grade); // 추상 메소드
		// R 성적표 리스트 출력
		public ArrayList<GradeDTO> selectAll();
		// R 성적표 조회(학번)
		public GradeMemberDTO selectGradeByHak(int hak);
		// R 성적표 조회(이름)
		public ArrayList<GradeMemberDTO> selecctGradesByName(String name);
		// R 카운트 조회
		public int count();
		// U 성적표 수정
		public String update(GradeDTO grade);
		// D 성적표 삭제
		public String delete(int hak);
}
