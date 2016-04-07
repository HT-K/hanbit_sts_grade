package com.hanbit.web.member;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDTO member;
	@Autowired MemberServiceImpl service;
	
	@RequestMapping("/login")
	public String login(){
		return "member/login_form";
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
			model.addAttribute("member", member);
			view = "member/detail";
		} else {
			logger.info("로그인 실패");
			view = "member/login_form";
		}
		return view;
	}
	@RequestMapping("/update")
	public String update(Model model,HttpSession session){
		model.addAttribute("member",session.getAttribute("user"));
		return "member/update_form";
	}	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(
			@RequestParam("password")String password,
			@RequestParam("addr")String addr,
			HttpSession session,
			Model model){
		logger.info("수정폼에서 넘어온 주소 = {}",addr);
		logger.info("수정폼에서 넘어온 비밀번호 = {}",password);
		MemberDTO legacy = (MemberDTO) session.getAttribute("user");
		MemberDTO param = (MemberDTO) session.getAttribute("user");
		param.setPassword(password);	
		param.setAddr(addr);
		int result = service.update(param);
		String view = "";
		if (result == 1) {
			session.setAttribute("user", param);
			model.addAttribute("member",param);
			view = "member/detail";
		} else {
			model.addAttribute("member",legacy);
			view = "member/update_form";
		}
		logger.info("수정 후 비번 : {}",param.getPassword());
		return view;
	}	
}










