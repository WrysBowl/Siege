package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicDropLoadEvent;
import io.lumine.xikage.mythicmobs.api.bukkit.events.MythicMobDeathEvent;
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
import org.bukkit.Location;
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
        double luck = 0.0;
        int goldCoinAmt = mobDrop.getGold(true);
        Location loc = e.getEntity().getLocation();

        if (player != null) {luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());}

        if (mobDrop.getExp(true) > 0 && player != null) {
            int exp = mobDrop.getExp(true);
            if ((Math.random() * 100) <= luck) {
                exp *= 2;
            }
            ExperienceOrb orb = loc.getWorld().spawn(loc, ExperienceOrb.class);
            orb.setCustomName(Utils.tacc("&5+" + exp + " EXP"));
            orb.setExperience(exp);
            orb.setCustomNameVisible(true);
        } //Give exp reward

        if (goldCoinAmt > 0) {
            if ((Math.random() * 100) <= luck) {
                goldCoinAmt *= 2;
            }
            ItemStack goldCoin = Utils.getGoldCoin(goldCoinAmt);
            Item gold = loc.getWorld().dropItemNaturally(loc, goldCoin);
            gold.setCustomName(Utils.tacc("&e+" + goldCoinAmt + " Gold"));
            gold.setCustomNameVisible(true);
        }

        for (ItemStack drop : mobDrop.getRewards(luck)) { //Loop through all drops
            loc.getWorld().dropItemNaturally(loc, drop);
        }
    }

    @EventHandler
    public void onEntityDeath(PlayerDeathEvent e) {
        e.deathMessage(null);
        Player player = e.getEntity().getPlayer();
        if (player != null) {
            if (player.getWorld().equals(Core.plugin().getServer().getWorld("SiegeHub"))) return;
            player.spigot().respawn();
            player.teleport(player.getWorld().getSpawnLocation());
            double bal = Math.round(VaultHook.econ.getBalance(player));
            int newBal = (int) Math.round(bal * 0.95);
            if (newBal < 0) newBal = 0;
            VaultHook.econ.withdrawPlayer(player, bal);
            VaultHook.econ.depositPlayer(player, newBal);
            player.sendTitle(Utils.tacc("&c&lYou Died"), Utils.tacc("&7" + (bal - newBal) + " has been lost"), 1, 60, 1);
            Scoreboard.updateScoreboard(player);
        }
    }

    @Override
    public void run() {

    }
}