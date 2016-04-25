package com.hanbit.web.board;

import java.util.List;

import com.hanbit.web.global.Command;

public interface ArticleService {
	public int write(ArticleDTO article);
	public List<ArticleDTO> getList(Command command);
	public List<ArticleDTO> getByName(Command command);
	public ArticleDTO getById(ArticleDTO article);
	public int count();
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
	public int replyInsert(ReplyDTO reply);
	public List<ReplyDTO> getReplyById(ReplyDTO reply);
}
