package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.chainBoots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.chainChestplates.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.chainHelmets.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.chainLeggings.*;
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.FoxSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.IronAxe;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.doubleBladedAxes.*;
import net.siegerpg.siege.core.miscellaneous.Utils;

public class Werewolf extends MobDropTable {

	public Werewolf() {

		super("Werewolf", 75, 79, 80, 84, new Reward[] {
				new Reward(Chain.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 60.0),
				new Reward(Chain.Companion
						           .tier(3)
						           .getUpdatedItem(false), 6.0),
				new Reward(Bone.Companion
						           .tier(2)
						           .getUpdatedItem(false)
						           .asQuantity(3), 30.0),
				new Reward(Bone.Companion
						           .tier(3)
						           .getUpdatedItem(false), 3.0),

				new Reward(new ChainHelmet(100).getUpdatedItem(false), 0.5),
				new Reward(new ChainChestplate(100).getUpdatedItem(false), 0.5),
				new Reward(new ChainLeggings(100).getUpdatedItem(false), 0.5),
				new Reward(new ChainBoots(100).getUpdatedItem(false), 0.5),

				new Reward(new ChainHelmet(80).getUpdatedItem(false), 2.5),
				new Reward(new ChainChestplate(80).getUpdatedItem(false), 2.5),
				new Reward(new ChainLeggings(80).getUpdatedItem(false), 2.5),
				new Reward(new ChainBoots(80).getUpdatedItem(false), 2.5),

				new Reward(new ToughChainHelmet(50).getUpdatedItem(false), 0.1),
				new Reward(new ToughChainChestplate(50).getUpdatedItem(false), 0.1),
				new Reward(new ToughChainLeggings(50).getUpdatedItem(false), 0.1),
				new Reward(new ToughChainBoots(50).getUpdatedItem(false), 0.1),

				new Reward(new HealingChainHelmet(50).getUpdatedItem(false), 0.1),
				new Reward(new HealingChainChestplate(50).getUpdatedItem(false), 0.1),
				new Reward(new HealingChainLeggings(50).getUpdatedItem(false), 0.1),
				new Reward(new HealingChainBoots(50).getUpdatedItem(false), 0.1),

				new Reward(new HealthyChainHelmet(50).getUpdatedItem(false), 0.1),
				new Reward(new HealthyChainChestplate(50).getUpdatedItem(false), 0.1),
				new Reward(new HealthyChainLeggings(50).getUpdatedItem(false), 0.1),
				new Reward(new HealthyChainBoots(50).getUpdatedItem(false), 0.1),

				new Reward(new StrongChainHelmet(50).getUpdatedItem(false), 0.1),
				new Reward(new StrongChainChestplate(50).getUpdatedItem(false), 0.1),
				new Reward(new StrongChainLeggings(50).getUpdatedItem(false), 0.1),
				new Reward(new StrongChainBoots(50).getUpdatedItem(false), 0.1),

				new Reward(new LuckyChainHelmet(50).getUpdatedItem(false), 0.1),
				new Reward(new LuckyChainChestplate(50).getUpdatedItem(false), 0.1),
				new Reward(new LuckyChainLeggings(50).getUpdatedItem(false), 0.1),
				new Reward(new LuckyChainBoots(50).getUpdatedItem(false), 0.1),
				
				new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 3.0),
				new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 3.0),

				new Reward(new ToughChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new ToughChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new ToughChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new ToughChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.1),

				new Reward(new HealingChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealingChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealingChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealingChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.1),

				new Reward(new HealthyChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealthyChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealthyChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealthyChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.1),

				new Reward(new StrongChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new StrongChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new StrongChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new StrongChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.1),

				new Reward(new LuckyChainHelmet(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new LuckyChainChestplate(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new LuckyChainLeggings(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new LuckyChainBoots(Utils.randRarity()).getUpdatedItem(false), 0.1),

				new Reward(new IronAxe(100).getUpdatedItem(false), 0.5),
				new Reward(new LuckyIronAxe(50).getUpdatedItem(false), 0.1),
				new Reward(new ToughIronAxe(50).getUpdatedItem(false), 0.1),
				new Reward(new StrongIronAxe(50).getUpdatedItem(false), 0.1),
				new Reward(new HealingIronAxe(50).getUpdatedItem(false), 0.1),
				new Reward(new HealthyIronAxe(50).getUpdatedItem(false), 0.1),
				new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 2.5),
				new Reward(new LuckyIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new ToughIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new StrongIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealingIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				new Reward(new HealthyIronAxe(Utils.randRarity()).getUpdatedItem(false), 0.1),
				

				new Reward(new FoxSpiritKey(0).getUpdatedItem(false), 10.0),
				new Reward(new MobKey(0).getUpdatedItem(false), 1.0),

				});
	}

}