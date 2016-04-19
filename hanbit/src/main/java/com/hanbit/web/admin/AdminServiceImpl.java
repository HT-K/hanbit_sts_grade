package com.hanbit.web.admin;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.grade.GradeMemberDTO;
import com.hanbit.web.mapper.AdminMapper;
@Service
public class AdminServiceImpl implements AdminService{
	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);
	private static AdminService instance = new AdminServiceImpl();
	@Autowired SqlSession session;
	@Autowired AdminDTO admin;
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
	public AdminDTO getAdmin(AdminDTO param) {
		
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

	@Override
	public AdminDTO login(AdminDTO param) {
		logger.info("memberService : login() 진입 후 id = {}",param.getId());
		AdminMapper mapper = session.getMapper(AdminMapper.class);
		admin = mapper.login(param);
		if (admin != null) {
			logger.info("memberService : login() 성공 후 id = {}",admin.getId());
			return admin;
		} else {
			logger.info("memberService : login() 실패, 널 반환");
			return null;
		}
	}

}
