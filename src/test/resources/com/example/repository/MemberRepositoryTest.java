package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.sql.Connection;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		// DBコネクション取得
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		IDatabaseConnection dbconn = new DatabaseConnection(conn);
		
		DatabaseConfig config = dbconn.getConfig();
//			config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new PostgresqlMetadataHandler());
		// new PostgresqlDataTypeFactory()
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());
		// Excel用データセット作成
		File f = new File(ClassLoader.getSystemResource("test_data.xlsx").getFile());
		IDataSet dataset = new XlsDataSet(f);
		
		// データの全削除
		DatabaseOperation.DELETE_ALL.execute(dbconn, dataset);
		
		// データの挿入
		DatabaseOperation.INSERT.execute(dbconn, dataset);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("①3件取得できること")
	void test1() {
		int expected = 3;
		assertEquals(expected, memberRepository.findAll().size());
	}
	
	@Test
	@DisplayName("②3件目の名前がpiyoであること")
	void test2() {
		String expected = "piyo";
		assertEquals(expected, memberRepository.findAll().get(2).getName());
	}
	
	@Test
	@DisplayName("③2件目の年齢が20 であること")
	void test3() {
		int expected = 20;
		assertEquals(expected, memberRepository.findAll().get(1).getAge());
	}
	
	@Test
	void tttt() {
		assertAll(
				() -> assertEquals(3, memberRepository.findAll().size()),
				() -> assertEquals("piyo", memberRepository.findAll().get(2).getName()),
				() -> assertEquals(20, memberRepository.findAll().get(1).getAge()));
	}
}
