package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

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
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;
import net.siegerpg.siege.core.items.implemented.weapons.wands.SlimeSpoofer;
import net.siegerpg.siege.core.items.implemented.weapons.wands.slimeSpoofers.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Blubber extends MobDropTable {

	public Blubber() {

		super("Blubber", 17, 20, 17, 25, new Reward[] {
				new Reward(new Slime().getUpdatedItem(false), 100.0),
				new Reward(new Slime().getUpdatedItem(false).asQuantity(4), 10.0),

				new Reward(new SlimeSpoofer(80).getUpdatedItem(false), 0.10),
				new Reward(new LuckySlimeSpoofer(80).getUpdatedItem(false), 0.05),
				new Reward(new ToughSlimeSpoofer(80).getUpdatedItem(false), 0.05),
				new Reward(new StrongSlimeSpoofer(80).getUpdatedItem(false), 0.05),
				new Reward(new HealingSlimySpoofer(80).getUpdatedItem(false), 0.05),
				new Reward(new HealthySlimeSpoofer(80).getUpdatedItem(false), 0.05),

				new Reward(new SlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 0.20),
				new Reward(new LuckySlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new ToughSlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new StrongSlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealingSlimySpoofer(Utils.randRarity()).getUpdatedItem(false), 0.05),
				new Reward(new HealthySlimeSpoofer(Utils.randRarity()).getUpdatedItem(false), 0.52),

				new Reward(new SlimyHelmet(80).getUpdatedItem(false), 0.50),
				new Reward(new SlimyChestplate(80).getUpdatedItem(false), 0.50),
				new Reward(new SlimyLeggings(80).getUpdatedItem(false), 0.50),
				new Reward(new SlimyBoots(80).getUpdatedItem(false), 0.50),

				new Reward(new ToughSlimyHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughSlimyChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughSlimyLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new ToughSlimyBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new HealingSlimyHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingSlimyChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingSlimyLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new HealingSlimyBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new HealthySlimyHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthySlimyChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthySlimyLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new HealthySlimyBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new StrongSlimyHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongSlimyChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongSlimyLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new StrongSlimyBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new LuckySlimyHelmet(50).getUpdatedItem(false), 0.025),
				new Reward(new LuckySlimyChestplate(50).getUpdatedItem(false), 0.025),
				new Reward(new LuckySlimyLeggings(50).getUpdatedItem(false), 0.025),
				new Reward(new LuckySlimyBoots(50).getUpdatedItem(false), 0.025),

				new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new ToughSlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new ToughSlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new ToughSlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new ToughSlimyBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new HealingSlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealingSlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealingSlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealingSlimyBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new HealthySlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealthySlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealthySlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new HealthySlimyBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new StrongSlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new StrongSlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new StrongSlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new StrongSlimyBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new LuckySlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new LuckySlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new LuckySlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 0.025),
				new Reward(new LuckySlimyBoots(Utils.randRarity()).getUpdatedItem(false), 0.025),

				new Reward(new SlimeSpiritKey().getUpdatedItem(false), 5.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 2.5),

				});
	}

}
