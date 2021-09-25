package net.siegerpg.siege.core.drops.mobs.hillyWoods.bosses;

import net.siegerpg.siege.core.drops.MobDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.armor.boots.ChainBoots;
import net.siegerpg.siege.core.items.implemented.armor.boots.MagmaBoots;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.ChainChestplate;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.MagmaChestplate;
import net.siegerpg.siege.core.items.implemented.armor.helmet.ChainHelmet;
import net.siegerpg.siege.core.items.implemented.armor.helmet.MagmaHelmet;
import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings;
import net.siegerpg.siege.core.items.implemented.armor.leggings.MagmaLeggings;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.MagmaSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods.SlimeSpiritKey;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.FlawedRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems.RawRegenerationGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.FlawedStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.RawStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.wands.MatchStick;
import net.siegerpg.siege.core.utils.Utils;

public class Molter extends MobDropTable {
    public Molter() {
        super("Molter", 26, 29, 31, 34, new Reward[]{
                new Reward(Magma.Companion.tier(2).getUpdatedItem(false), 100.0),
                new Reward(Magma.Companion.tier(3).getUpdatedItem(false), 10.0),

                new Reward(new MagmaHelmet(80).getUpdatedItem(false), 2.5),
                new Reward(new MagmaChestplate(80).getUpdatedItem(false), 2.5),
                new Reward(new MagmaLeggings(80).getUpdatedItem(false), 2.5),
                new Reward(new MagmaBoots(80).getUpdatedItem(false), 2.5),

                new Reward(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false), 2.0),
                new Reward(new MatchStick(Utils.randRarity()).getUpdatedItem(false), 5.0),

                new Reward(new FlawedStrengthGem(0).getUpdatedItem(false), 2.0),
                new Reward(new FlawedRegenerationGem(0).getUpdatedItem(false), 2.0),
                new Reward(new MagmaSpiritKey(0).getUpdatedItem(false), 10.0),
        });
    }
}
