package com.hanbit.web.admin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hanbit.web.grade.GradeMemberDTO;

public interface AdminService {
	public List<GradeMemberDTO>getMemberList();
	public int addScore(GradeMemberDTO bean);
	public AdminDTO getAdmin(AdminDTO admin);
}
