package simulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import commandHandler.SimpleCommandHandler;
import explorer.MarsExplorer;

class SimpleCommandHandlerTest {
	//test if CommandHandler can place the explorer, and if report can return proper message (example a)
	@Test
	void testPlace() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("P: (0,0)\n", classUnderTest.process(dictionary));
	}
	
	//test if CommandHandler can place the explorer, and print the path after move command (example b)
	@Test
	void testMove() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("MOVE", List.of(0, 1));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("M: (0,0) (0,1)\n", classUnderTest.process(dictionary));
	}
	//test if CommandHandler can place the explorer, and print the path after move command (example c)
	@Test
	void testPlaceMoveReport() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("MOVE", List.of(1, 1));
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("M: (0,0) (0,1) (1,1)\nP: (1,1)\n", classUnderTest.process(dictionary));
	}
	//test if MOVE COMMAND will cause the explorer fall
	@Test
	void testFall() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("MOVE", List.of(6, 6));
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("P: (0,0)\n", classUnderTest.process(dictionary));
	}
	
	//test if MOVE COMMAND does not make any move
	@Test
	void testNoMOVE() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("MOVE", List.of(0, 0));
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("P: (0,0)\n", classUnderTest.process(dictionary));
	}
	//test if explorer is not on tabletop when it receive REPORT command
	@Test
	void testNoPlaceReport() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("", classUnderTest.process(dictionary));
	}
	
	//test if explorer is not on tabletop when it receive MOVE command
	@Test
	void testNoPlaceMove() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("MOVE", List.of(0, 0));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("", classUnderTest.process(dictionary));
	}
	
	//test if explorer is not on tabletop when it receive MOVE and REPORT command
	@Test
	void testNoPlaceMoveReport() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("MOVE", List.of(0, 0));
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("", classUnderTest.process(dictionary));
	}
	//test if explorer can make right movement if it received valid MOVE command after non-valid MOVE command
	@Test
	void testValidMoveAfterNonValidMove() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("MOVE", List.of(0, 0));
		dictionary.put("MOVE", List.of(-1, -1));
		dictionary.put("MOVE", List.of(1, 2));
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("M: (0,0) (0,1) (0,2) (1,2)\nP: (1,2)\n", classUnderTest.process(dictionary));
	}
	
	//test if explorer can handle first PLACE command after a few Non PLACE command
	@Test
	void testValidFirstPlaceAfterNonPlace() {
		LinkedHashMap<String, List<Integer>> dictionary = new LinkedHashMap<String, List<Integer>>();
		dictionary.put("MOVE", List.of(0, 0));
		dictionary.put("MOVE", List.of(-1, -1));
		dictionary.put("MOVE", List.of(1, 2));
		dictionary.put("PLACE", List.of(0, 0));
		dictionary.put("MOVE", List.of(1, 2));
		dictionary.put("REPORT", null);
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler(explorer);
		assertEquals("M: (0,0) (0,1) (0,2) (1,2)\nP: (1,2)\n", classUnderTest.process(dictionary));
	}
	

}
