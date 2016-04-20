package com.hanbit.web.subject;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	@Autowired SubjectDTO subject;
	@Autowired SubjectService service;
	
	@RequestMapping("/list")
	public String getList(Model model){
		logger.info("SubjectController : getList(GET)");
		List<SubjectDTO> list = service.getList();
		logger.info("SubjectController : getList() 결과 {}",list.get(0).getSubjName());
		model.addAttribute("list",list);
		return "auth/admin/content.admin";
	}
	
}
