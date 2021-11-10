package net.siegerpg.siege.core.drops.mobs.hillyWoods.hostile;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;
import net.siegerpg.siege.core.utils.Utils;

public class FlamingGoo extends MobDropTable {
    public FlamingGoo() {
        super("FlamingGoo", 3, 6, 5, 7, new Reward[]{
                new Reward(Magma.Companion.tier(1).getUpdatedItem(false), 50.0),
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false), 5.0),

                new Reward(new MagmaHelmet(30).getUpdatedItem(false), 1.0),
                new Reward(new MagmaChestplate(30).getUpdatedItem(false), 1.0),
                new Reward(new MagmaLeggings(30).getUpdatedItem(false), 1.0),
                new Reward(new MagmaBoots(30).getUpdatedItem(false), 1.0),

                new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 0.5),
                new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 0.5),

                new Reward(new RawStrengthGem(0).getUpdatedItem(false), 1.0)
        });
    }
}
