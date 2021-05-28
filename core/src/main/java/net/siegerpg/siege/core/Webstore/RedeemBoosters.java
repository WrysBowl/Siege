package net.siegerpg.siege.core.Webstore;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.informants.Tablist;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class RedeemBoosters implements Listener {

    @EventHandler
    public void onEXPBoosterRedeem(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = e.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() != Material.PAPER) return;
            if (item.getItemMeta().getDisplayName().contains("EXP Booster")) {

                //Check if the exp multiplier is already above 1, if it is then prevent the next steps by returning
                if (WebstoreUtils.expMultiplier > 1.0) {
                    player.sendMessage(Utils.lore("<red>A global booster is already active!"));
                    return;
                }

                //Getting the hidden 'NBT' value that contains the multiplier of the item and setting the exp multiplier to it
                NBTItem nbt = new NBTItem(item);
                double multi = nbt.getDouble("multiplier");
                int sec = nbt.getInteger("seconds");
                WebstoreUtils.expMultiplier = multi;

                //Send a message to the player saying their booster has been activated
                player.sendMessage(Utils.lore("<green>Your EXP multiplier has been redeemed."));
                Bukkit.getOnlinePlayers().forEach(p -> {
                        p.sendTitle("", Utils.tacc("&d&l" + multi + "x EXP BOOST"), 10, 60, 10);
                        Scoreboard.updateScoreboard(p);
                });

                //Take away global booster from player's hand
                player.getInventory().getItemInMainHand().setAmount(item.getAmount()-1);

                //After the duration of the described webstore booster's item is over, return exp multiplier back to 1.0
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        WebstoreUtils.expMultiplier = 1.0;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            Scoreboard.updateScoreboard(p);
                        }
                    }
                }.runTaskLater(Core.plugin(), sec* 20L);
            }
        }
    }
}
