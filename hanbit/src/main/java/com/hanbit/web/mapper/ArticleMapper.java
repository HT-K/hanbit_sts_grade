package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.board.ArticleDTO;

@Repository
public interface ArticleMapper {
	public int insert(ArticleDTO article);
	public List<ArticleDTO> selectAll();
	public List<ArticleDTO> selectByName(ArticleDTO article);
	public ArticleDTO selectById(ArticleDTO article);
	public int count();
	public int update(ArticleDTO article);
	public int delete(ArticleDTO article);
}
