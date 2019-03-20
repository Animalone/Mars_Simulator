package commandHandler;


import java.util.LinkedHashMap;
import java.util.List;

/**
 * CommandHandler interface will process received commands
 */
public interface CommandHandler {
	public String process(LinkedHashMap<String, List<Integer>> dictionary);
}
