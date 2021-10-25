package net.siegerpg.siege.core.listeners.NPC;

import kotlin.Triple;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.*;

public class BenButcher implements Listener {

    ArrayList<Triple<Integer, ItemStack, Integer>> foodItems = new ArrayList<>() {
        {
            this.add(new Triple<>(0, new Drumstick(0).getUpdatedItem(false), 5));
            this.add(new Triple<>(1, new Drumstick(50).getUpdatedItem(false), 15));
            this.add(new Triple<>(2, new Drumstick(100).getUpdatedItem(false), 30));
            this.add(new Triple<>(3, new Porkchop(0).getUpdatedItem(false), 10));
            this.add(new Triple<>(4, new Porkchop(50).getUpdatedItem(false), 30));
            this.add(new Triple<>(5, new Porkchop(100).getUpdatedItem(false), 45));
            this.add(new Triple<>(6, new Beef(0).getUpdatedItem(false), 15));
            this.add(new Triple<>(7, new Beef(50).getUpdatedItem(false), 45));
            this.add(new Triple<>(8, new Beef(100).getUpdatedItem(false), 75));
        }
    };

    ArrayList<ItemStack> foodItemCost = new ArrayList<>(){
        {
            this.add(Utils.setCost(new Drumstick(0).getUpdatedItem(false), 5));
            this.add(Utils.setCost(new Drumstick(50).getUpdatedItem(false), 15));
            this.add(Utils.setCost(new Drumstick(100).getUpdatedItem(false), 30));
            this.add(Utils.setCost(new Porkchop(0).getUpdatedItem(false), 10));
            this.add(Utils.setCost(new Porkchop(50).getUpdatedItem(false), 30));
            this.add(Utils.setCost(new Porkchop(100).getUpdatedItem(false), 45));
            this.add(Utils.setCost(new Beef(0).getUpdatedItem(false), 15));
            this.add(Utils.setCost(new Beef(50).getUpdatedItem(false), 45));
            this.add(Utils.setCost(new Beef(100).getUpdatedItem(false), 75));
        }
    };

    @EventHandler
    public void onRightClickOnEntity(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Ben") && e.getRightClicked().getName().contains("6")) {
            final Inventory shop = this.getShopMenu(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(final InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("BenButcher").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("BenButcher").get(0).value(), e.getInventory())) {
            this.clickShop(e);
            e.setCancelled(true);
        }
    }

    private void clickShop(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {return;}
        final int cost = this.foodItems.get(e.getSlot()).component3();
        final ItemStack item = this.foodItems.get(e.getSlot()).component2();
        if (VaultHook.econ.getBalance(player) < cost) {
            player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
            return; }
        if (e.getView().getBottomInventory().firstEmpty() == -1) {
            player.sendMessage(Utils.tacc("&cYour inventory is full!"));
            return; }
        player.getInventory().addItem(item);
        VaultHook.econ.withdrawPlayer(player, cost);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        Scoreboard.updateScoreboard(player);
        player.sendMessage(Utils.tacc("&eYou have purchased an item"));
    }


    private Inventory getShopMenu(final Player player) {
        final Inventory gui = Bukkit.createInventory(null, 9, "Ben the Butcher");

        //Fill in the GUI
        for (final ItemStack item : this.foodItemCost) {
            gui.addItem(item);
        }

        player.setMetadata("BenButcher", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}