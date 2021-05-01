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

public class SmokyBlacksmith implements Listener, Runnable {

    ArrayList<ItemStack> weaponItems = new ArrayList<>();
    ArrayList<ItemStack> shopWeapons = new ArrayList<>();
    ArrayList<ItemStack> armorItems = new ArrayList<>();
    ArrayList<ItemStack> shopArmor = new ArrayList<>();

    @Override
    public void run() {
    }

    public void resetItems() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            setShopWeapons();
            setShopArmor();
            for (int i = 0; i<7; i++) {
                weaponItems.set(i, shopWeapons.get((int) (Math.random() * 14)));
                armorItems.set(i, shopArmor.get((int) (Math.random() * 11)));
            }
        }, 72000, 72000);
    }

    private void setShopWeapons() {
        shopWeapons.set(0, Utils.setLoreCost(new Twig(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(1, Utils.setLoreCost(new StickyStick(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(2, Utils.setLoreCost(new Spade(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(3, Utils.setLoreCost(new Shovel(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(4, Utils.setLoreCost(new Shank(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(5, Utils.setLoreCost(new ScrapyardBow(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(6, Utils.setLoreCost(new WoodenBow(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(7, Utils.setLoreCost(new PebbleShooter(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(8, Utils.setLoreCost(new Club(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(9, Utils.setLoreCost(new GiantClub(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(10, Utils.setLoreCost(new FemurBone(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(11, Utils.setLoreCost(new LivingTwig(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(12, Utils.setLoreCost(new GlisteningTwig(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(13, Utils.setLoreCost(new GlowingTwig(Utils.randRarity()).getUpdatedItem(false)));
        shopWeapons.set(14, Utils.setLoreCost(new SlimeSpoofer(Utils.randRarity()).getUpdatedItem(false)));
    }

    private void setShopArmor() {
        shopArmor.set(0, Utils.setLoreCost(new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(1, Utils.setLoreCost(new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(2, Utils.setLoreCost(new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(3, Utils.setLoreCost(new SlimyBoots(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(4, Utils.setLoreCost(new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(5, Utils.setLoreCost(new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(6, Utils.setLoreCost(new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(7, Utils.setLoreCost(new MagmaBoots(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(8, Utils.setLoreCost(new WoolHelmet(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(9, Utils.setLoreCost(new WoolChestplate(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(10, Utils.setLoreCost(new WoolLeggings(Utils.randRarity()).getUpdatedItem(false)));
        shopArmor.set(11, Utils.setLoreCost(new WoolBoots(Utils.randRarity()).getUpdatedItem(false)));
    }

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

        gui.setItem(11, shopWeapons.get(0));
        gui.setItem(12, shopWeapons.get(1));
        gui.setItem(13, shopWeapons.get(2));
        gui.setItem(14, shopWeapons.get(3));
        gui.setItem(15, shopWeapons.get(4));
        gui.setItem(16, shopWeapons.get(5));
        gui.setItem(17, shopWeapons.get(6));


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

        gui.setItem(11, shopArmor.get(0));
        gui.setItem(12, shopArmor.get(1));
        gui.setItem(13, shopArmor.get(2));
        gui.setItem(14, shopArmor.get(3));
        gui.setItem(15, shopArmor.get(4));
        gui.setItem(16, shopArmor.get(5));
        gui.setItem(17, shopArmor.get(6));


        player.setMetadata("ShopArmor", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}