package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Coal;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.FlawedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.FlawedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.FlawedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.GreatSword;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.greatSwords.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.scrapShards.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernWand;
import net.siegerpg.siege.core.items.implemented.weapons.wands.FlamingHotTorch;
import net.siegerpg.siege.core.items.implemented.weapons.wands.earthernWands.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.flamingHotTorches.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Lich extends MobDropTable {

	public Lich() {

		super("Lich", 3000, 5500, 25000, 30000, new Reward[] {
				new Reward(Seed.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 100.0),
				new Reward(Seed.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(4), 10.0),
				new Reward(Seed.Companion
						           .tier(4)
						           .getUpdatedItem(false)
						           .asQuantity(2), 1.0),

				new Reward(Coal.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 100.0),
				new Reward(Coal.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(4), 10.0),
				new Reward(Coal.Companion
						           .tier(4)
						           .getUpdatedItem(false)
						           .asQuantity(2), 1.0),

				new Reward(Vine.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(8), 100.0),
				new Reward(Vine.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(4), 10.0),
				new Reward(Vine.Companion
						           .tier(4)
						           .getUpdatedItem(false)
						           .asQuantity(2), 1.0),

				new Reward(new GreatSword(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new GreatSword(100).getUpdatedItem(false), 5.0),
				new Reward(new GreatSword(80).getUpdatedItem(false), 30.0),
				new Reward(new LuckyGreatSword(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new ToughGreatSword(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new StrongGreatSword(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealingGreatSword(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealthyGreatSword(Utils.randRarity()).getUpdatedItem(false), 2.0),

				new Reward(new FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new FlamingHotTorch(100).getUpdatedItem(false), 5.0),
				new Reward(new FlamingHotTorch(80).getUpdatedItem(false), 30.0),
				new Reward(new LuckyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new ToughFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new StrongFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealingFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealthyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 2.0),

				new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new EarthernWand(100).getUpdatedItem(false), 5.0),
				new Reward(new EarthernWand(80).getUpdatedItem(false), 30.0),
				new Reward(new LuckyEarthernWand(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new ToughEarthernWand(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new StrongEarthernWand(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealingEarthernWand(Utils.randRarity()).getUpdatedItem(false), 2.0),
				new Reward(new HealthyEarthernWand(Utils.randRarity()).getUpdatedItem(false), 2.0),

				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 2.0),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 2.0),
				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 2.0),
				new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 5.0),

				new Reward(new MobKey(0).getUpdatedItem(false).asQuantity(8), 100.0),

				});
	}

}