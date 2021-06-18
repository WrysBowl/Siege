package net.siegerpg.siege.core.fishing.baits;


import net.siegerpg.siege.core.fishing.baits.implemented.MoreTunaBait;

import java.util.ArrayList;

public abstract class BaitCore {

	public static ArrayList<BaitCore> baits = new ArrayList<BaitCore>() ;

	private ArrayList<BaitStats> stats = new ArrayList<>();
	private String baitName;
	
	public BaitCore (BaitStats[] stats, String baitName) {
		this.baitName=baitName;
		for(BaitStats stat : stats) {
			this.stats.add(stat);
		}
	}

	public static void registerAllBaits() {
		baits.add(new MoreTunaBait());
	}

	public static BaitCore getBait(String name) {
		for(BaitCore bait : baits) {
			if(bait.getName().equals(name))
				return bait;
		}
		return null;
	}

	public static boolean hasBait(String name) {
		for(BaitCore bait : baits) {
			if(bait.getName().equals(name))
				return true;
		}
		return false;
	}

	public boolean hasFish(String name) {
		for(BaitStats stats : this.stats) {
			if(stats.getFish().getFishName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}




	public ArrayList<BaitStats> getStats() {
		return stats;
	}

	public void setStats(ArrayList<BaitStats> stats) {
		this.stats = stats;
	}

	public BaitStats getStatFromFishName(String fishName) {
		for(BaitStats stat : this.stats) {
			if(stat.getFish().getFishName().equalsIgnoreCase(fishName))
				return stat;

		}
		return null;
	}

	public String getName() {
		return baitName;
	}

	public void setName(String baitName) {
		this.baitName = baitName;
	}
}
