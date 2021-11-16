package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.SlimyBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.SlimyChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.SlimyHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.SlimyLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Slime;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.RawLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.StickyStick;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.stickySticks.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Blob extends MobDropTable {

	public Blob () {

		super("Blob", 7, 10, 7, 10, new Reward[] {
				new Reward(Slime.Companion.tier(1).getUpdatedItem(false), 100.0),
				new Reward(Slime.Companion.tier(2).getUpdatedItem(false), 10.0),

				new Reward(new StickyStick(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new LuckyStickyStick(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongStickyStick(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyStickyStick(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingStickyStick(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughStickyStick(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new StickyStick(50).getUpdatedItem(false), 2.0),
				new Reward(new LuckyStickyStick(50).getUpdatedItem(false), 1.0),
				new Reward(new StrongStickyStick(50).getUpdatedItem(false), 1.0),
				new Reward(new HealthyStickyStick(50).getUpdatedItem(false), 1.0),
				new Reward(new HealingStickyStick(50).getUpdatedItem(false), 1.0),
				new Reward(new ToughStickyStick(50).getUpdatedItem(false), 1.0),

				new Reward(new SlimyHelmet(50).getUpdatedItem(false), 3.0),
				new Reward(new SlimyChestplate(50).getUpdatedItem(false), 3.0),
				new Reward(new SlimyLeggings(50).getUpdatedItem(false), 3.0),
				new Reward(new SlimyBoots(50).getUpdatedItem(false), 3.0),

				new Reward(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false), 2.0),

				new Reward(new RawRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new RawLuckGem(0).getUpdatedItem(false), 1.0),
				});
	}

}
