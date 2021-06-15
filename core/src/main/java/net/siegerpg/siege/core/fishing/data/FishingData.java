package net.siegerpg.siege.core.fishing.data;

import net.siegerpg.siege.core.fishing.fish.FishCore;

import java.util.HashMap;
import java.util.UUID;

public class FishingData {
	
	public static HashMap<UUID, FishingData> list = new HashMap<>();
	
	private boolean fishing = false;
	private FishCore fish;
	private double processToAdvance=0;
	private int loc=0;
	private Cursor cursor;
	private double score= 0;
	
	//true=forward false=backward
	private boolean direction = true;
	
	
	public FishingData() {
		this.cursor= new Cursor();
	}

	
	
	public boolean isFishing() {
		return fishing;
	}

	public void setFishing(boolean fishing) {
		this.fishing = fishing;
	}



	public FishCore getFish() {
		return fish;
	}



	public void setFish(FishCore fish) {
		this.fish = fish;
	}

	public static HashMap<UUID, FishingData> getList() {
		return list;
	}



	public int getLoc() {
		return loc;
	}



	public void setLoc(int loc) {
		this.loc = loc;
	}



	public double getProcessToAdvance() {
		return processToAdvance;
	}



	public void setProcessToAdvance(double processToAdvance) {
		this.processToAdvance = processToAdvance;
	}
	public boolean getDirection() {
		return direction;
	}



	public void setDirection(boolean direction) {
		this.direction = direction;
	}



	public Cursor getCursor() {
		return cursor;
	}






	public double getScore() {
		return score;
	}



	public void setScore(double score) {
		this.score = score;
	}

}
