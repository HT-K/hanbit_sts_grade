package com.hanbit.web.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.admin.AdminController;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired ArticleDTO article;
	@Autowired ArticleService service;
	
	@RequestMapping("/write")
	public String write(){
		return "";
	}
	@RequestMapping("/list")
	public String list(){
		return "board/list";
	}
	@RequestMapping("/name")
	public String findByName(){
		return "";
	}
	@RequestMapping("/id")
	public String findById(){
		return "";
	}
	@RequestMapping("/count")
	public String count(){
		return "";
	}
	@RequestMapping("/update")
	public String update(){
		return "";
	}
	@RequestMapping("/delete")
	public String delet(){
		return "";
	}
}
