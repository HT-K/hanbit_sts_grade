package com.hanbit.web.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.hanbit.web.global.Constants;
import com.hanbit.web.grade.GradeServiceImpl;
import com.hanbit.web.util.FileUpload;

@Controller
@SessionAttributes("user")
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberDTO member;
	@Autowired MemberService service;
	
	@RequestMapping("/join2")
	public String join(){
		logger.info("===member-join(GET)===");
		return "member/join_form";
	}	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public @ResponseBody MemberDTO join(@RequestBody MemberDTO param){
		logger.info("===member-join(POST)===");
		logger.info("넘어온 ID = {}", param.getId());
		
		member.setId(param.getId());
		member.setPassword(param.getPassword());
		member.setName(param.getName());
		member.setAddr(param.getAddr());
		member.setBirth(param.getBirth());
		member.setCate(param.getCate());
		service.join(member);
		return member;
	}	
	@RequestMapping("/list")
	public @ResponseBody List<MemberDTO> list(){
		logger.info("===member-list(GET)===");
		List<MemberDTO> list =  new ArrayList<MemberDTO>();
		list = service.getList();
		return list;
	}
	@RequestMapping("/name/{name}")
	public String getMembersByName(@PathVariable("name")String name){
		return "member/login_form";
	}
	@RequestMapping("/content/{id}")
	public String getMemberContent(@PathVariable("id")String id,Model model){
		logger.info("=== member-getMemberContent() ===");
		if (service.isMember(id)) {
			member = service.detail(id);
			member.setRole(User.valueOf(service.detail(id).getCate()).toString());
			model.addAttribute("member",member);
		} else {
			model.addAttribute("member","");
		}
		return "auth/member/content.user";
	}	
	@RequestMapping("/detail")
	public @ResponseBody MemberDTO getMemberById(Model model,HttpSession session){
		logger.info("=== member-getMemberById() ===");
		member = (MemberDTO) session.getAttribute("user");
		String id = member.getId();
		logger.info("세션에 들어있는 ID = {}",id);
		if (service.isMember(id)) {
			member = service.detail(id);
			member.setRole(User.valueOf(service.detail(id).getCate()).toString());
			model.addAttribute("member",member);
		} else {
			model.addAttribute("member","");
		}
		return member;
	}	
	@RequestMapping("/count")
	public String count(Model model){
		int count = service.count();
		return "member/login_form";
	}	
	@RequestMapping("/login")
	public String login(){
		return "member/login.user";
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
			// 복수의 세션값 저장시 사용
			model.addAttribute("user", member);
			// 세션값 삭제 시 아래 메소드 사용
			// status.setComplete();
			
			/*
			=== [비교] ===
			단수의 세션값 저장시 사용
			session.setAttribute("user", member);
			세션값 삭제 시 아래 메소드 사용
			session.invalidate()
			*/
			view = "redirect:/member/content/"+id;
		} else {
			logger.info("로그인 실패");
			view = "member/login";
		}
		return view;
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus status){
		logger.info("=== member-logout() ===");
		status.setComplete();
		return "redirect:/";
	}
	/* AJAX 로 넘어오면서 필요없어짐
	@RequestMapping("/update")
	public String update(Model model,HttpSession session){
		model.addAttribute("member",session.getAttribute("user"));
		return "auth/member/update.user";
	}
	*/	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public @ResponseBody MemberDTO update(
			@RequestParam("password")String password,
			@RequestParam("addr")String addr,
			@RequestParam(value="file",required=false)MultipartFile file,
			HttpSession session,
			Model model){
		logger.info("수정폼에서 넘어온 주소 = {}",addr);
		logger.info("수정폼에서 넘어온 비밀번호 = {}",password);
		
		MemberDTO legacy = (MemberDTO) session.getAttribute("user");
		MemberDTO param = (MemberDTO) session.getAttribute("user");
		FileUpload fileUpload = new FileUpload();
		String fileName = file.getOriginalFilename();
		logger.info("수정폼에서 넘어온 파일 = {}",fileName);
		String fullPath = fileUpload.uploadFile(file, 
				Constants.IMAGE_DOMAIN, fileName );
		logger.info("이미지 저장 경로 : {}",fullPath);
		param.setProfileImg(fileName);
		param.setPassword(password);	
		param.setAddr(addr);
		int result = service.update(param);
		String view = "";
		if (result == 1) {
			model.addAttribute("user", param);
			model.addAttribute("member",param);
			view = "member/detail";
		} else {
			model.addAttribute("member",legacy);
			view = "member/update_form";
		}
		logger.info("수정 후 비번 : {}",param.getProfileImg());
		return param;
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










