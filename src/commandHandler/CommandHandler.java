package commandHandler;



import java.util.LinkedList;
import java.util.List;

import DataStructure.Command;

/**
 * CommandHandler interface will process received commands
 */
public interface CommandHandler {
	public String process(LinkedList<Command> dictionary);
}
