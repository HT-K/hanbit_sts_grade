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

import com.hanbit.web.member.MemberDTO;
import com.hanbit.web.member.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired MemberDTO member;
	@Autowired MemberService service;
	
	@RequestMapping("/join")
	public String join(){
		logger.info("===admin - join()===");
		return "admin/join_form";
	}	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@RequestParam("id")String id,
			@RequestParam("password")String password,
			@RequestParam("name")String name,
			@RequestParam("addr")String addr,
			@RequestParam("birth")int birth,
			@RequestParam("cate")int cate){
		logger.info("===admin - join(POST)===");
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setAddr(addr);
		member.setBirth(birth);
		member.setCate(cate);
		String view = "";
		if (service.join(member)==1) {
			view = "admin/login_form";
		} else {
			view = "admin/join_form";
		}
		return view;
	}	
	
	
	@RequestMapping("/login")
	public String login(){
		return "admin/login_form";
	}	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("id")String id,
			@RequestParam("password")String password,
			HttpSession session,
			Model model){
		logger.info("로그인 컨트롤러 파라미터 ID : {}",id);
		logger.info("로그인 컨트롤러 파라미터 PW : {}",password);
		MemberDTO param = new MemberDTO();
		param.setId(id);
		param.setPassword(password);
		member = service.login(param);
		String view = "";
		if (member != null) {
			logger.info("로그인 성공");
			session.setAttribute("user", member);
			view = "admin/admin_form";
		} else {
			logger.info("로그인 실패");
			view = "admin/login_form";
		}
		return view;
	}
}
