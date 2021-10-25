package net.siegerpg.siege.core.listeners.NPC;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Henry implements Listener {

    @EventHandler
    public void onRightClickEntity(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Henry") && e.getRightClicked().getName().contains("6")) {
            final Player person = e.getPlayer();
	        this.buyFish(person);
        }
    }
    private void buyFish(final Player player) {
        final ItemStack hand = player.getInventory().getItemInMainHand();
        if (hand.getType().equals(Material.AIR)) return;
        final NBTItem nbt = new NBTItem(hand);
        String fishName = nbt.getString("Name");
        if (fishName == null) {
            player.sendMessage(Utils.parse("<red>This is not a fish."));
            return;
        }
        final Fish fish = FishCore.getFish(fishName);
        final int goldAmount;
        if (fish == null) {
            fishName = hand.getItemMeta().getDisplayName();
            final List<String> lore = hand.getItemMeta().getLore();
            if (lore != null && lore.get(0) != null && ChatColor.stripColor(lore.get(0)).contains("Size ")) {
                final String newLine = ChatColor.stripColor(lore.get(0).replace("Size ", "").replace(".0 cm", ""));
                goldAmount = Integer.parseInt(newLine)*3;
            } else {
                player.sendMessage(Utils.parse("<red>This is not a fish!"));
                return;
            }
        } else {
            goldAmount = (int)fish.actualSize*3;
        }

        VaultHook.econ.depositPlayer(player, goldAmount);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        player.sendActionBar(Utils.parse("<yellow>+ " + goldAmount + " <yellow>Gold"));
        player.sendMessage(Utils.parse("\n<green>You sold a <aqua>"+ (goldAmount/3) +" cm "+fishName+" <yellow>for "+goldAmount+" coins!\n"));
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
            public void run() {
                Scoreboard.updateScoreboard(player);
            }
        }, 20);

        player.getInventory().removeItem(hand.asOne());
    }
}
