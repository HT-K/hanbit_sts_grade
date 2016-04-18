package com.hanbit.web.util;
/**
 *@file ExamDate.java 
 *@author pakjkwan@gmail.com
 *@date 2016. 4. 18.
 *@story 해당 학교의 시험일은 항상 그 달의 말일이다
 * 문제는 2월달이 유동적인 사실이다.
 * 윤년이면 2월29일이고, 아니면 2월 28일이 말일이다
 * 해당 년도와 월을 입력하면 말일(=시험일)이 자동으로
 * 추출되는 유틸 클래스를 완성하시오
 */
public class ExamDate {
	
	public String getEndOfMonth(){
		// SimpleDateFormat 을 사용하여
		// year 와 month 를 추출하고
		// 이 값을 사용하여 
		// 2016-02-29 이 시험일로 등록되는 메소드 완성
		// 2015-02-28 
		return "";
	}
}
