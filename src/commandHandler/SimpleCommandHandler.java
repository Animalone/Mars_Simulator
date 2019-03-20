package commandHandler;


import java.util.LinkedList;
import java.util.List;

import DataStructure.Command;
import explorer.Explorer;

/**
 * SimpleCommandHandler  will process commands from SimpleCommandReader
 */
public class SimpleCommandHandler implements CommandHandler{
	private static final String PLACE = "PLACE";
	private static final String MOVE = "MOVE";
	private static final String REPORT = "REPORT";
	
	private static final int XMAX = 5;
	private static final int XMIN = 0;
	private static final int YMAX = 5;
	private static final int YMIN = 0;
	
	private Explorer explore;
	public SimpleCommandHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public Explorer getExplorer() {
		return explore;
	}

	public void setExplorer(Explorer explore) {
		this.explore = explore;
	}

	/** process method will will call different command method 
	 * based on command types.   
	 * @param commandList : a LinkedList data structure storing command type (as key)
	 * and corresponding explorer's target or original position (as value)
	 * @return a String indicates responses to commands 
	 */
	@Override
	public String process(LinkedList<Command> commandList) {
		String response = "";
		for(int i = 0; i < commandList.size(); i++){
			String key = commandList.get(i).getCommand();
			if (key.equals(PLACE)){
				this.placeXY(commandList.get(i).getValue());
			}else if(key.equals(REPORT)){
				response = response + this.report();
			}else if (key.equals(MOVE)) {
				response = response + this.moveXY(commandList.get(i).getValue());
			}
//			System.out.print(response);
		}
		return response;
		// TODO Auto-generated method stub
		
	}
	
	/** placeXY method handles PLACE command  
	 * @param value : explorer's target or original position
	 *
	 */
	private void placeXY(List<Integer> value) {
		int x = value.get(0);
		int y = value.get(1);
		if (x >= XMIN && x <= XMAX && y >= YMIN && y <= YMAX) {
			this.explore.setPlaced(true);
			this.explore.setX(x);
			this.explore.setY(y);
		}
	}
	
	/** moveXY method handles MOVE command 
	 * @param value : explorer's target or original position
	 * @return proper message indicates explorer's path
	 */
	private String moveXY(List<Integer> value) {
		String response = "";
		if(this.explore.isPlaced()){
//			System.out.print("inside of move");
			int originalX = this.explore.getX();
			int originalY = this.explore.getY();

			this.explore.setX(value.get(0));
			this.explore.setY(value.get(1));
//			System.out.print(value);
			if(originalY != this.explore.getY() || originalX != this.explore.getX()) {
				response += "("+ Integer.toString(originalX)+","+Integer.toString(originalY)+") ";
			}
			
			if(originalY > this.explore.getY()){
				for (int i = 1; i <= originalY - this.explore.getY(); i++) {
					response += "("+ Integer.toString(originalX)+","+Integer.toString(originalY-i)+") ";
				}
			}else if (originalY < this.explore.getY()) {
				for (int i = 1; i <= this.explore.getY() - originalY; i++) {
					response += "("+ Integer.toString(originalX)+","+Integer.toString(originalY+i)+") ";
				}
			}
			if(originalX > this.explore.getX()){
				for (int i = 1; i <= originalX - this.explore.getX(); i++) {
					response += "("+ Integer.toString(originalX-i)+","+Integer.toString(this.explore.getY())+") ";
				}
			}else if (originalX < this.explore.getX()) {
				for (int i = 1; i <= this.explore.getX() - originalX; i++) {
					response += "("+ Integer.toString(originalX+i)+","+Integer.toString(this.explore.getY())+") ";
				}
			}
			
			if(!response.equals("")){
				response = "M: "+response;
			}
		}
//		System.out.print(response);
		if (response.length() > 0){
			return response.substring(0, response.length() - 1)+"\n";
		}else {
			return response;
		}
		
	}
	
	/** report method handles REPORT command  
	 * @return proper message indicates explorer's position
	 */
	private String report() {
		if(this.explore.isPlaced()){
			return "P: ("+Integer.toString(this.explore.getX())+ 
					","+Integer.toString(this.explore.getY())+ ")\n";
		}else {
			return "";
		}
	}
	
}
