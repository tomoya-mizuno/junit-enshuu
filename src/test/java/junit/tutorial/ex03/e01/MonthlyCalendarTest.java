package junit.tutorial.ex03.e01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MonthlyCalendarTest {
	
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
	
	@DisplayName("execute getRemainingDays()")
	@ParameterizedTest
	@CsvSource({
			"2012/1/31, 0",
			"2012/1/30, 1",
			"2012/2/1, 28"
	})
	void test(String inputDate, int remainingDays) {
		MonthlyCalendar monthlyCalendar = new MonthlyCalendar(LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy/M/d")));
		
		assertEquals(remainingDays, monthlyCalendar.getRemainingDays());
	}
	
}
