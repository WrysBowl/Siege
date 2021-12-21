package net.siegerpg.siege.core.drops.mobs.hillyWoods.dungeon;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.IronBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.ironBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.IronChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ironChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.IronHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ironHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.IronLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ironleggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.earthernHammers.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.EarthernStaff;
import net.siegerpg.siege.core.items.implemented.weapons.wands.HotRod;
import net.siegerpg.siege.core.items.implemented.weapons.wands.earthernStaffs.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.hotRods.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Broodmother extends MobDropTable {

	public Broodmother() {

		super("Broodmother", 45000, 50000, 250000, 300000, new Reward[] {
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

				new Reward(new ToughIronHelmet(80).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronChestplate(80).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronLeggings(80).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronBoots(80).getUpdatedItem(false), 0.2),

				new Reward(new HealingIronHelmet(80).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronChestplate(80).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronLeggings(80).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronBoots(80).getUpdatedItem(false), 0.2),

				new Reward(new HealthyIronHelmet(80).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronChestplate(80).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronLeggings(80).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronBoots(80).getUpdatedItem(false), 0.2),

				new Reward(new StrongIronHelmet(80).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronChestplate(80).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronLeggings(80).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronBoots(80).getUpdatedItem(false), 0.2),

				new Reward(new LuckyIronHelmet(80).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronChestplate(80).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronLeggings(80).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronBoots(80).getUpdatedItem(false), 0.2),

				new Reward(new IronHelmet(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronChestplate(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronLeggings(Utils.randRarity()).getUpdatedItem(false), 20.5),
				new Reward(new IronBoots(Utils.randRarity()).getUpdatedItem(false), 20.5),

				new Reward(new ToughIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new ToughIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealingIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HealthyIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new StrongIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new LuckyIronHelmet(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronChestplate(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronLeggings(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new LuckyIronBoots(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new HotRod(50).getUpdatedItem(false), 30.0),
				new Reward(new LuckyHotRod(50).getUpdatedItem(false), 2.0),
				new Reward(new ToughHotRod(50).getUpdatedItem(false), 2.0),
				new Reward(new StrongHotRod(50).getUpdatedItem(false), 2.0),
				new Reward(new HealingHotRod(50).getUpdatedItem(false), 2.0),
				new Reward(new HealthyHotRod(50).getUpdatedItem(false), 2.0),
				new Reward(new HotRod(Utils.randRarity()).getUpdatedItem(false), 25.0),
				new Reward(new LuckyHotRod(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughHotRod(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new StrongHotRod(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealingHotRod(Utils.randRarity()).getUpdatedItem(false), 0.2),
				new Reward(new HealthyHotRod(Utils.randRarity()).getUpdatedItem(false), 0.2),

				new Reward(new EarthernStaff(50).getUpdatedItem(false), 30.0),
				new Reward(new LuckyEarthernStaff(50).getUpdatedItem(false), 2.0),
				new Reward(new ToughEarthernStaff(50).getUpdatedItem(false), 2.0),
				new Reward(new StrongEarthernStaff(50).getUpdatedItem(false), 2.0),
				new Reward(new HealingEarthernStaff(50).getUpdatedItem(false), 2.0),
				new Reward(new HealthyEarthernStaff(50).getUpdatedItem(false), 2.0),
				new Reward(new EarthernStaff(Utils.randRarity()).getUpdatedItem(false), 25.0),
				new Reward(new LuckyEarthernStaff(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughEarthernStaff(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongEarthernStaff(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingEarthernStaff(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyEarthernStaff(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new Clobber(50).getUpdatedItem(false), 30.0),
				new Reward(new LuckyClobber(50).getUpdatedItem(false), 2.0),
				new Reward(new ToughClobber(50).getUpdatedItem(false), 2.0),
				new Reward(new StrongClobber(50).getUpdatedItem(false), 2.0),
				new Reward(new HealingClobber(50).getUpdatedItem(false), 2.0),
				new Reward(new HealthyClobber(50).getUpdatedItem(false), 2.0),
				new Reward(new Clobber(Utils.randRarity()).getUpdatedItem(false), 25.0),
				new Reward(new LuckyClobber(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughClobber(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongClobber(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingClobber(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyClobber(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new EarthernHammer(50).getUpdatedItem(false), 30.0),
				new Reward(new LuckyEarthernHammer(50).getUpdatedItem(false), 2.0),
				new Reward(new ToughEarthernHammer(50).getUpdatedItem(false), 2.0),
				new Reward(new StrongEarthernHammer(50).getUpdatedItem(false), 2.0),
				new Reward(new HealingEarthernHammer(50).getUpdatedItem(false), 2.0),
				new Reward(new HealthyEarthernHammer(50).getUpdatedItem(false), 2.0),
				new Reward(new EarthernHammer(Utils.randRarity()).getUpdatedItem(false), 25.0),
				new Reward(new LuckyEarthernHammer(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new ToughEarthernHammer(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new StrongEarthernHammer(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealingEarthernHammer(Utils.randRarity()).getUpdatedItem(false), 1.0),
				new Reward(new HealthyEarthernHammer(Utils.randRarity()).getUpdatedItem(false), 1.0),

				new Reward(new PristineRegenerationGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PristineStrengthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PristineLuckGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PristineToughGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PristineHealthGem(0).getUpdatedItem(false), 5.0),
				new Reward(new PolishedRegenerationGem(0).getUpdatedItem(false), 2.0),
				new Reward(new PolishedStrengthGem(0).getUpdatedItem(false), 2.0),
				new Reward(new PolishedLuckGem(0).getUpdatedItem(false), 2.0),
				new Reward(new PolishedToughGem(0).getUpdatedItem(false), 2.0),
				new Reward(new PolishedHealthGem(0).getUpdatedItem(false), 2.0),

				new Reward(new MobKey(0).getUpdatedItem(false).asQuantity(16), 100.0),

				});
	}

}