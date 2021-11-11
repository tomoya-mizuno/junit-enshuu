package junit.tutorial.ex01.e05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemStockTest {
	ItemStock itemStock;
	Item item;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
		Item item = new Item("sample", 0);
		ItemStock itemStock = new ItemStock();
		itemStock.add(item);
		
		this.itemStock = itemStock;
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@DisplayName("execute getNum() method in initialized")
	@Disabled
	void test0501() {
		ItemStock itemStock = new ItemStock();
		Item item = new Item("sample", 0);
		
		assertEquals(0, itemStock.getNum(item));
	}
	
	@Test
	@DisplayName("execute getNum() method after execute add() method")
	@Disabled
	void test0502() {
		ItemStock itemStock = new ItemStock();
		Item item = new Item("sample", 0);
		
		itemStock.add(item);
		
		assertEquals(1, itemStock.getNum(item));
	}
	
	@Test
	@DisplayName("execute getNum() method in one item added")
	@Disabled
	void test0503() {
		Item item = new Item("sample", 0);
		
		assertEquals(1, itemStock.getNum(item));
	}
	
	@Test
	@DisplayName("execute getNum() after execute add(same item)")
	@Disabled
	void test0504() {
		Item item = new Item("sample", 0);
		itemStock.add(item);
		
		assertEquals(2, itemStock.getNum(item));
	}
	
	@Test
	@DisplayName("execute getNum() after execute add(difference item)")
	@Disabled
	void test0505() {
		Item item = new Item("sample2", 0);
		itemStock.add(item);
		
		assertEquals(1, itemStock.getNum(item));
	}
}
