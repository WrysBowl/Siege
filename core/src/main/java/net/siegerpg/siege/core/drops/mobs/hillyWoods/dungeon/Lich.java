package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
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
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernWand;
import net.siegerpg.siege.core.items.implemented.weapons.wands.FlamingHotTorch;
import net.siegerpg.siege.core.items.implemented.weapons.wands.earthernWands.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.flamingHotTorches.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Lich extends MobDropTable {

	public Lich() {

		super("Lich", 3000, 5500, 8000, 10000, new Reward[] {
				new Reward(new Vine().getUpdatedItem(false), 100.0),
				new Reward(new Vine().getUpdatedItem(false).asQuantity(8), 10.0),

				new Reward(new GreatSword(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new GreatSword(100).getUpdatedItem(false), 1.0),
				new Reward(new GreatSword(80).getUpdatedItem(false), 15.0),
				new Reward(new LuckyGreatSword(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughGreatSword(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongGreatSword(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingGreatSword(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyGreatSword(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new FlamingHotTorch(100).getUpdatedItem(false), 1.0),
				new Reward(new FlamingHotTorch(80).getUpdatedItem(false), 15.0),
				new Reward(new LuckyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyFlamingHotTorch(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 15.0),
				new Reward(new EarthernWand(100).getUpdatedItem(false), 1.0),
				new Reward(new EarthernWand(80).getUpdatedItem(false), 15.0),
				new Reward(new LuckyEarthernWand(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new ToughEarthernWand(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new StrongEarthernWand(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealingEarthernWand(Utils.randRarity()).getUpdatedItem(false), 1.5),
				new Reward(new HealthyEarthernWand(Utils.randRarity()).getUpdatedItem(false), 1.5),

				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 0.20),
				new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 0.20),
				new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 1.0),
				new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 1.0),
				new Reward(new FlawedLuckGem(0).getUpdatedItem(false), 1.0),
				new Reward(new FlawedToughGem(0).getUpdatedItem(false), 1.0),
				new Reward(new FlawedHealthGem(0).getUpdatedItem(false), 1.0),

				new Reward(new LichHood(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new LichCloak(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new LichLeggings(Utils.randRarity()).getUpdatedItem(false), 0.50),
				new Reward(new LichBoots(Utils.randRarity()).getUpdatedItem(false), 0.50),

				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 7.5),
				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 7.5),
				new Reward(new MobKey().getUpdatedItem(false).asQuantity(2), 7.5),

				});
	}

}