package com.hanbit.web.mapper;

import org.springframework.stereotype.Repository;

import com.hanbit.web.admin.AdminDTO;
@Repository
public interface AdminMapper {
	public AdminDTO selectAdmin(AdminDTO admin);
}
