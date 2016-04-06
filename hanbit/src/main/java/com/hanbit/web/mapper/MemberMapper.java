package com.hanbit.web.mapper;

import java.util.List;

import com.hanbit.web.member.MemberDTO;

public interface MemberMapper {
	public int insert(MemberDTO member);
	public MemberDTO selectById(String id, String password);
	public MemberDTO selectMember(String id);
	public int update(MemberDTO member);
	public int delete(String id);
	public boolean isMember(String id);
	public List<MemberDTO> selectList();
}
