package junit.tutorial.ex03.e03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NetworkResourcesTest {
	
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
	NetworkLoader loader;
	
	@InjectMocks
	NetworkResources networkResources;
	
	@Test
	void test() {
		try {
			InputStream input = getClass().getResourceAsStream("Hello World");
			Mockito.when(loader.getInput()).thenReturn(input);
			networkResources = new NetworkResources();
			String expected = networkResources.load();
			assertEquals("Hello World", expected);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
