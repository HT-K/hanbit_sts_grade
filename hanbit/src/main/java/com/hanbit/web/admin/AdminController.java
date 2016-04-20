package com.hanbit.web.admin;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.member.MemberDTO;
import com.hanbit.web.member.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired AdminDTO admin;
	@Autowired AdminService service;
	
	
	
	@RequestMapping("/login")
	public String login(){
		logger.info("AdminController-login(GET)");
		return "admin/login.admin";
	}	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("id")String id,
			@RequestParam("password")String password,
			HttpSession session,
			Model model){
		logger.info("AdminController-login(POST)");
		logger.info("로그인 컨트롤러 파라미터 ID : {}",id);
		logger.info("로그인 컨트롤러 파라미터 PW : {}",password);
		AdminDTO param = new AdminDTO();
		param.setId(id);
		param.setPassword(password);
		
		admin = service.login(param);
		String view = "";
		if (admin != null) {
			logger.info("로그인 성공");
			session.setAttribute("user", admin);
			view = "auth/admin/content.admin";
		} else {
			logger.info("로그인 실패");
			view = "admin/login.admin";
		}
		return view;
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		logger.info("=== member-logout() ===");
		status.setComplete();
		return "redirect:/admin/login.admin";
	}	
}
