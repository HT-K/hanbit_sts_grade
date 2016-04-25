package com.hanbit.web.board;

import org.springframework.stereotype.Component;

@Component
public class ReplyDTO {
	private int replySeq;
	private int articleId;
	private String reply;
	
	public int getReplySeq() {
		return replySeq;
	}
	public int getArticleId() {
		return articleId;
	}
	public String getReply() {
		return reply;
	}
	public void setReplySeq(int replySeq) {
		this.replySeq = replySeq;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
}
