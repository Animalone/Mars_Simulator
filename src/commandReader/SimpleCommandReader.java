package commandReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import DataStructure.Command;
import commandHandler.CommandHandler;
import explorer.Explorer;

/**
 * CommandReader interface will receive user's commands and pass commands to
 * commandHandler in a dictionary format
 */
public class SimpleCommandReader implements CommandReader{
	private CommandHandler handler;
	private Explorer explorer;
	public Scanner input;
	public SimpleCommandReader(CommandHandler handler, Explorer explorer, Scanner input) {
		this.handler = handler;
		this.explorer = explorer;
		this.input = input;
	}
	@Override
	public void run() {
		System.out.print("************************************************\n");
		System.out.print("Welcome to Mars Explorer Simulator System\n");
		System.out.print("You can send command in following protocols\n");
		System.out.print("\n");
		System.out.print("PLACE x,y\nMOVE x,y\nREPORT\n");
		System.out.print("\n");
		System.out.print("Please press enter key twice once you plan to send your command\n");
		System.out.print("The system will keep listening your Command if you only press enter key once\n");
		System.out.print("************************************************\n");
		System.out.print("\n");
//		String str;
		LinkedList<Command> commandList = new LinkedList<Command>();
		while(input.hasNextLine()) {
//		while((str = input.nextLine()) != null) {
			String str = input.nextLine();
			String[] commandInput = str.split(" ");
			int x;
			int y;
			String result;
			if (commandInput[0].equals("REPORT")) {
				commandList.add(new Command("REPORT", null));
			}else if (commandInput[0].equals("")) {
				System.out.print(this.handler.process(commandList)+"\n"); 
				commandList = new LinkedList<Command>();
			}else if (commandInput[0].equals("MOVE") || commandInput[0].equals("PLACE")){
				String[] value =  commandInput[1].split(",");
				commandList.add(new Command(commandInput[0], 
						List.of(Integer.parseInt(value[0]), Integer.parseInt(value[1]))));
			}
		}
		// TODO Auto-generated method stub
		
		
	}


}
