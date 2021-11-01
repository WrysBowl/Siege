package net.siegerpg.siege.core.webstore;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.WebstoreDB;
import net.siegerpg.siege.core.utils.cache.GlobalMultipliers;
import net.siegerpg.siege.core.webstore.categories.boosters.WebstoreBoosters;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class WebstoreListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        String[] commands = WebstoreDB.INSTANCE.blockingGetStoreCommands(e.getPlayer());

        //TODO: Iterate through the array and convert each iteration from string to array
        //  , separated by a space. Then add the uuid of the player to the 0th index
    }

    @EventHandler
    public void onEXPBoosterRedeem(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = e.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() != Material.PAPER) return;
            if (item.getItemMeta().getDisplayName().contains("EXP Booster")) {

                //Check if the exp multiplier is already above 1, if it is then prevent the next steps by returning
                if (GlobalMultipliers.expMultiplier > 1.0) {
                    player.sendMessage(Utils.lore("<red>A global booster is already active!"));
                    return;
                }

                //Getting the hidden 'NBT' value that contains the multiplier of the item and setting the exp multiplier to it
                NBTItem nbt = new NBTItem(item);
                double multi = nbt.getDouble("multiplier");
                int sec = nbt.getInteger("seconds");
                GlobalMultipliers.expMultiplier = multi;

                //Send a message to the player saying their booster has been activated
                player.sendMessage(Utils.lore("<green>Your EXP multiplier has been redeemed."));
                Bukkit.getOnlinePlayers().forEach(p -> {
                        p.sendTitle(Utils.tacc("&d&l" + ((multi*100)-100.0) + "% EXP BOOST"), Utils.tacc("&7" + Math.floor(sec/3600.0) + " hour(s) from &b" + player.getName()), 10, 100, 10);
                        Scoreboard.updateScoreboard(p);
                });

                //Take away global booster from player's hand
                player.getInventory().getItemInMainHand().setAmount(item.getAmount()-1);

                //After the duration of the described webstore booster's item is over, return exp multiplier back to 1.0
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        GlobalMultipliers.expMultiplier = 1.0;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Scoreboard.updateScoreboard(p);
                        }
                    }
                }.runTaskLater(Core.plugin(), sec* 20L);
            }
        }
    }

    @EventHandler
    public void onGoldBoosterRedeem(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = e.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() != Material.PAPER) return;
            if (item.getItemMeta().getDisplayName().contains("Gold Booster")) {

                //Check if the gold multiplier is already above 1, if it is then prevent the next steps by returning
                if (GlobalMultipliers.goldMultiplier > 1.0) {
                    player.sendMessage(Utils.lore("<red>A global booster is already active!"));
                    return;
                }

                //Getting the hidden 'NBT' value that contains the multiplier of the item and setting the gold multiplier to it
                NBTItem nbt = new NBTItem(item);
                double multi = nbt.getDouble("multiplier");
                int sec = nbt.getInteger("seconds");
                GlobalMultipliers.goldMultiplier = multi;

                //Send a message to the player saying their booster has been activated
                player.sendMessage(Utils.lore("<green>Your Gold multiplier has been redeemed."));
                Bukkit.getOnlinePlayers().forEach(p -> {
                    p.sendTitle(Utils.tacc("&e&l" + ((multi*100)-100.0) + "% Gold BOOST"), Utils.tacc("&7" + Math.floor(sec/3600.0) + " hour(s) from &b" + player.getName()), 10, 60, 10);
                    Scoreboard.updateScoreboard(p);
                });

                //Take away global booster from player's hand
                player.getInventory().getItemInMainHand().setAmount(item.getAmount()-1);

                //After the duration of the described webstore booster's item is over, return gold multiplier back to 1.0
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        GlobalMultipliers.goldMultiplier = 1.0;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Scoreboard.updateScoreboard(p);
                        }
                    }
                }.runTaskLater(Core.plugin(), sec* 20L);
            }
        }
    }
}
