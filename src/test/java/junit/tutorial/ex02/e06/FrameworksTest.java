package junit.tutorial.ex02.e06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class FrameworksTest {
	
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
	
	@ParameterizedTest
	@CsvFileSource(resources = "FrameworksTest.csv")
	void test(String app, String db, String support) {
		ApplicationServer applicationServer = ApplicationServer.valueOf(app);
		Database database = Database.valueOf(db);
		
		if (support == "〇") assertTrue(Frameworks.isSupport(applicationServer, database));
		if (support == "×") assertFalse(Frameworks.isSupport(applicationServer, database));
	}
}
