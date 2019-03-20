package app;

import java.util.Scanner;

import commandHandler.SimpleCommandHandler;
import commandReader.SimpleCommandReader;
import explorer.MarsExplorer;
/**
 * Main class for Mars Explore Simulator project
 */
public class SimulatorApplication {

	public static void main(String[] args) {
		MarsExplorer explorer = new MarsExplorer();
		SimpleCommandHandler handler = new SimpleCommandHandler();
		handler.setExplorer(explorer);
		Scanner input = new Scanner(System.in);
		SimpleCommandReader reader = new SimpleCommandReader(handler, explorer, input);
		reader.run();
	}

}
