package com.hanbit.web.member;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	private String id, password, name, addr, major, subject,role,profileImg;
	private int birth, cate; // 생년월일은  800101 처럼 숫자만 입력
	
	public MemberDTO() {} // 생성자 오버로딩
	public MemberDTO(String id,String password, String name,String role, 
			String addr, int birth,String major, String subject,int cate,String profileImg) {
		this.id = id;
		this.role = role;
		this.password = password;
		this.name = name;
		this.addr = addr;
		this.birth = birth;
		this.major = major;
		this.subject = subject;
		this.cate = cate;
		this.profileImg = profileImg;
	}
	
	public String getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "회원정보 [아이디=" + id + ", 비번=" + password + ", 이름=" + name 
				+ ", 주소=" + addr + ", 전공="
				+ major + ", 과목=" + subject + ", 생년월일=" + birth + "]";
	}
	
}
