package com.hanbit.web.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hanbit.web.grade.GradeMemberDTO;
import com.hanbit.web.member.MemberDTO;

public interface AdminService {
	public List<GradeMemberDTO>getMemberList();
	public int addScore(GradeMemberDTO bean);
	public AdminDTO getAdmin(AdminDTO admin);
	public AdminDTO login(AdminDTO member);
}
