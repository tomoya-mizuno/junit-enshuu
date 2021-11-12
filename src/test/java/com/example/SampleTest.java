package com.example;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.File;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

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
class SampleTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private Sample sample;

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
//		config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new PostgresqlMetadataHandler());
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
	@DisplayName("20歳以上はfugaとpiyo")
	void testProc() throws Exception {
		List<String> expected = Arrays.asList("fuga", "piyo");
		assertIterableEquals(expected, sample.proc());
		
	}

}
