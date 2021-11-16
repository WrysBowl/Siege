package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.MagmaSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.MatchStick;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Molter extends MobDropTable {

	public Molter() {

		super("Molter", 26, 29, 31, 34, new Reward[] {
				new Reward(Magma.Companion
						           .tier(2)
						           .getUpdatedItem(false), 100.0),
				new Reward(Magma.Companion
						           .tier(3)
						           .getUpdatedItem(false), 10.0),

				new Reward(new MagmaHelmet(80).getUpdatedItem(false), 2.5),
				new Reward(new MagmaChestplate(80).getUpdatedItem(false), 2.5),
				new Reward(new MagmaLeggings(80).getUpdatedItem(false), 2.5),
				new Reward(new MagmaBoots(80).getUpdatedItem(false), 2.5),

				new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new MatchStick(Utils.randRarity()).getUpdatedItem(false), 5.0),

				new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 2.0),
				new Reward(new MagmaSpiritKey(0).getUpdatedItem(false), 10.0),
				});
	}

}
