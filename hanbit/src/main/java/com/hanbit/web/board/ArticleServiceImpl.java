package com.hanbit.web.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.web.global.Command;
import com.hanbit.web.mapper.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService{
	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
	@Autowired SqlSession session;
	@Override
	public int write(ArticleDTO article) {
		logger.info("=== articleService : write() === ");
		logger.info(" id = {}");
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.insert(article);
	}

	@Override
	public List<ArticleDTO> getList(Command command) {
		 logger.info("=== articleService : getList() === ");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.selectAll(command);
	}

	@Override
	public List<ArticleDTO> getByName(Command command) {
		 logger.info("=== articleService : getByName() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.selectByName(command);
	}

	@Override
	public ArticleDTO getById(ArticleDTO article) {
		 logger.info("=== articleService : getById() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 ArticleDTO xxx = mapper.selectById(article);
		 logger.info("xxx 타이틀 : {}",xxx.getTitle());
		 return xxx;
	}

	@Override
	public int count() {
		 logger.info("=== articleService : count() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.count();
	}

	@Override
	public int update(ArticleDTO article) {
		 logger.info("=== articleService : update() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.update(article);
	}

	@Override
	public int delete(ArticleDTO article) {
		 logger.info("=== articleService : delete() ===");
		 ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		 return mapper.delete(article);
	}
	@Override
	public int replyInsert(ReplyDTO reply) {
		logger.info("ArticleService - replyInsert() 진입");
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.replyInsert(reply);
	}

	@Override
	public List<ReplyDTO> getReplyById(ReplyDTO reply) {
		logger.info("ArticleService - getReplyAll() 진입");
		ArticleMapper mapper = session.getMapper(ArticleMapper.class);
		return mapper.selectReplyById(reply);
	}	
}
