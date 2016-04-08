package com.hanbit.web.member;

public enum UserByTaehyun {
	//비회원(0),학생(1),교수(2),관리자(3);
	NON(0,"비회원"), STU(1,"학생"), TEA(2,"교수"), ADM(3,"관리자");
	
//	private static final User NON = new User(0,"비회원");
	
	private final int value;
	private final String role;
	
	UserByTaehyun(int value, String role) {
		this.value = value;
		this.role = role;
	}

	public int getValue() {
		return value;
	}
	
	public String getRole() {
		return role;
	}
	
	
	public static UserByTaehyun valueOf(int value){
/*		switch (value) {
		case 0:return 비회원;
		case 1:return 관리자;
		case 2:return 교수;
		case 3:return 학생;
		default: throw new AssertionError("알수없는 값 :"+value);
		}
*/		switch (value) {
		case 0:return NON;
		case 1:return STU;
		case 2:return TEA;
		case 3:return ADM;
		default: throw new AssertionError("알수없는 값 :"+value);
		}
	}
	
	public static void main(String[] args) {
		UserByTaehyun.valueOf("ADM").getRole();
	}
}
