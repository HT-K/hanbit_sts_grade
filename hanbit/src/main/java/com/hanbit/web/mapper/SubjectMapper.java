package com.hanbit.web.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanbit.web.subject.SubjectDTO;

@Repository
public interface SubjectMapper {
	public List<SubjectDTO> selectAll();
}
