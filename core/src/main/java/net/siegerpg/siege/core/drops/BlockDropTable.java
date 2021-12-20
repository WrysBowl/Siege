package net.siegerpg.siege.core.drops;

import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class BlockDropTable extends DropTable {

	int blockRegen;
	Material material;

	public BlockDropTable(int blockRegen, Material material, int goldMin, int goldMax, int expMin, int expMax, Reward[] rewards) {

		this.blockRegen = blockRegen;
		this.material = material;
		this.goldMin = goldMin;
		this.goldMax = goldMax;
		this.expMin = expMin;
		this.expMax = expMax;
		this.rewards = rewards;
	}

	public Integer getBlockRegen() {

		return blockRegen;
	}

	public Material getMaterial() {

		return material;
	}

}
