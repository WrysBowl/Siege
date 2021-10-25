package net.siegerpg.siege.core.fishing.fish;

public class Fish {

	public String name;
	public double[] size;
	public int chance;
	public double moveSpeed;
	public int length;
	public double chanceToChangeDirection;
	public double winScore;
	public int customModelData;
	public double actualSize;
	
	/*
	 * chanceToChangeDirection is in percentile,
	 * moveSpeed ex: 0,5 means it moves 0,5 character for every 2 tick(1 every 4 ticks) - 0,2 = moves 0,2 characters every 0,2 ticks (1 every 10 tick)
	 * winScore you get 1 per second in the green and the win score is the max to win
	 * */
	public Fish(final String name, final double[] size, final double winScore, final double moveSpeed, final int length, final int chance,
	            final double chanceToChangeDirection, final int customModelData)
	{
		this.name=name;
		this.chanceToChangeDirection=chanceToChangeDirection;
		this.length=length;
		this.size=size;
		this.moveSpeed=moveSpeed;
		this.winScore=winScore;
		this.chance=chance;
		this.customModelData=customModelData;
		actualSize=FishCore.getRandomSize(this);
	}
}
