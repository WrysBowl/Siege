package net.siegerpg.siege.core.fishing.data;

import net.siegerpg.siege.core.fishing.baits.BaitCore;
import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.fishing.fish.FishCore;

import java.util.HashMap;
import java.util.UUID;

public class FishingData {
	
	public static HashMap<UUID, FishingData> list = new HashMap<>();
	
	private boolean fishing;
	private Fish fish;
	private double processToAdvance;
	private int loc=35;
	private final Cursor cursor;
	private BaitCore bait;
	private double score;
	
	//true=forward false=backward
	private boolean direction = true;
	
	
	public FishingData() {
		cursor= new Cursor();
	}

	
	
	public boolean isFishing() {
		return this.fishing;
	}

	public void setFishing(final boolean fishing) {
		this.fishing = fishing;
	}



	public Fish getFish() {
		return this.fish;
	}



	public void setFish(final Fish fish) {
		this.fish = fish;
	}

	public static HashMap<UUID, FishingData> getList() {
		return FishingData.list;
	}



	public int getLoc() {
		return this.loc;
	}



	public void setLoc(final int loc) {
		this.loc = loc;
	}



	public double getProcessToAdvance() {
		return this.processToAdvance;
	}



	public void setProcessToAdvance(final double processToAdvance) {
		this.processToAdvance = processToAdvance;
	}
	public boolean getDirection() {
		return this.direction;
	}



	public void setDirection(final boolean direction) {
		this.direction = direction;
	}



	public Cursor getCursor() {
		return this.cursor;
	}


	public BaitCore getBait() {
		return this.bait;
	}

	public void setBait(final BaitCore bait) {
		this.bait = bait;
	}

	public double getScore() {
		return this.score;
	}



	public void setScore(final double score) {
		this.score = score;
	}

}
