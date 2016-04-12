package com.hanbit.web.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanbit.web.admin.AdminController;
import com.hanbit.web.global.Command;
import com.hanbit.web.global.CommandFactory;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired ArticleDTO article;
	@Autowired ArticleService service;
	@RequestMapping("/write")
	public String write(
			@RequestParam("title")String title,
			@RequestParam("writerName")String writerName,
			@RequestParam("password")String password,
			@RequestParam("content")String content){
		logger.info("===ArticleController-write()===");
		logger.info("제목 = {}",title);
		logger.info("글쓴이 = {}",writerName);
		logger.info("비번 = {}",password);
		logger.info("내용 = {}",content);	
		article.setTitle(title);
		article.setWriterName(writerName);
		article.setPassword(password);
		article.setContent(content);
		int result = service.write(article);
		if (result == 1) {
			logger.info("글 등록 성공!! ");
		} else {
			logger.info("글 등록 실패!! ");
		}
		return "redirect:/article/list/1/none/none";
	}
	@RequestMapping("/list/{pageNO}/{keyField}/{keyword}")
	public String list(@PathVariable("pageNO")String pageNO,
			@PathVariable("keyField")String keyField,
			@PathVariable("keyword")String keyword,
			Model model){
	Command command = CommandFactory.createCommand("article","list", pageNO, keyField, keyword,service.count());
	logger.info("현재 페이지 = {}",command.getPageNO());
	logger.info("현재 startPage = {}",command.getStartPage());
	logger.info("현재 endPage = {}",command.getEndPage());
	logger.info("현재 startRow = {}",command.getStartRow());
	logger.info("현재 endRow = {}",command.getEndRow());
    model.addAttribute("list",service.getList(command));
    model.addAttribute("command", command);
		return "board/list";
	}
	@RequestMapping("/search")
	public String searchByKeyword(
			@RequestParam("keyField")String keyField,
			@RequestParam("keyword")String keyword,
			Model model){
		
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
