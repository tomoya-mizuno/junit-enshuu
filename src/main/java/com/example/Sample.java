package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sample {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// SQL
	private final String GET_NAME_OVER_20_AGE = "select * from member where age >= 20 order by id";

	public List<String> proc() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList(GET_NAME_OVER_20_AGE);
		return list.stream().map(o -> (String) o.get("name")).collect(Collectors.toList());
	}
}
