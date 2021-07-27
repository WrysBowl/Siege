package net.siegerpg.siege.core.fishing.data;

public class Cursor {
	
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public boolean isInGreen() {
		return inGreen;
	}
	public void setInGreen(boolean inGreen) {
		this.inGreen = inGreen;
	}
	public int loc = 35;
	public boolean inGreen;

}
