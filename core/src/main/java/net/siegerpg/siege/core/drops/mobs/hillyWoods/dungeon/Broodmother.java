package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.IronBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.IronChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.IronHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.IronLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Vine;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PolishedHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.PristineHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PolishedLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.PristineLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PolishedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.PristineRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PolishedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PristineStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PolishedToughGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.PristineToughGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.Clobber;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.EarthernHammer;
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernStaff;
import net.siegerpg.siege.core.items.implemented.weapons.wands.HotRod;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Broodmother extends MobDropTable {

	public Broodmother() {

		super("Broodmother", 28000, 32000, 35000, 40000, new Reward[] {
				new Reward(Vine.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(16), 100.0),
				new Reward(Vine.Companion
						           .tier(3)
						           .getUpdatedItem(false)
						           .asQuantity(8), 50.0),
				new Reward(Vine.Companion
						           .tier(4)
						           .getUpdatedItem(false)
						           .asQuantity(2), 25.0),
				new Reward(Vine.Companion
						           .tier(5)
						           .getUpdatedItem(false), 5.0),

				new Reward(new IronHelmet(100).getUpdatedItem(false), 5.5),
				new Reward(new IronChestplate(100).getUpdatedItem(false), 5.5),
				new Reward(new IronLeggings(100).getUpdatedItem(false), 5.5),
				new Reward(new IronBoots(100).getUpdatedItem(false), 5.5),

				new Reward(new IronHelmet(80).getUpdatedItem(false), 20.5),
				new Reward(new IronChestplate(80).getUpdatedItem(false), 20.5),
				new Reward(new IronLeggings(80).getUpdatedItem(false), 20.5),
				new Reward(new IronBoots(80).getUpdatedItem(false), 20.5),

				new Reward(new IronHelmet(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronChestplate(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronLeggings(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronBoots(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronHelmet(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronChestplate(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronLeggings(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronBoots(Utils.randRarity()).getUpdatedItem(false), 20.5),

				new Reward(new HotRod(50).getUpdatedItem(false), 30.0),
				new Reward(new HotRod(Utils.randRarity()).getUpdatedItem(false), 25.0),

				new Reward(new EarthernStaff(50).getUpdatedItem(false), 30.0),
				new Reward(new EarthernStaff(Utils.randRarity()).getUpdatedItem(false), 25.0),

				new Reward(new Clobber(50).getUpdatedItem(false), 30.0),
				new Reward(new Clobber(Utils.randRarity()).getUpdatedItem(false), 25.0),

				new Reward(new EarthernHammer(50).getUpdatedItem(false), 30.0),
				new Reward(new EarthernHammer(Utils.randRarity()).getUpdatedItem(false), 25.0),

				new Reward(new PristineRegenerationGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PristineStrengthGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PristineLuckGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PristineToughGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PristineHealthGem(0).getUpdatedItem(false), 10.0),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 5.0),
				});
	}

}