package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.BoneBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.BoneChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.BoneHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.BoneLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.FoxSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.RockSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.WerewolfKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems.SimpleHealthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems.SimpleLuckGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.SimpleRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.utils.Utils;

public class Werewolf extends MobDropTable {
    public Werewolf() {
        super("Werewolf", 75, 79, 80, 84, new Reward[]{
                new Reward(Chain.Companion.tier(2).getUpdatedItem(false).asQuantity(3), 60.0),
                new Reward(Chain.Companion.tier(3).getUpdatedItem(false), 6.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false).asQuantity(3), 30.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 3.0),

                new Reward(new ChainHelmet(100).getUpdatedItem(false), 0.5),
                new Reward(new ChainChestplate(100).getUpdatedItem(false), 0.5),
                new Reward(new ChainLeggings(100).getUpdatedItem(false), 0.5),
                new Reward(new ChainBoots(100).getUpdatedItem(false), 0.5),

                new Reward(new ChainHelmet(80).getUpdatedItem(false), 2.5),
                new Reward(new ChainChestplate(80).getUpdatedItem(false), 2.5),
                new Reward(new ChainLeggings(80).getUpdatedItem(false), 2.5),
                new Reward(new ChainBoots(80).getUpdatedItem(false), 2.5),

                new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 3.0),
                new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 3.0),
                new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 3.0),
                new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 3.0),

                new Reward(new IronAxe(100).getUpdatedItem(false), 0.5),
                new Reward(new IronAxe(Utils.randRarity()).getUpdatedItem(false), 2.5),

                new Reward(new SimpleHealthGem(0).getUpdatedItem(false), 0.25),
                new Reward(new SimpleLuckGem(0).getUpdatedItem(false), 1.0),
                new Reward(new FoxSpiritKey(0).getUpdatedItem(false), 10.0),
        });
    }
}