package com.hanbit.web.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hanbit.web.grade.GradeMemberDTO;
@Service
public class AdminServiceImpl implements AdminService{
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	private static AdminService instance = new AdminServiceImpl();
	
	
	public static AdminService getInstance() {
		return instance;
	}

	@Override
	public List<GradeMemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addScore(GradeMemberDTO bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AdminDTO getAdmin(AdminDTO admin) {
		
		AdminDTO temp = new AdminDTO();
		temp = null;
		if (temp != null) {
			System.out.println("어드민 서비스 : 관리자가 널이 아님");
			return temp;
		} else {
			System.out.println("어드민 서비스 : 관리자가 널임");
			return null;
		}
	}

}
