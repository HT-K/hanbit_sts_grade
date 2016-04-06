package com.hanbit.web.member;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class MemberServiceImpl implements MemberService{
	private static	MemberService instance = new MemberServiceImpl();
	
	public static MemberService getInstance() {
		return instance;
	}

	@Override
	public int join(MemberDTO member) {
		// 회원가입
	  return 0;
	}

	@Override
	public MemberDTO login(String id, String password) {
		MemberDTO member = new MemberDTO();
		member = null;
		if (member != null) {
			System.out.println("서비스 : 멤버가 널이 아님");
			return member;
		} else {
			System.out.println("서비스 : 멤버가 널임");
			return null;
		}
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서
		// 메시지를 전달해줘야 함
	}

	@Override
	public int update(MemberDTO member) {
		// 수정
		return 0;
		
	}

	@Override
	public int remove(String id) {
		// 삭제
		return 0;
	}

	@Override
	public MemberDTO detail(String id) {
		return null;
		
	}
	@Override
	public boolean isMember(String id) {
		boolean member = false;
		member = false;
		
		if (member == true) {
			return member;
		} else {
			return false;
		}
	}

	@Override
	public List<MemberDTO> getList() {
		return null;
	}

}
