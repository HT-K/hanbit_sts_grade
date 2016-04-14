package com.hanbit.web.board;

import java.util.ArrayList;
import java.util.List;

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
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNO",defaultValue ="1")String pageNO,
			@RequestParam(value="keyField",defaultValue ="none")String keyField,
			@RequestParam(value="keyword",defaultValue ="none")String keyword,
			Model model){
	Command command = CommandFactory.createCommand("article","list", pageNO, keyField, keyword,service.count());
	List<ArticleDTO> list = new ArrayList<ArticleDTO>();
	logger.info("현재 페이지 = {}",command.getPageNO());
	logger.info("현재 startPage = {}",command.getStartPage());
	logger.info("현재 endPage = {}",command.getEndPage());
	logger.info("현재 startRow = {}",command.getStartRow());
	logger.info("현재 endRow = {}",command.getEndRow());
	logger.info("현재 KeyField = {}",command.getKeyField());
	logger.info("현재 Keyword = {}",command.getKeyword());
	if (keyField.equals("none")) {
		logger.info("전체 글 가져오기!! ");
		list = service.getList(command);
		 model.addAttribute("list",list);
		 logger.info("검색된 글 목록 : {} ",list);
	} else {
		logger.info("검색된 글 가져오기!! ");
		list = service.getByName(command);
		 model.addAttribute("list",list);
		 logger.info("검색된 글 목록 : {} ",list);
	}
	 	model.addAttribute("command", command);
		return "board/list";
	}

	@RequestMapping("/search/{id}")
	public String findById(@PathVariable("id")int id,
			Model model){
		logger.info("findById() 상세 글 가져오기!! ");
		article.setArticleId(id);
		article = service.getById(article);
		logger.info("상세글 결과 : {}",article);
		model.addAttribute("article", article);
		return "board/list";
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
