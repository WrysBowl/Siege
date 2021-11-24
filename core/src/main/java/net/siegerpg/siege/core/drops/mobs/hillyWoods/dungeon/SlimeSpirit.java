package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.CrackedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.RawHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.CrackedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.RawLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.CrackedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.CrackedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.CrackedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.RawToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.SlimeSpoofer;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class SlimeSpirit extends MobDropTable {

	public SlimeSpirit() {

		super("SlimeSpirit", 1000, 1500, 3000, 4500, new Reward[] {
				new Reward(Slime.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 100.0),
				new Reward(Slime.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(4), 50.0),
				new Reward(Slime.Companion
						           .tier(4)
						           .getUpdatedItem(false)
						           .asQuantity(2), 10.0),

				new Reward(new SlimeSpoofer(100).getUpdatedItem(false), 5.0),
				new Reward(new SlimeSpoofer(80).getUpdatedItem(false), 30.0),
				new Reward(new SlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 5.0),

				new Reward(new SlimyHelmet(100).getUpdatedItem(false), 5.0),
				new Reward(new SlimyChestplate(100).getUpdatedItem(false), 5.0),
				new Reward(new SlimyLeggings(100).getUpdatedItem(false), 5.0),
				new Reward(new SlimyBoots(100).getUpdatedItem(false), 5.0),

				new Reward(new SlimyHelmet(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyChestplate(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyLeggings(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyBoots(80).getUpdatedItem(false), 3.0),

				new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 15.0),

				new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 10.0),
				new Reward(new RawStrengthGem(0).getUpdatedItem(false), 10.0),
				new Reward(new RawLuckGem(0).getUpdatedItem(false), 10.0),
				new Reward(new RawToughGem(0).getUpdatedItem(false), 10.0),
				new Reward(new RawHealthGem(0).getUpdatedItem(false), 10.0),
				new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new CrackedLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new CrackedToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new CrackedHealthGem(0).getUpdatedItem(false), 5.0),
				});
	}

}