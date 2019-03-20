package simulator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;


import org.junit.jupiter.api.Test;

import DataStructure.Command;
import commandHandler.SimpleCommandHandler;
import explorer.MarsExplorer;

class SimpleCommandHandlerTest {
	//test if CommandHandler can place the explorer, and if report can return proper message (example a)
	@Test
	void testPlace() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("PLACE", List.of(0, 0)));
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("P: (0,0)\n", classUnderTest.process(commandList));
	}
	
	//test if CommandHandler can place the explorer, and print the path after move command (example b)
	@Test
	void testMove() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("PLACE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(0, 1)));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("M: (0,0) (0,1)\n", classUnderTest.process(commandList));
	}
	//test if CommandHandler can place the explorer, and print the path after move command (example c)
	@Test
	void testPlaceMoveReport() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("PLACE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(1, 1)));
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("M: (0,0) (0,1) (1,1)\nP: (1,1)\n", classUnderTest.process(commandList));
	}
	//test if MOVE COMMAND will cause the explorer fall
	@Test
	void testFall() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("PLACE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(6, 6)));
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("P: (0,0)\n", classUnderTest.process(commandList));
	}
	
	//test if MOVE COMMAND does not make any move
	@Test
	void testNoMOVE() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("PLACE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(0, 0)));
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("P: (0,0)\n", classUnderTest.process(commandList));
	}
	//test if explorer is not on tabletop when it receive REPORT command
	@Test
	void testNoPlaceReport() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("", classUnderTest.process(commandList));
	}
	
	//test if explorer is not on tabletop when it receive MOVE command
	@Test
	void testNoPlaceMove() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("MOVE", List.of(0, 0)));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("", classUnderTest.process(commandList));
	}
	
	//test if explorer is not on tabletop when it receive MOVE and REPORT command
	@Test
	void testNoPlaceMoveReport() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("MOVE", List.of(0, 0)));
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("", classUnderTest.process(commandList));
	}
	//test if explorer can make right movement if it received valid MOVE command after non-valid MOVE command
	@Test
	void testValidMoveAfterNonValidMove() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("PLACE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(-1, -1)));
		commandList.add(new Command("MOVE", List.of(1, 2)));
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("M: (0,0) (0,1) (0,2) (1,2)\nP: (1,2)\n", classUnderTest.process(commandList));
	}
	
	//test if explorer can handle first PLACE command after a few Non PLACE command
	@Test
	void testValidFirstPlaceAfterNonPlace() {
		LinkedList<Command> commandList = new LinkedList<Command>();
		commandList.add(new Command("MOVE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(-1, -1)));
		commandList.add(new Command("MOVE", List.of(1, 2)));
		commandList.add(new Command("PLACE", List.of(0, 0)));
		commandList.add(new Command("MOVE", List.of(1, 2)));
		commandList.add(new Command("REPORT", null));
		MarsExplorer explorer = new MarsExplorer();
//		System.out.print("test10");
		SimpleCommandHandler classUnderTest = new SimpleCommandHandler();
		classUnderTest.setExplorer(explorer);
		assertEquals("M: (0,0) (0,1) (0,2) (1,2)\nP: (1,2)\n", classUnderTest.process(commandList));
	}
	

}
