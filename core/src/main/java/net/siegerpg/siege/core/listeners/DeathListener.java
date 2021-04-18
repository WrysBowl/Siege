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

        MythicMob mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType();
        mobDrops mobDrop = mobDrops.matchCaseMobDrops(mm.toString());

        e.setDroppedExp(0);
        e.getDrops().clear();
        if (mobDrop == null) {
            return;
        }

        Entity mob = e.getEntity();
        Location loc = mob.getLocation();
        Player player = e.getEntity().getKiller();

        if (mobDrop.getExp() > 0) { Levels.addExp(player, mobDrop.getExp()); } //Give exp reward

        ItemStack goldCoins = Utils.getGoldCoin();
        goldCoins.setAmount(mobDrop.getGold());
        e.getEntity().getWorld().dropItemNaturally(loc, goldCoins); //Give gold reward

        for (ItemStack drop : mobDrop.getRewards(CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK))) { //Loop through all drops
            e.getEntity().getWorld().dropItemNaturally(loc, drop);
        }
    }
}
