package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Member> MEMBER_ROW_MAPPER = new BeanPropertyRowMapper<>(Member.class);
	
	public List<Member> findAll() {
		String sql = "SELECT id,name,age FROM member ORDER BY id;";
		
		List<Member> memberList = template.query(sql, MEMBER_ROW_MAPPER);
		
		return memberList;
	}
}
