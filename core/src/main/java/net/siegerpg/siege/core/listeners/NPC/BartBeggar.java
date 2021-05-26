package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.listeners.NPC.GamblingGames.TreasureHunter;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BartBeggar implements Listener {

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Bart") && e.getRightClicked().getName().contains("6")) {
            getMenu().show(e.getPlayer());
        }
    }
    private ChestGui getMenu() {
        //Menu
        ChestGui menu = new ChestGui(3, "Bart's MineSweeper");

        menu.setOnGlobalClick(event -> event.setCancelled(true));

        OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);
        background.addItem(new GuiItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE)));
        background.setRepeat(true);

        menu.addPane(background);

        OutlinePane navigator = new OutlinePane(4, 1, 1, 1);

        //Creating Armor Icon
        ItemStack startIcon = new ItemStack (Material.ENDER_EYE);
        ItemMeta startIconMeta = startIcon.getItemMeta();
        startIconMeta.displayName(Utils.lore("<gold><bold>TREASURE HUNTER"));
        startIconMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<gray>Uncover as many"));
                add(Utils.lore("<gray>rewards as you can"));
                add(Utils.lore("<gray>without blowing up!"));
                add(Utils.lore(""));
                add(Utils.lore("<yellow>COST 500 gold"));
                add(Utils.lore("<green><BOLD>CLICK TO PLAY"));
            }
        });
        startIcon.setItemMeta(startIconMeta);

        navigator.addItem(new GuiItem(startIcon, this::clickStart));

        menu.addPane(navigator);
        return menu;
    }

    private void clickStart(InventoryClickEvent e) {
        if (e.getSlot() == 13) {
            Player player = (Player) e.getWhoClicked();
            int cost = 500;
            if (VaultHook.econ.getBalance(player) >= cost) {
                VaultHook.econ.withdrawPlayer(player, cost);
                Scoreboard.updateScoreboard((Player) e.getWhoClicked());
                TreasureHunter game = new TreasureHunter(player);
                return;
            }
            player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
        }
    }
}
