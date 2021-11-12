package junit.tutorial.ex01.e02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
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
	@DisplayName("input \"second argument = 0\" return \"IllegalArgumentException\"")
	@Disabled
	void test0201() {
		try {
			Calculator calc = new Calculator();
			assertEquals("IllegalArgumentException", calc.divide(3, 0));
			fail("not return IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void test01() {
		
	}
	
	@Test
	@Disabled
	void test2() {
		Calculator2 calculator2 = new Calculator2();
		try {
			int result = calculator2.divide(1, 0);
		} catch (Exception e) {
			
		}
		
	}
	
}
