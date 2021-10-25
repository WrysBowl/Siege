package net.siegerpg.siege.core.drops;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.items.implemented.misc.food.GoldenCarrot;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class MobDropTable implements Listener {
    String mobName;
    int goldMin;
    int goldMax;
    int expMin;
    int expMax;
    Reward[] rewards;

    public MobDropTable(final String mobName, final int goldMin, final int goldMax, final int expMin, final int expMax, final Reward[] rewards) {
        this.mobName = mobName;
        this.goldMin = goldMin;
        this.goldMax = goldMax;
        this.expMin = expMin;
        this.expMax = expMax;
        this.rewards = rewards;
    }

    public String getMobName() {
        return this.mobName;
    }

    public ArrayList<ItemStack> getRewards(final double luckChance) {
        final ArrayList<ItemStack> itemList = new ArrayList<>();
        for (final Reward reward : this.rewards) {
            if (Utils.randTest(reward.chance)) {
                if ((Math.random() * 100) <= luckChance) {
                    itemList.add(reward.item);
                }
                itemList.add(reward.item);
            }
        }
        return itemList;
    }
    public Integer getGold(final boolean rand) {
        if (rand) {
            return (int) Math.floor(Math.random()*(this.goldMax - this.goldMin +1)+ this.goldMin);
        }
        return this.goldMax;
    }
    public Integer getExp(final boolean rand) {
        if (rand) {
            return (int) Math.floor(Math.random()*(this.expMax - this.expMin +1)+ this.expMin);
        }
        return this.expMax;
    }
}