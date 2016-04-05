package com.hanbit.web.grade;

import java.util.ArrayList;
import java.util.Map;
import java.util.ArrayList;

public class GradeServiceImpl implements GradeService{
	// 멤버 필드
	ArrayList<GradeDTO> gradeList;
	public GradeServiceImpl() {
		gradeList = new ArrayList<GradeDTO>(); // 초기화
	}
	// 멤버 메소드 에어리어
	@Override
	public void input(GradeDTO grade) {
		// 성적표 등록 
		gradeList.add(new GradeDTO(2,"김구",100,100,100,100));
		gradeList.add(new GradeDTO(3,"강감찬",90,90,90,90));
		gradeList.add(new GradeDTO(4,"유관순",80,80,80,80));
		gradeList.add(new GradeDTO(5,"김구",70,70,70,70));
		gradeList.add(grade);
	}

	@Override
	public ArrayList<GradeDTO> getList() {
		// 성적표 리스트 출력
		return gradeList;
	}

	@Override
	public GradeMemberDTO getGradeByHak(int hak) {
		// 성적표 조회(학번)
	
		return null;
	}

	@Override
	public ArrayList<GradeMemberDTO> getGradesByName(String name) {
		// 성적표 조회(이름)
		return null;
		
	}

	@Override
	public String update(GradeDTO grade) {
		// 성적표 수정
		String result = "수정하려는 학번이 존재하지 않음";
		
		return result;
	}

	@Override
	public String delete(int hak) {
		// 성적표 삭제
		return (gradeList.remove(getGradeByHak(hak))) ? "삭제 성공" : "삭제 실패";
	}

	@Override
	public int getCount() {
		// 카운트 조회
		return gradeList.size();
	}

	@Override
	public void getCountByName() {
		// 이름조회시 카운트 조회
		
	}

}
