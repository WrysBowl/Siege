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
            add(new Triple<>(0, new Drumstick(0).getUpdatedItem(false), 5));
            add(new Triple<>(1, new Drumstick(50).getUpdatedItem(false), 15));
            add(new Triple<>(2, new Drumstick(100).getUpdatedItem(false), 30));
            add(new Triple<>(3, new Porkchop(0).getUpdatedItem(false), 10));
            add(new Triple<>(4, new Porkchop(50).getUpdatedItem(false), 30));
            add(new Triple<>(5, new Porkchop(100).getUpdatedItem(false), 45));
            add(new Triple<>(6, new Beef(0).getUpdatedItem(false), 15));
            add(new Triple<>(7, new Beef(50).getUpdatedItem(false), 45));
            add(new Triple<>(8, new Beef(100).getUpdatedItem(false), 75));
        }
    };

    ArrayList<ItemStack> foodItemCost = new ArrayList<>(){
        {
            add(Utils.setCost(new Drumstick(0).getUpdatedItem(false), 5));
            add(Utils.setCost(new Drumstick(50).getUpdatedItem(false), 15));
            add(Utils.setCost(new Drumstick(100).getUpdatedItem(false), 30));
            add(Utils.setCost(new Porkchop(0).getUpdatedItem(false), 10));
            add(Utils.setCost(new Porkchop(50).getUpdatedItem(false), 30));
            add(Utils.setCost(new Porkchop(100).getUpdatedItem(false), 45));
            add(Utils.setCost(new Beef(0).getUpdatedItem(false), 15));
            add(Utils.setCost(new Beef(50).getUpdatedItem(false), 45));
            add(Utils.setCost(new Beef(100).getUpdatedItem(false), 75));
        }
    };

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Ben") && e.getRightClicked().getName().contains("6")) {
            Inventory shop = getShopMenu(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("BenButcher").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("BenButcher").get(0).value(), e.getInventory())) {
            clickShop(e);
            e.setCancelled(true);
        }
    }

    private void clickShop(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {return;}
        int cost = foodItems.get(e.getSlot()).component3();
        ItemStack item = foodItems.get(e.getSlot()).component2();
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


    private Inventory getShopMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 9, "Ben the Butcher");

        //Fill in the GUI
        for (ItemStack item : foodItemCost) {
            gui.addItem(item);
        }

        player.setMetadata("BenButcher", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}