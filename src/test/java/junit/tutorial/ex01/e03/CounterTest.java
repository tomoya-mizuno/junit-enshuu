package junit.tutorial.ex01.e03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CounterTest {
	
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
	@DisplayName("execute incremnet method before execute")
	void test0301() {
		Counter counter = new Counter();
		assertEquals(1, counter.increment());
	}
	
	@Test
	@DisplayName("execute increment method after once execute")
	void test0302() {
		Counter counter = new Counter();
		counter.increment();
		
		assertEquals(2, counter.increment());
	}
	
	@Test
	@DisplayName("execute increment method after 50 times execute")
	void test0303() {
		Counter counter = new Counter();
		for (int i = 0; i < 50; i++) {
			counter.increment();
		}
		
		assertEquals(51, counter.increment());
	}
}
