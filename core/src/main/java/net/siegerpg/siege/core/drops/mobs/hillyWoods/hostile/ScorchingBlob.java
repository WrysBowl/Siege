package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.magmaHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.magmaLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.MagmaSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.wands.MatchStick;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class ScorchingBlob extends MobDropTable {

	public ScorchingBlob() {

		super("ScorchingBlob", 6, 9, 11, 14, new Reward[] {
				new Reward(Magma.Companion
						           .tier(1)
						           .getUpdatedItem(false), 100.0),
				new Reward(Magma.Companion
						           .tier(2)
						           .getUpdatedItem(false), 10.0),

				new Reward(new MagmaHelmet(50).getUpdatedItem(false), 2.0),
				new Reward(new MagmaChestplate(50).getUpdatedItem(false), 2.0),
				new Reward(new MagmaLeggings(50).getUpdatedItem(false), 2.0),
				new Reward(new MagmaBoots(50).getUpdatedItem(false), 2.0),

				new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new ToughMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealingMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealthyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new StrongMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new LuckyMagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyMagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyMagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyMagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),
				
				new Reward(new MatchStick(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 0.75),
				new Reward(new MagmaSpiritKey().getUpdatedItem(false), 1.0),

				});
	}

}
