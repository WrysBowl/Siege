package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
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

public class ClemontBlacksmith implements Listener {

    private ItemStack setCost(ItemStack item, Integer cost) {

        List<String> lore;
        if (item.getLore() == null) {
            lore = new ArrayList<>(1);
        } else {
            lore = new ArrayList<>(item.getLore().size() + 1);
            lore.addAll(item.getLore());
        }
        lore.add(Utils.tacc("&eCost " + cost));

        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Clemont") && e.getRightClicked() instanceof Villager) {
            Inventory shop = getShopMenu(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("ClemontShop").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("ClemontShop").get(0).value(), e.getInventory())) {
            clickShop(e);
            e.setCancelled(true);
        }
    }

    private void clickShop(InventoryClickEvent e) {
        int slot = e.getSlot();
        Player player = (Player) e.getWhoClicked();
        if (slot > 10 && slot < 17 && e.getCurrentItem() != null) {
            int cost = Utils.getCost(e.getCurrentItem());
            if (VaultHook.econ.getBalance(player) >= cost) {
                if (!(e.getView().getBottomInventory().firstEmpty() == -1)) {
                    player.closeInventory();
                    player.getInventory().addItem(Utils.removeLastLore(e.getCurrentItem()));
                    VaultHook.econ.withdrawPlayer(player, cost);
                    Scoreboard.updateScoreboard((Player) e.getWhoClicked());
                    player.sendMessage(Utils.tacc("&eYou have purchased an item"));
                } else {
                    player.sendMessage(Utils.tacc("&cYour inventory is full!"));
                }
            } else {
                player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
            }
        }
    }


    private Inventory getShopMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Clemont's Shop");

        ItemStack arrows = new ItemStack(Material.ARROW);
        arrows.setAmount(16);

        ArrayList<ItemStack> toolItems = new ArrayList<>(){
            {
                add(setCost(new ItemStack(Material.WOODEN_SHOVEL), 1200));
                add(setCost(new ItemStack(Material.WOODEN_AXE), 1800));
                add(setCost(new ItemStack(Material.WOODEN_PICKAXE), 3000));
                add(setCost(new ItemStack(Material.STONE_AXE), 3750));
                add(setCost(new ItemStack(Material.STONE_PICKAXE), 4500));
                add(setCost(new ItemStack(Material.STONE_SHOVEL), 3000));
                add(setCost(arrows, 40));
            }
        };

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        for (int i=10; i<18; i++) { //Sets crafting grid slots
            gui.clear(i);
        }

        for (ItemStack item : toolItems) {
            gui.addItem(item);
        }

        player.setMetadata("ClemontShop", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}