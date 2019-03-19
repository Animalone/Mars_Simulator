package simulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import commandHandler.SimpleCommandHandler;

class SimpleCommandHandlerTest {
	//test if CommandHandler can place the explorer, and if report can return proper message
	@Test
	void testPlaceXY() {
		HashMap<String, List<Integer>> dictionary = new HashMap<String, List<Integer>>();
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("REPORT", null);
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(dictionary);
		classUnderTest.process();
		assertEquals("P:(0,0)", classUnderTest.process());
	}

}
