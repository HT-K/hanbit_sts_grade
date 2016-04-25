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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanbit.web.admin.AdminController;
import com.hanbit.web.global.Command;
import com.hanbit.web.global.CommandFactory;

@Controller
@RequestMapping("/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	@Autowired ArticleDTO article;
	@Autowired ArticleService service;
	@Autowired ReplyDTO replyDTO;
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
		return "redirect:/article/list";
	}
	@RequestMapping("/list/{pageNO}")
	public Model listWithPage(@PathVariable(value="pageNO")String pageNO,
			Model model){
	Command command = CommandFactory.createCommand("article","list", pageNO, "none", "none",service.count());
	List<ArticleDTO> list = new ArrayList<ArticleDTO>();
	logger.info("=== listWithPage() ===");
	logger.info("현재 페이지 = {}",command.getPageNO());
	logger.info("현재 startPage = {}",command.getStartPage());
	logger.info("현재 endPage = {}",command.getEndPage());
	logger.info("현재 startRow = {}",command.getStartRow());
	logger.info("현재 endRow = {}",command.getEndRow());
	list = service.getList(command);
	logger.info("페이징 처리된 리스트 결과 {}",list);
	 	model.addAttribute("command", command);
	 	model.addAttribute("list", list);
		return model;
	}
	@RequestMapping("/list2/")
	public Model list(@RequestParam(value="pageNO")String pageNO,
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
		return model;
	}

	@RequestMapping("/search/{id}")
	public void findById(@PathVariable("id")int id,
			Model model){
		logger.info("findById() 상세 글 가져오기!! ");
		article.setArticleId(id);
		article = service.getById(article);
		logger.info("상세글 결과 : {}",article);
		model.addAttribute("article", article);
		
	}
	@RequestMapping("/count")
	public String count(){
		
		
		
		return "";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(
			@RequestParam("articleId")int articleId,
			@RequestParam("title")String title,
			@RequestParam("writerName")String writerName,
			@RequestParam("password")String password,
			@RequestParam("content")String content,
			Model model){
		logger.info("=== update() ===");
		logger.info("update() 에 넘어온 컨텐츠 : {}",content);
		article.setArticleId(articleId);
		article.setContent(content);
		article.setPassword(password);
		article.setTitle(title);
		article.setWriterName(writerName);
		service.update(article);
		logger.info("수정된 결과 {}",service.getById(article).getContent());
		model.addAttribute("id",articleId);
		
	}
	@RequestMapping("/delete")
	public void delete(
			@RequestParam("articleId")int articleId,Model model){
		article.setArticleId(articleId);
		int result = service.delete(article);
		if (result == 1) {
			model.addAttribute("message","삭제 성공 !!");
		} else {
			model.addAttribute("message","삭제 실패 !!");
		}
	}
	@RequestMapping("/detail/{articleId}") // 게시글 제목 클릭 시 게시글 내용을 디비에서 가져와서 보여주기 위해 호출되는 메소드
	public @ResponseBody ArticleDTO detail( // ajax를 쓰기 때문에 return 값에 굳이 이동할 페이지가 없어도 된다 (해당 페이지에서 어느 부분을 지우고 그 부분에 원하는 결과를 띄우는게 ajax이기 때문!)
			@PathVariable("articleId")int articleId,
			Model model) {
		logger.info("detail() 진입 체크");
		article = service.getById(article);
		logger.info("detail() DB 다녀온 결과 제목 : {}",article.getTitle());
		return article;
	}
	@RequestMapping("/reply")
	public void reply( // detail(게시판에서 게시글 제목 클릭 시 해당 게시글 내용 보여주기) 진입 시 해당 게시글에 달려있는 댓글들도 자동으로 보여주기 위해 호출되는 메소드
			@RequestParam("articleId")int articleId,
			Model model) {
		logger.info("게시글 댓글들만 가져오기 메소드 진입 성공");
		
		// 댓글을 가져오려면 해당 게시글 번호를 데이터베이스에 보내줘야한다~
		model.addAttribute("reply", service.getReplyAll(articleId)); // JSON 형태로 $.ajax()의 success에 값이 보내진다.
	}
	
	@RequestMapping(value="/reply", method=RequestMethod.POST) // ajax로 이 URL을 호출해서 리턴 페이지가 필요없다!
	public void reply( // '댓글 등록' 클릭 시 호출되는 메소드
			@RequestParam("articleId")int articleId,
			@RequestParam("writerName")String writerName,
			@RequestParam("reply")String reply,
			Model model) {
		logger.info("댓글 등록과 해당 게시글 댓글들 가져오기 메소드 진입 성공");
		replyDTO.setArticleId(articleId);
		replyDTO.setWriterName(writerName);
		replyDTO.setReply(reply);
		
		int res = service.replyInsert(replyDTO);
				
		if (res == 1) {
			logger.info("=== replyInsert 성공 ===");
			model.addAttribute("reply", service.getReplyAll(articleId)); // JSON 형태로 $.ajax()의 success에 값이 보내진다.
			for (ReplyDTO temp : service.getReplyAll(articleId)) {
				logger.info("작성자 : {}", temp.getWriterName());
				logger.info("댓글 내용 : {}", temp.getReply());
			}
		} else {
			logger.info("=== replyInsert 실패 ===");
		}
	}
}
