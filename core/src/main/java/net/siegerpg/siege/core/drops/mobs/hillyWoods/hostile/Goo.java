package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Goo extends MobDropTable {
	public Goo () {
		super("Goo", 3, 5, 4, 7, new Reward[] {
				new Reward(Slime.Companion.tier(1).getUpdatedItem(false), 100.0),
				new Reward(Slime.Companion.tier(2).getUpdatedItem(false), 10.0),

				new Reward(new SlimyHelmet(30).getUpdatedItem(false), 2.0),
				new Reward(new SlimyChestplate(30).getUpdatedItem(false), 2.0),
				new Reward(new SlimyLeggings(30).getUpdatedItem(false), 2.0),
				new Reward(new SlimyBoots(30).getUpdatedItem(false), 2.0),

				new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 0.3),
				new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 0.3),
				new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 0.3),
				new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 0.3),

				new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 1.0),
		});
	}
}
