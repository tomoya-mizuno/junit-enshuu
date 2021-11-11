package junit.tutorial.ex01.e01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("input \"aaa\" return \"aaa\"")
	void test0101() {
		assertEquals("aaa", StringUtils.toSnakeCase("aaa"));
	}
	
	@Test
	@DisplayName("input \"HelloWorld\" return \"hello_world\"")
	void test0102() {
		assertEquals("hello_world", StringUtils.toSnakeCase("HelloWorld"));
	}
	
	@Test
	@DisplayName("input \"practiceJunit\" return \"practice_junit\"")
	void test0103() {
		assertEquals("practice_junit", StringUtils.toSnakeCase("practiceJunit"));
	}
}
