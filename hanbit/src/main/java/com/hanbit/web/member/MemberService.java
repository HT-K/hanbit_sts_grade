package com.hanbit.web.member;

import java.util.List;

public interface MemberService {
	// 인터페이스는 추상메소드만 와야 한다는 문법이 있어서
	// abstract를 생략 가능하다
	// 그러나 추상클래스는 구상 메소드가 존재 가능하므로
	// 둘을 구분하기 위해서 반드시 abstract 을 붙여야 한다
	public abstract int join(MemberDTO member);
	public MemberDTO login(MemberDTO member);
	public MemberDTO detail(String id);
	public int update(MemberDTO member);
	public int remove(MemberDTO member);
	public boolean isMember(String id);
	public List<MemberDTO> getList();
	public int count();
}
