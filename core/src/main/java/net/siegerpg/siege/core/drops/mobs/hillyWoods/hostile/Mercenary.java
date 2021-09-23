package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.LeatherBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.LeatherChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.LeatherHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.LeatherLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Dagger;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.RefinedDagger;
import net.siegerpg.siege.core.utils.Utils;

public class Mercenary extends MobDropTable {
    public Mercenary() {
        super("Mercenary", 55, 58, 75, 78, new Reward[]{
                new Reward(Leather.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Leather.Companion.tier(3).getUpdatedItem(false), 5.0),
                new Reward(Bone.Companion.tier(2).getUpdatedItem(false), 50.0),
                new Reward(Bone.Companion.tier(3).getUpdatedItem(false), 5.0),
                new Reward(MetalScrap.Companion.tier(2).getUpdatedItem(false), 25.0),

                new Reward(new ChainHelmet(100).getUpdatedItem(false), 0.5),
                new Reward(new ChainChestplate(100).getUpdatedItem(false), 0.5),
                new Reward(new ChainLeggings(100).getUpdatedItem(false), 0.5),
                new Reward(new ChainBoots(100).getUpdatedItem(false), 0.5),

                new Reward(new ChainHelmet(80).getUpdatedItem(false), 2.5),
                new Reward(new ChainChestplate(80).getUpdatedItem(false), 2.5),
                new Reward(new ChainLeggings(80).getUpdatedItem(false), 2.5),
                new Reward(new ChainBoots(80).getUpdatedItem(false), 2.5),

                new Reward(new ChainHelmet(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new ChainChestplate(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new ChainLeggings(Utils.randRarity()).getUpdatedItem(false), 2.5),
                new Reward(new ChainBoots(Utils.randRarity()).getUpdatedItem(false), 2.5),

                new Reward(new RefinedDagger(50).getUpdatedItem(false), 3.0),
                new Reward(new RefinedDagger(Utils.randRarity()).getUpdatedItem(false), 5.0),

                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 2.0),
                new Reward(new SimpleStrengthGem(0).getUpdatedItem(false), 1.0),
        });
    }
}
