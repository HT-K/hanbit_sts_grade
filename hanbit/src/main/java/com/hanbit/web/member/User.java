package com.hanbit.web.member;

public enum User {
	비회원(0),학생(1),교수(2),관리자(3);
	
	private final int value;
	
	User(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	public static User valueOf(int value){
		switch (value) {
		case 0:return 비회원;
		case 1:return 학생;
		case 2:return 교수;
		case 3:return 관리자;
		default: throw new AssertionError("알수없는 값 :"+value);
		}
	}
	
}
