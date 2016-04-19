package com.hanbit.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.member.MemberController;

@Controller
@RequestMapping("/grade")
public class GradeController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired GradeDTO grade;
	@Autowired GradeService service;
	@RequestMapping("/{id}/score")
	public String add(@PathVariable("id")String id,
			Model model){
		logger.info("grade-add(GET)");
		model.addAttribute("id",id);
		return "grade/add_form";
	}
	@RequestMapping(value="/{id}/score",method=RequestMethod.POST)
	public String add(@PathVariable("id")String id){
		logger.info("grade-add(POST)");
		int result = service.input(grade);
		return "admin/form";
	}
}
