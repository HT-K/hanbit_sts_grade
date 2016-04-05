package com.hanbit.web.member;

import java.util.List;

public interface MemberMapper {
	public int insert(MemberDTO member);
	public MemberDTO selectById(String id, String password);
	public MemberDTO selectMember(String id);
	public int update(MemberDTO member);
	public int delete(String id);
	public boolean isMember(String id);
	public List<MemberDTO> selectList();
}
