package net.siegerpg.siege.core.drops;

import io.lumine.xikage.mythicmobs.drops.Drop;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class MobDropTable extends DropTable {

	String mobName;

	public MobDropTable(String mobName, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {

		this.mobName = mobName;
		this.goldMin = goldMin;
		this.goldMax = goldMax;
		this.expMin = expMin;
		this.expMax = expMax;
		this.rewards = rewards;
	}

	public String getMobName() {

		return mobName;
	}
}