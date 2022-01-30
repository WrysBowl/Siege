package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.listeners.DeathListener;

public class MobDropTable extends DropTable {

	String mobName;

	public MobDropTable(String mobName, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {

		this.mobName = mobName;
		this.goldMin = goldMin;
		this.goldMax = goldMax;
		this.expMin = expMin;
		this.expMax = expMax;
		this.rewards = rewards;

		DeathListener.mobDropTableHashMap.put(mobName, this);
	}

	public String getMobName() {

		return mobName;
	}
}