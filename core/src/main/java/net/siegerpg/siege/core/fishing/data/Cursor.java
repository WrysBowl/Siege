package net.siegerpg.siege.core.fishing.data;

public class Cursor {
	
	public int getLoc() {
		return this.loc;
	}
	public void setLoc(final int loc) {
		this.loc = loc;
	}
	public boolean isInGreen() {
		return this.inGreen;
	}
	public void setInGreen(final boolean inGreen) {
		this.inGreen = inGreen;
	}
	public int loc = 35;
	public boolean inGreen;

}
