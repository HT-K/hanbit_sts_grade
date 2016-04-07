package com.hanbit.web.member;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hanbit.web.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired SqlSession session;
	
	@Override
	public int join(MemberDTO member) {
		// 회원가입
	  return 0;
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		logger.info("memberService : login() 진입 후 id = {}",member.getId());
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		member = mapper.login(member);
		if (member != null) {
			logger.info("memberService : login() 성공 후 id = {}",member.getId());
			return member;
		} else {
			logger.info("memberService : login() 실패, 널 반환");
			return null;
		}
		// 로그인
		// 아이디가 존재하지 않아서 실패한 경우와 비번이 틀려서 실패한 경우에 따라서
		// 메시지를 전달해줘야 함
	}

	@Override
	public int update(MemberDTO member) {
		// 수정
		logger.info("memberService : update() 진입 후 주소 = {}",member.getAddr());
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		int result = mapper.update(member);
		return result;
		
	}

	@Override
	public int remove(String id) {
		// 삭제
		return 0;
	}

	@Override
	public MemberDTO detail(String id) {
		MemberDTO member = new MemberDTO();
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
