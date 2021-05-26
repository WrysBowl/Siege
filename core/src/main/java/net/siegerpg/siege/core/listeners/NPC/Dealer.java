package net.siegerpg.siege.core.listeners.NPC;

import kotlin.Triple;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.implemented.misc.food.Beef;
import net.siegerpg.siege.core.items.implemented.misc.food.Drumstick;
import net.siegerpg.siege.core.items.implemented.misc.food.Porkchop;
import net.siegerpg.siege.core.items.implemented.misc.food.SusStew;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dealer implements Listener {

    ArrayList<Triple<Integer, ItemStack, Integer>> toolItems = new ArrayList<>() {
        {
            add(new Triple<>(0, Seed.Companion.tier(1).getUpdatedItem(false), 15));
            add(new Triple<>(1, Vine.Companion.tier(1).getUpdatedItem(false), 10));
            add(new Triple<>(2, Stick.Companion.tier(1).getUpdatedItem(false), 10));
            add(new Triple<>(3, MetalScrap.Companion.tier(1).getUpdatedItem(false), 40));
            add(new Triple<>(4, Slime.Companion.tier(1).getUpdatedItem(false), 20));
            add(new Triple<>(5, Magma.Companion.tier(1).getUpdatedItem(false), 20));
            add(new Triple<>(6, Bone.Companion.tier(1).getUpdatedItem(false), 30));
            add(new Triple<>(7, Leather.Companion.tier(1).getUpdatedItem(false), 20));
            add(new Triple<>(8, new SusStew(50).getUpdatedItem(false), 300));
        }
    };

    ArrayList<ItemStack> toolItemsCost = new ArrayList<>(){
        {
            add(Utils.setCost(Seed.Companion.tier(1).getUpdatedItem(false), 15));
            add(Utils.setCost(Vine.Companion.tier(1).getUpdatedItem(false), 10));
            add(Utils.setCost(Stick.Companion.tier(1).getUpdatedItem(false), 10));
            add(Utils.setCost(MetalScrap.Companion.tier(1).getUpdatedItem(false), 40));
            add(Utils.setCost(Slime.Companion.tier(1).getUpdatedItem(false), 20));
            add(Utils.setCost(Magma.Companion.tier(1).getUpdatedItem(false), 20));
            add(Utils.setCost(Bone.Companion.tier(1).getUpdatedItem(false), 30));
            add(Utils.setCost(Leather.Companion.tier(1).getUpdatedItem(false), 20));
            add(Utils.setCost(new SusStew(50).getUpdatedItem(false), 300));
        }
    };

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Dealer") && e.getRightClicked().getName().contains("6")) {
            Inventory shop = getShopMenu(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("Dealer").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("Dealer").get(0).value(), e.getInventory())) {
            clickShop(e);
            e.setCancelled(true);
        }
    }

    private void clickShop(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {return;}
        int cost = toolItems.get(e.getSlot()).component3();
        ItemStack item = toolItems.get(e.getSlot()).component2();
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
        Inventory gui = Bukkit.createInventory(null, 9, "Sus Dealer");

        //Fill in the GUI
        for (ItemStack item : toolItemsCost) {
            gui.addItem(item);
        }

        player.setMetadata("Dealer", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }



}