package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PolishedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.SimpleToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.RecurveBow;
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernWand;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Necromancer extends MobDropTable {

	public Necromancer () {

		super("Necromancer", 15000, 20000, 17500, 20000, new Reward[] {
				new Reward(Leather.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 40.0),
				new Reward(Leather.Companion.tier(3).getUpdatedItem(false).asQuantity(2), 6.0),
				new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 60.0),
				new Reward(Bone.Companion.tier(3).getUpdatedItem(false).asQuantity(2), 6.0),
				new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false).asQuantity(8), 60.0),
				new Reward(MetalScrap.Companion.tier(3).getUpdatedItem(false).asQuantity(2), 6.0),

				new Reward(new ChainHelmet(100).getUpdatedItem(false), 5.5),
				new Reward(new ChainChestplate(100).getUpdatedItem(false), 5.5),
				new Reward(new ChainLeggings(100).getUpdatedItem(false), 5.5),
				new Reward(new ChainBoots(100).getUpdatedItem(false), 5.5),

				new Reward(new ChainHelmet(80).getUpdatedItem(false), 20.5),
				new Reward(new ChainChestplate(80).getUpdatedItem(false), 20.5),
				new Reward(new ChainLeggings(80).getUpdatedItem(false), 20.5),
				new Reward(new ChainBoots(80).getUpdatedItem(false), 20.5),

				new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 30.0),
				new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 30.0),

				new Reward(new IronAxe(100).getUpdatedItem(false), 10.5),
				new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 25.5),

				new Reward(new EarthernWand(100).getUpdatedItem(false), 10.5),
				new Reward(new EarthernWand(Utils.randRarity()).getUpdatedItem(false), 25.5),

				new Reward(new RecurveBow(100).getUpdatedItem(false), 10.5),
				new Reward(new RecurveBow(Utils.randRarity()).getUpdatedItem(false), 25.5),

				new Reward(new SimpleRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new SimpleToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 10.0),
				});
	}

}