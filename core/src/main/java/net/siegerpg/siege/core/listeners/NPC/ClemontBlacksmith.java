package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.MetalScrap;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
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
        if (e.getRightClicked().getName().contains("Clemont") && e.getRightClicked().getName().contains("6")) {
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
        if (slot > 9 && slot < 17 && e.getCurrentItem() != null) {
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
        if (slot > 18 && e.getCurrentItem() != null) {
            ArrayList<ItemStack> reqIngredients = new ArrayList<>();
            ItemStack result = null;
            int cost = 0;
            switch (e.getSlot()) {
                case 19: //Iron Shovel
                    //Initialize Ingredients
                    ItemStack ironShovel1 = Stick.Companion.tier(3).getUpdatedItem(false);
                    ironShovel1.setAmount(2);
                    ItemStack ironShovel2 = MetalScrap.Companion.tier(3).getUpdatedItem(false);
                    ironShovel2.setAmount(1);

                    //Add ingredients to required ingredients
                    reqIngredients.add(ironShovel1);
                    reqIngredients.add(ironShovel2);
                    //Set result of recipe
                    result = new ItemStack(Material.IRON_SHOVEL);
                    cost = 5000;
                    break;
                case 20: //Iron Axe
                    //Initialize Ingredients
                    ItemStack ironAxe1 = Stick.Companion.tier(3).getUpdatedItem(false);
                    ironAxe1.setAmount(2);
                    ItemStack ironAxe2 = MetalScrap.Companion.tier(3).getUpdatedItem(false);
                    ironAxe2.setAmount(3);

                    //Add ingredients to required ingredients
                    reqIngredients.add(ironAxe1);
                    reqIngredients.add(ironAxe2);
                    //Set result of recipe
                    result = new ItemStack(Material.IRON_AXE);
                    cost = 8000;
                    break;
                case 21: //Iron pickaxe
                    //Initialize Ingredients
                    ItemStack ironPickaxe1 = Stick.Companion.tier(3).getUpdatedItem(false);
                    ironPickaxe1.setAmount(2);
                    ItemStack ironPickaxe2 = MetalScrap.Companion.tier(3).getUpdatedItem(false);
                    ironPickaxe2.setAmount(3);

                    //Add ingredients to required ingredients
                    reqIngredients.add(ironPickaxe1);
                    reqIngredients.add(ironPickaxe2);
                    //Set result of recipe
                    result = new ItemStack(Material.IRON_PICKAXE);
                    cost = 8000;
                    break;
                default:
                    return;
            }
            for (ItemStack item : reqIngredients) {
                if (!player.getInventory().containsAtLeast(item, item.getAmount())) {
                    player.sendMessage(Utils.parse("<red>You do not have the required materials to craft this item."));
                    return;
                }
            }
            if (VaultHook.econ.getBalance(player) < cost) {
                player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
                return;
            }
            for (ItemStack item : reqIngredients) { player.getInventory().removeItem(item); }
            if (!(e.getView().getBottomInventory().firstEmpty() == -1)) {
                player.closeInventory();
                VaultHook.econ.withdrawPlayer(player, cost);
                Scoreboard.updateScoreboard((Player) e.getWhoClicked());
                player.sendMessage(Utils.tacc("&eYou have purchased an item"));
                player.getInventory().addItem(result);
                return;
            }
            player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
        }
    }


    private Inventory getShopMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 36, "Clemont's Shop");

        ArrayList<ItemStack> toolItems = new ArrayList<>(){
            {
                add(setCost(new ItemStack(Material.WOODEN_SHOVEL), 100));
                add(setCost(new ItemStack(Material.WOODEN_AXE), 150));
                add(setCost(new ItemStack(Material.WOODEN_PICKAXE), 150));
                add(setCost(new ItemStack(Material.STONE_AXE), 3000));
                add(setCost(new ItemStack(Material.STONE_PICKAXE), 3000));
                add(setCost(new ItemStack(Material.STONE_SHOVEL), 2000));
                add(setCost(new ItemStack(Material.ARROW, 64), 150));
                add(Utils.addLore(new ItemStack(Material.IRON_SHOVEL),
                        Utils.lore("<yellow>5000"),
                        Utils.lore("<dark_aqua>Click to Craft"),
                        Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
                        Utils.lore("<dark_aqua>MetalScrap \u272A\u272A\u272A x1")));
                add(Utils.addLore(new ItemStack(Material.IRON_AXE),
                        Utils.lore("<yellow>8000"),
                        Utils.lore("<dark_aqua>Click to Craft"),
                        Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
                        Utils.lore("<dark_aqua>MetalScrap \u272A\u272A\u272A x3")));
                add(Utils.addLore(new ItemStack(Material.IRON_PICKAXE),
                        Utils.lore("<yellow>8000"),
                        Utils.lore("<dark_aqua>Click to Craft"),
                        Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
                        Utils.lore("<dark_aqua>MetalScrap \u272A\u272A\u272A x3")));

            }
        };

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        for (int i=10; i<17; i++) { //Sets crafting grid slots
            gui.clear(i);
            gui.clear(i+9);
        }

        for (ItemStack item : toolItems) {
            gui.addItem(item);
        }

        player.setMetadata("ClemontShop", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}