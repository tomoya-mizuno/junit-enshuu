package junit.tutorial.ex02.e04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RangeTest {
	
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
	
	@Disabled
	@ParameterizedTest
	@ValueSource(doubles = {-0.1, 0.0, 10.5, 10.6})
	@DisplayName("execute contains(double) with Range=(0.0, 10.5)")
	void test(double input) {
		Range rng = new Range(0.0, 10.5);
		
		if (rng.contains(input)) {
			assertTrue(rng.contains(input));
		} else {
			assertFalse(rng.contains(input));
		}
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(doubles = {-5.2, -5.1, 5.1, 5.2})
	@DisplayName("execute contains(double) with Range=(-5.1, 5.1)")
	void test2(double input) {
		Range rng = new Range(-5.1, 5.1);
		
		if (rng.contains(input)) {
			assertTrue(rng.contains(input));
		} else {
			assertFalse(rng.contains(input));
		}
	}
	
	@ParameterizedTest
	@CsvSource({
			"-0.1, false",
			"0.0, true",
			"10.5, true",
			"10.6, false"
	})
	void test3(double input, boolean expected) {
		Range rng = new Range(0.0, 10.5);
		
		assertEquals(expected, rng.contains(input));
	}
	
	@ParameterizedTest
	@CsvSource({
			"-5.2, false",
			"-5.1, true",
			"5.1, true",
			"5.2, false"
	})
	void test4(double input, boolean expected) {
		Range rng = new Range(-5.1, 5.1);
		
		assertEquals(expected, rng.contains(input));
	}
}
