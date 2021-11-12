package junit.tutorial.ex02.e02;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {
	
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
	@DisplayName("execute load(Employee.txt)")
	void test() {
		Employee employeeExpected = new Employee();
		employeeExpected.setFirstName("Ichiro");
		employeeExpected.setLastName("Tanaka");
		employeeExpected.setEmail("ichiro@example.com");
		
		InputStream input = getClass().getResourceAsStream("Employee.txt");
		List<Employee> empList = Employee.load(input);
		assertAll(
				() -> assertEquals(employeeExpected.getFirstName(), empList.get(0).getFirstName()),
				() -> assertEquals(employeeExpected.getLastName(), empList.get(0).getLastName()),
				() -> assertEquals(employeeExpected.getEmail(), empList.get(0).getEmail()));
	}
}
