package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import net.siegerpg.siege.core.drops.MobDrops;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {
    @EventHandler
    public void mobDeath(EntityDeathEvent e) {

        if (!(MythicMobs.inst().getAPIHelper().isMythicMob(e.getEntity()))) { return; }

        String mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity()).getType().getInternalName();
        MobDrops mobDrop = new MobDrops();
        mobDrop.setMobTable(mm);

        e.setDroppedExp(0);
        e.getDrops().clear();

        if (!mobDrop.isMob_exists()) {return;}

        Player player = e.getEntity().getKiller();
        Double luck = 0.0;
        ItemStack goldCoins = Utils.getGoldCoin();
        goldCoins.setAmount(mobDrop.getGold(true));
        if (player != null) {luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK);}
        if (mobDrop.getExp(true) > 0 && player != null) { Levels.addExp(player, mobDrop.getExp(true)); } //Give exp reward

        if (goldCoins.getAmount() > 0) { e.getDrops().add(goldCoins); } //Give gold reward
        
        for (ItemStack drop : mobDrop.getRewards(luck)) { //Loop through all drops
            e.getDrops().add(drop);
        }

        for (int i = 0; i<e.getDrops().size(); i++) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), e.getDrops().get(i));
        }
    }

}
