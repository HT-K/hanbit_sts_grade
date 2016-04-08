package com.hanbit.web.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hanbit.web.grade.GradeServiceImpl;

@Controller
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDTO member;
	@Autowired MemberService service;
	
	@RequestMapping("/join")
	public String join(){
		logger.info("로그인 컨트롤러 파라미터 ID : {}");
		return "member/join_form";
	}	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@RequestParam("id")String id,
			@RequestParam("password")String password,
			@RequestParam("name")String name,
			@RequestParam("addr")String addr,
			@RequestParam("birth")int birth,
			@RequestParam("cate")int cate){
		logger.info("===member-join=== ID : {}");
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		member.setAddr(addr);
		member.setBirth(birth);
		member.setCate(cate);
		String view = "";
		if (service.join(member)==1) {
			view = "member/login";
		} else {
			view = "member/join_form";
		}
		return view;
	}	
	@RequestMapping("/list")
	public String list(Model model){
		model.addAttribute("list",service.getList());
		return "member/member_list";
	}
	@RequestMapping("/name/{name}")
	public String getMembersByName(@PathVariable("name")String name){
		return "member/login_form";
	}	
	@RequestMapping("/detail/{id}")
	public String getMemberById(@PathVariable("id")String id,Model model){
		logger.info("=== member-getMemberById() ===");
		if (service.isMember(id)) {
			member = service.detail(id);
			member.setRole(User.valueOf(service.detail(id).getCate()).toString());
			model.addAttribute("member",member);
		} else {
			model.addAttribute("member","");
		}
		return "member/detail";
	}	
	@RequestMapping("/count")
	public String count(Model model){
		int count = service.count();
		return "member/login_form";
	}	
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
			view = "redirect:/member/detail/"+id;
		} else {
			logger.info("로그인 실패");
			view = "member/login_form";
		}
		return view;
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		logger.info("=== member-logout() ===");
		status.setComplete();
		return "redirect:/";
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
	@RequestMapping("/delete")
	public String delete(Model model,HttpSession session){
		logger.info("=== member-delete() ===");
		int result = service.remove((MemberDTO) session.getAttribute("user"));
		if (result==1) {
			logger.info("회원탈퇴 성공");
		} else {
			logger.info("회원탈퇴 실패");
		}
		return "redirect:/";
	}	
}










