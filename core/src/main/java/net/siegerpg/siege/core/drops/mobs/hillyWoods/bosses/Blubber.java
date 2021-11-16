package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.CrackedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.SlimeSpoofer;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Blubber extends MobDropTable {
	public Blubber () {
		super("Blubber", 17, 20, 17, 25, new Reward[] {
				new Reward(Slime.Companion.tier(2).getUpdatedItem(false), 100.0),
				new Reward(Slime.Companion.tier(3).getUpdatedItem(false), 10.0),

				new Reward(new SlimeSpoofer(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 5.0),

				new Reward(new SlimyHelmet(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyChestplate(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyLeggings(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyBoots(80).getUpdatedItem(false), 3.0),

				new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 5.0),
				new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 5.0),
				new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 5.0),
				new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 5.0),

				new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new CrackedLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new SlimeSpiritKey(0).getUpdatedItem(false), 10.0),
		});
	}
}
