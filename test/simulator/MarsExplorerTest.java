package simulator;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import explorer.MarsExplorer;

class MarsExplorerTest {
	private MarsExplorer classUnderTest;
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new MarsExplorer();
	}
	//test if explorer can ignore moves that may cause the explorer fall 
	//since test x is same as testing y, so only x is tested here
	@Test
	void testfall() {
		classUnderTest.setPlaced(true);
		int fallnumber = 6;
		classUnderTest.setX(fallnumber);
		assertNotEquals(fallnumber, classUnderTest.getX());
		fallnumber = -1;
		classUnderTest.setX(fallnumber);
		assertNotEquals(fallnumber, classUnderTest.getX());
	}
	
	// test if explorer can ignore commands if it is not placed on the tabletop.  
	@Test
	void testSetY() {
		classUnderTest.setPlaced(false);
		int fallnumber = 3;
		assertEquals(null, classUnderTest.getX());
	}

}
