package com.hanbit.web.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.hanbit.web.member.MemberDTO;
import org.apache.commons.dbcp.BasicDataSource;

public class MemberMapperImpl implements MemberMapper{
	private JdbcTemplate temp;
	private BasicDataSource dataSource;
	private Connection con;
	public void setDataSource(BasicDataSource dataSource) {
		this.temp = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	@Override
	public int insert(MemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO login(MemberDTO member) {
		this.temp.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				return con.prepareStatement("select * from member");
			}
		});
		
		return null;
	}

	@Override
	public int update(MemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMember(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberDTO> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

}
