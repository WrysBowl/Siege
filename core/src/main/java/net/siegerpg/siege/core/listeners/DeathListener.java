package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.drops.MobDrops;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Score;

public class DeathListener implements Listener, Runnable {
    @EventHandler
    public void mobDeath(EntityDeathEvent e) {

        if (!(MythicMobs.inst().getAPIHelper().isMythicMob(e.getEntity()))) { return; }

        ActiveMob mm = MythicMobs.inst().getAPIHelper().getMythicMobInstance(e.getEntity());
        MobDrops mobDrop = new MobDrops();
        mobDrop.setMobTable(mm);

        e.setDroppedExp(0);
        e.getDrops().clear();

        if (!mobDrop.isMob_exists()) {return;}

        Player player = e.getEntity().getKiller();
        Double luck = 0.0;
        ItemStack goldCoins = Utils.getGoldCoin();
        goldCoins.setAmount(mobDrop.getGold(true));

        if (player != null) {luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());}
        if ((Math.random() * 100) <= luck) {
            goldCoins.setAmount(goldCoins.getAmount() * 2);
        }
        if (mobDrop.getExp(true) > 0 && player != null) {
            int exp = mobDrop.getExp(true);
            if ((Math.random() * 100) <= luck) {
                exp *= 2;
            }
            Levels.INSTANCE.addExp(player, exp);
            player.sendActionBar(Utils.parse("<dark_purple>+ " + exp + " <dark_purple>EXP"));
        } //Give exp reward

        if (goldCoins.getAmount() > 0) { e.getDrops().add(goldCoins); } //Give gold reward
        
        for (ItemStack drop : mobDrop.getRewards(luck)) { //Loop through all drops
            e.getDrops().add(drop);
        }

        for (int i = 0; i<e.getDrops().size(); i++) {
            e.getEntity().getWorld().dropItemNaturally(e.getEntity().getLocation(), e.getDrops().get(i));
        }
        if (player != null) {
            Scoreboard.updateScoreboard(player);
        }
    }

    @EventHandler
    public void onEntityDeath(PlayerDeathEvent e) {
        e.deathMessage(null);
        Player player = e.getEntity().getPlayer();
        if (player != null) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Core.plugin(), () -> {
                double bal = Math.round(VaultHook.econ.getBalance(player));
                double newBal = Math.round(bal * 0.95);
                VaultHook.econ.withdrawPlayer(player, bal);
                VaultHook.econ.depositPlayer(player, newBal);
                player.sendTitle(Utils.tacc("&c&lYou Died"), Utils.tacc("&7" + (bal - newBal) + " has been taken"), 1, 60, 1);
                Scoreboard.updateScoreboard(player);
            }, 2);
        }
    }

    @Override
    public void run() {

    }
}