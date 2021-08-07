package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTItem;
import kotlin.Suppress;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.fishing.fish.Fish;
import net.siegerpg.siege.core.fishing.fish.FishCore;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Henry implements Listener {

    @EventHandler
    public void onRightClickEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Henry") && e.getRightClicked().getName().contains("6")) {
            Player person = e.getPlayer();
            buyFish(person);
        }
    }
    private void buyFish(Player player) {
        ItemStack hand = player.getInventory().getItemInMainHand().asOne();
        if (hand.getType().equals(Material.AIR)) return;
        NBTItem nbt = new NBTItem(hand);
        String fishName = nbt.getString("Name");
        if (fishName == null) {
            player.sendMessage(Utils.parse("<red>This is not a fish."));
            return;
        }
        Fish fish = FishCore.getFish(fishName);
        if (fish == null) {
            player.sendMessage(Utils.parse("<red>This is not a fish!"));
            return;
        }

        int goldAmount = (int)fish.actualSize;
        VaultHook.econ.depositPlayer(player, goldAmount);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        player.sendActionBar(Utils.parse("<yellow>+ " + goldAmount + " <yellow>Gold"));
        player.sendMessage(Utils.parse("\n<green>You sold a <aqua>"+ goldAmount +" cm "+fish.name+" <yellow>for "+goldAmount+" coins!\n"));
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
            public void run() {
                Scoreboard.updateScoreboard(player);
            }
        }, 20);

        player.getInventory().removeItem(hand);
    }
}
