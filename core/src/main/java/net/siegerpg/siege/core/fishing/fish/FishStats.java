package net.siegerpg.siege.core.fishing.fish;

public class FishStats {
	
	
	public double[] size;
	public int chance;
	public double moveSpeed;
	public int length;
	public double chanceToChangeDirection;
	public double winScore;
	public int customModelData;
	
	/*
	 * chanceToChangeDirection is in percentile,
	 * moveSpeed ex: 0,5 means it moves 0,5 character for every 2 tick(1 every 4 ticks) - 0,2 = moves 0,2 characters every 0,2 ticks (1 every 10 tick)
	 * winScore you get 1 per second in the green and the winscore is the max to win
	 * */
	public FishStats(double[] size, double winScore, double moveSpeed, int length, int chance, double chanceToChangeDirection, int customModelData)
	{
		this.chanceToChangeDirection=chanceToChangeDirection;
		this.length=length;
		this.size=size;
		this.moveSpeed=moveSpeed;
		this.winScore=winScore;
		this.chance=chance;
		this.customModelData=customModelData;
	}
}
