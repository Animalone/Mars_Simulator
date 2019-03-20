package DataStructure;

import java.util.List;


/**
 * Command DataType
 */
public class Command {
	private String command;
	private List<Integer> value;
	public Command(String command, List<Integer> value) {
		this.command = command;
		this.value = value;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public List<Integer> getValue() {
		return value;
	}
	public void setValue(List<Integer> value) {
		this.value = value;
	}
	
}
