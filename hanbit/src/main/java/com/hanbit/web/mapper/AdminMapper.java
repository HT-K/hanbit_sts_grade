package com.hanbit.web.mapper;

import org.springframework.stereotype.Repository;

import com.hanbit.web.admin.AdminDTO;
import com.hanbit.web.member.MemberDTO;
@Repository
public interface AdminMapper {
	public AdminDTO selectAdmin(AdminDTO admin);
	public AdminDTO login(AdminDTO admin);
}
