package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
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

public class BenButcher implements Listener {

    ArrayList<ItemStack> foodItems = new ArrayList<>(){
        {
            add(setCost(new Drumstick(0).getUpdatedItem(false), 5));
            add(setCost(new Drumstick(50).getUpdatedItem(false), 15));
            add(setCost(new Drumstick(100).getUpdatedItem(false), 30));
            add(setCost(new Porkchop(0).getUpdatedItem(false), 10));
            add(setCost(new Porkchop(50).getUpdatedItem(false), 30));
            add(setCost(new Porkchop(100).getUpdatedItem(false), 45));
            add(setCost(new Beef(0).getUpdatedItem(false), 15));
            add(setCost(new Beef(50).getUpdatedItem(false), 45));
            add(setCost(new Beef(100).getUpdatedItem(false), 60));
        }
    };

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
        ItemStack item = Utils.removeLastLore(foodItems.get(e.getSlot()));
        if (e.getCurrentItem() == null) {return;}
        int cost = Utils.getCost(e.getCurrentItem());
        if (VaultHook.econ.getBalance(player) < cost) {
            player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
            return; }
        if (e.getView().getBottomInventory().firstEmpty() == -1) {
            player.sendMessage(Utils.tacc("&cYour inventory is full!"));
            return; }
        player.updateInventory();
        player.getInventory().addItem(item);
        VaultHook.econ.withdrawPlayer(player, cost);
        Scoreboard.updateScoreboard(player);
        player.sendMessage(Utils.tacc("&eYou have purchased an item"));
    }


    private Inventory getShopMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 9, "Ben the Butcher");

        //Fill in the GUI
        for (ItemStack item : foodItems) {
            gui.addItem(item);
        }

        player.setMetadata("BenButcher", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}