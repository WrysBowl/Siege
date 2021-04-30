package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
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

public class SmokyBlacksmith implements Listener {

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().equals("&6Smoky")) {
            Inventory shop = getShopMenu(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("Shop").equals(e.getInventory())) {
            clickShopMenu(e);
        } else if (e.getWhoClicked().getMetadata("ShopWeapons").equals(e.getInventory())) {
            clickShopWeapons(e);
        } else if (e.getWhoClicked().getMetadata("ShopArmor").equals(e.getInventory())) {
            clickShopArmor(e);
        }
    }

    private void clickShopMenu(InventoryClickEvent e) {
        int slot = e.getSlot();
        Player player = (Player) e.getWhoClicked();
        if (slot == 11) {
            player.openInventory(getWeaponsMenu(player));
        } else if (slot == 15) {
            player.openInventory(getArmorMenu(player));
        }
    }
    private void clickShopWeapons(InventoryClickEvent e) {
        int slot = e.getSlot();
        Player player = (Player) e.getWhoClicked();
        if (slot > 10 && slot < 18) {
            int cost = Utils.getCost(e.getCurrentItem());
            if (VaultHook.econ.getBalance(player) >= cost) {
                if (player.getInventory().isEmpty()) {
                    player.getInventory().addItem(Utils.removeLastLore(e.getCurrentItem()));
                    VaultHook.econ.withdrawPlayer(player, cost);
                    player.sendMessage(Utils.tacc("&cYou have purchased an item"));
                } else {
                    player.sendMessage(Utils.tacc("&cYour inventory is full!"));
                }
            } else {
                player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
            }
        }
    }
    private void clickShopArmor(InventoryClickEvent e) {
        int slot = e.getSlot();
        Player player = (Player) e.getWhoClicked();
        if (slot > 10 && slot < 18) {
            int cost = Utils.getCost(e.getCurrentItem());
            if (VaultHook.econ.getBalance(player) >= cost) {
                if (player.getInventory().isEmpty()) {
                    player.getInventory().addItem(Utils.removeLastLore(e.getCurrentItem()));
                    VaultHook.econ.withdrawPlayer(player, cost);
                    player.sendMessage(Utils.tacc("&cYou have purchased an item"));
                } else {
                    player.sendMessage(Utils.tacc("&cYour inventory is full!"));
                }
            } else {
                player.sendMessage(Utils.tacc("&cYou do not have enough money to purchase this item!"));
            }
        }
    }

    private Inventory getShopMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Shop");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        //Creating Weapons Icon
        ItemStack weapons = new ItemStack (Material.STONE_SWORD);
        ItemMeta weaponsMeta = weapons.getItemMeta();
        weaponsMeta.displayName(Utils.lore("<dark_red>Weapons"));
        weaponsMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<gray>Click for Weapons"));
            }
        });
        weapons.setItemMeta(weaponsMeta);

        //Creating Armor Icon
        ItemStack armor = new ItemStack (Material.IRON_CHESTPLATE);
        ItemMeta armorMeta = armor.getItemMeta();
        armorMeta.displayName(Utils.lore("<dark_aqua>Armor"));
        armorMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<gray>Click for Armor"));
            }
        });
        armor.setItemMeta(armorMeta);

        //This is where you decide what slot the item goes into
        gui.setItem(11, weapons);
        gui.setItem(15, armor);

        player.setMetadata("Shop", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }

    private Inventory getWeaponsMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Shop");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        gui.setItem(11, Utils.setLoreCost(new Twig(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(12, Utils.setLoreCost(new StickyStick(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(13, Utils.setLoreCost(new ScrapyardBow(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(14, Utils.setLoreCost(new WoodenBow(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(15, Utils.setLoreCost(new Club(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(16, Utils.setLoreCost(new GiantClub(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(17, Utils.setLoreCost(new GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)));


        player.setMetadata("ShopWeapons", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }

    private Inventory getArmorMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "ShopArmor");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        gui.setItem(11, Utils.setLoreCost(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(12, Utils.setLoreCost(new WoolChestplate(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(13, Utils.setLoreCost(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(14, Utils.setLoreCost(new WoolBoots(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(15, Utils.setLoreCost(new WoolHelmet(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(16, Utils.setLoreCost(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false)));
        gui.setItem(17, Utils.setLoreCost(new WoolLeggings(Utils.randRarity()).getUpdatedItem(false)));


        player.setMetadata("ShopArmor", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}