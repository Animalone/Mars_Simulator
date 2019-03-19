package explorer;
/**
 * Explorer class represent explorer machine
 */
public class Explorer {
	private int x;
	private int y;
	private boolean placed;
	public Explorer() {
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isPlaced() {
		return placed;
	}

	public void setPlaced(boolean placed) {
		this.placed = placed;
	}

}
