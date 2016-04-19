package com.hanbit.web.admin;

import org.springframework.stereotype.Component;

import com.hanbit.web.member.MemberDTO;
@Component
public class AdminDTO {
	private String id, password, name, addr, major, subject,role;
	private int birth, cate;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public String getMajor() {
		return major;
	}

	public String getSubject() {
		return subject;
	}

	public int getBirth() {
		return birth;
	}

	public int getCate() {
		return cate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public void setCate(int cate) {
		this.cate = cate;
	}
	
	
}
