package junit.tutorial.ex03.e02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LogAnalyzerTest {
	
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
	
	@Mock
	private LogLoader logLoader;
	
	@InjectMocks
	private LogAnalyzer logAnalyzer;
	
	@Test
	@DisplayName("execute analyze()")
	void test() {
		try {
			Mockito.when(logLoader.load("sample.sample")).thenThrow(new IOException("java.io.IOException"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try {
			logAnalyzer.analyze("sample.sample");
			fail("not return AnalyzeException");
		} catch (AnalyzeException e) {
			Throwable cause = e.getCause();
			assertTrue(cause instanceof IOException);
			assertEquals("java.io.IOException", cause.getMessage());
		}
	}
	
}
