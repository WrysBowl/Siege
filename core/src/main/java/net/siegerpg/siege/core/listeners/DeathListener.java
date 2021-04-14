package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.MythicMob;
import net.siegemc.core.olditems.droptable.MobDrops;
import net.siegemc.core.utils.Levels;
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
        Entity mob = e.getEntity();
        Location loc = mob.getLocation();
        Player player = e.getEntity().getKiller();

        MythicMob mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType();

        if (MobDrops.checkAllDrops(mm) == null) {
            return;
        }

        e.getDrops().clear();

        MobDrops dropTable = new MobDrops();
        dropTable.giveMobDrops(mm, player);
        int expReward = dropTable.getExpReward();

        if (expReward > 0) { Levels.addExp(player, expReward); } //Give exp reward

        for (ItemStack drop : dropTable.getItemRewards()) { //Loop through all drops
            e.getEntity().getWorld().dropItemNaturally(loc, drop);
        }
    }
}
