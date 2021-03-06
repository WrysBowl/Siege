package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.slimyBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.slimyChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.slimyHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.slimyLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
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
import net.siegerpg.siege.core.items.implemented.weapons.wands.slimeSpoofers.*;
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
				new Reward(new LuckySlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new ToughSlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new StrongSlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealingSlimySpoofer(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealthySlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 2.0),

				new Reward(new SlimyHelmet(100).getUpdatedItem(false), 5.0),
				new Reward(new SlimyChestplate(100).getUpdatedItem(false), 5.0),
				new Reward(new SlimyLeggings(100).getUpdatedItem(false), 5.0),
				new Reward(new SlimyBoots(100).getUpdatedItem(false), 5.0),

				new Reward(new SlimyHelmet(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyChestplate(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyLeggings(80).getUpdatedItem(false), 3.0),
				new Reward(new SlimyBoots(80).getUpdatedItem(false), 3.0),

				new Reward(new ToughSlimyHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new ToughSlimyChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new ToughSlimyLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new ToughSlimyBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new HealingSlimyHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new HealingSlimyChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new HealingSlimyLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new HealingSlimyBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new HealthySlimyHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new HealthySlimyChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new HealthySlimyLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new HealthySlimyBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new StrongSlimyHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new StrongSlimyChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new StrongSlimyLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new StrongSlimyBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new LuckySlimyHelmet(50).getUpdatedItem(false), 1.0),
				new Reward(new LuckySlimyChestplate(50).getUpdatedItem(false), 1.0),
				new Reward(new LuckySlimyLeggings(50).getUpdatedItem(false), 1.0),
				new Reward(new LuckySlimyBoots(50).getUpdatedItem(false), 1.0),

				new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 15.0),

				new Reward(new ToughSlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughSlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughSlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughSlimyBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new HealingSlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingSlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingSlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingSlimyBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new HealthySlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthySlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthySlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthySlimyBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new StrongSlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongSlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongSlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongSlimyBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new LuckySlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LuckySlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LuckySlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new LuckySlimyBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new RawStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new RawLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new RawToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new RawHealthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new CrackedRegenerationGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedLuckGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedToughGem(0).getUpdatedItem(false), 2.0),
				new Reward(new CrackedHealthGem(0).getUpdatedItem(false), 2.0),

				new Reward(new MobKey(0).getUpdatedItem(false).asQuantity(2), 100.0),

				});
	}

}