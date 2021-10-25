package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.listeners.NPC.GamblingGames.TreasureHunter;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BartBeggar implements Listener {

    @EventHandler
    public void onRightClickOnEntity(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Bart") && e.getRightClicked().getName().contains("6")) {
            this.getMenu().show(e.getPlayer());
        }
    }
    private ChestGui getMenu() {
        //Menu
        final ChestGui menu = new ChestGui(3, "Bart's Treasure Hunt");

        menu.setOnGlobalClick(event -> event.setCancelled(true));

        final OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);

        final ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        final ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.displayName(Utils.lore(""));
        filler.setItemMeta(fillerMeta);
        background.addItem(new GuiItem(filler));

        background.setRepeat(true);

        menu.addPane(background);

        final OutlinePane navigator = new OutlinePane(4, 0, 1, 2);

        //Creating Start Icon
        final ItemStack startIcon = new ItemStack (Material.ENDER_EYE);
        final ItemMeta startIconMeta = startIcon.getItemMeta();
        startIconMeta.displayName(Utils.lore("<gold><bold>TREASURE HUNTER"));
        startIconMeta.lore(new ArrayList<>(){
            {
                this.add(Utils.lore("<gray>Uncover as many"));
                this.add(Utils.lore("<gray>rewards as you can"));
                this.add(Utils.lore("<gray>without blowing up!"));
                this.add(Utils.lore(""));
                this.add(Utils.lore("<yellow>COST 500 gold"));
                this.add(Utils.lore("<green><BOLD>CLICK TO PLAY"));
            }
        });
        startIcon.setItemMeta(startIconMeta);

        //Creating JackPot Icon
        final ItemStack jackPotIcon = new ItemStack (Material.SUNFLOWER);
        final ItemMeta jackPotIconMeta = jackPotIcon.getItemMeta();
        jackPotIconMeta.displayName(Utils.lore("<yellow><bold>WIN THE JACKPOTS"));
        jackPotIconMeta.lore(new ArrayList<>(){
            {
                this.add(Utils.lore("<gray>1x <yellow>2,000 <gray>Gold"));
                this.add(Utils.lore("<gray>2x <yellow>1,000 <gray>Gold"));
                this.add(Utils.lore("<gray>3x <yellow>500 <gray>Gold"));
            }
        });
        jackPotIcon.setItemMeta(jackPotIconMeta);

        navigator.addItem(new GuiItem(jackPotIcon));
        navigator.addItem(new GuiItem(startIcon, this::clickStart));

        menu.addPane(navigator);
        return menu;
    }

    private void clickStart(final InventoryClickEvent e) {
        if (e.getSlot() == 13) {
            final Player player = (Player) e.getWhoClicked();
            final int cost = 500;
            if (VaultHook.econ.getBalance(player) >= cost) {
                VaultHook.econ.withdrawPlayer(player, cost);
                Scoreboard.updateScoreboard((Player) e.getWhoClicked());
                final TreasureHunter game = new TreasureHunter(player);
                return;
            }
            player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
        }
    }
}
