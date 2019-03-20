package explorer;
/**
 * Explorer class represent explorer machine used in mars
 */
public class MarsExplorer extends Explorer{
	private static final int XMAX = 5;
	private static final int XMIN = 0;
	private static final int YMAX = 5;
	private static final int YMIN = 0;
	public MarsExplorer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/** Explorer will move to horizontal position 
	 * if explorer placed on the toptable and will not fall
	 * after the move 
	 * @param x : the target's horizontal position
	 * 
	 */
	@Override
	public void setX(int x) {
		if(x<= XMAX && x>=XMIN && placed && this.x != x) {
			this.x = x;
		}
	}
	/** Explorer will move to vertical position 
	 * if explorer placed on the toptable and will not fall
	 * after the move 
	 * @param y : the target's vertical position
	 * 
	 */
	@Override
	public void setY(int y) {
		if(y<= YMAX && y>=YMIN && placed && this.y != y) {
			this.y = y;
		}
	}
}
