package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.MythicMob;
import net.siegerpg.siege.core.dropTable.mobDrops;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {
    @EventHandler
    public void mobDeath(EntityDeathEvent e) {

        String mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType().getInternalName();
        mobDrops mobDrop = mobDrops.matchCaseMobDrops(mm);

        e.setDroppedExp(0);
        e.getDrops().clear();
        if (mobDrop == null) {
            return;
        }

        Player player = e.getEntity().getKiller();
        Double luck = null;
        if (player != null) {luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK);}
        if (mobDrop.getExp(true) > 0 && player != null) { Levels.addExp(player, mobDrop.getExp(true)); } //Give exp reward

        ItemStack goldCoins = Utils.getGoldCoin();
        goldCoins.setAmount(mobDrop.getGold(true));
        e.getDrops().add(goldCoins); //Give gold reward

        for (ItemStack drop : mobDrop.getRewards(luck)) { //Loop through all drops
            e.getDrops().add(drop);
        }
    }
}
