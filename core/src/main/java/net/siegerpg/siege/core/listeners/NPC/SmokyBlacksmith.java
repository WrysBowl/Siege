package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.NPC;
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
import org.bukkit.metadata.MetadataValue;

import java.util.ArrayList;
import java.util.Objects;

public class SmokyBlacksmith implements Listener, Runnable {

    public static ArrayList<ItemStack> weaponItems = new ArrayList<>();
    public static ArrayList<ItemStack> shopWeapons = new ArrayList<>();
    public static ArrayList<ItemStack> armorItems = new ArrayList<>();
    public static ArrayList<ItemStack> shopArmor = new ArrayList<>();

    @Override
    public void run() {
    }

    public static void resetItems() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            setShopWeapons();
            setShopArmor();
            weaponItems.clear();
            armorItems.clear();
            for (int i = 0; i<7; i++) {
                weaponItems.add(shopWeapons.get((int) (Math.random() * 14)));
                armorItems.add(shopArmor.get((int) (Math.random() * 11)));
            }
            Bukkit.broadcastMessage(Utils.tacc("&aShop has reset!"));
        }, 0, 72000);
    }

    private static void setShopWeapons() {
        shopWeapons.clear();
        shopWeapons.add(0, Utils.setLoreCost(new Twig(Utils.randRarity())));
        shopWeapons.add(1, Utils.setLoreCost(new StickyStick(Utils.randRarity())));
        shopWeapons.add(2, Utils.setLoreCost(new Spade(Utils.randRarity())));
        shopWeapons.add(3, Utils.setLoreCost(new Shovel(Utils.randRarity())));
        shopWeapons.add(4, Utils.setLoreCost(new Shank(Utils.randRarity())));
        shopWeapons.add(5, Utils.setLoreCost(new ScrapyardBow(Utils.randRarity())));
        shopWeapons.add(6, Utils.setLoreCost(new WoodenBow(Utils.randRarity())));
        shopWeapons.add(7, Utils.setLoreCost(new PebbleShooter(Utils.randRarity())));
        shopWeapons.add(8, Utils.setLoreCost(new Club(Utils.randRarity())));
        shopWeapons.add(9, Utils.setLoreCost(new GiantClub(Utils.randRarity())));
        shopWeapons.add(10, Utils.setLoreCost(new FemurBone(Utils.randRarity())));
        shopWeapons.add(11, Utils.setLoreCost(new LivingTwig(Utils.randRarity())));
        shopWeapons.add(12, Utils.setLoreCost(new GlisteningTwig(Utils.randRarity())));
        shopWeapons.add(13, Utils.setLoreCost(new GlowingTwig(Utils.randRarity())));
        shopWeapons.add(14, Utils.setLoreCost(new SlimeSpoofer(Utils.randRarity())));
    }

    private static void setShopArmor() {
        shopArmor.clear();
        shopArmor.add(0, Utils.setLoreCost(new SlimyHelmet(Utils.randRarity())));
        shopArmor.add(1, Utils.setLoreCost(new SlimyChestplate(Utils.randRarity())));
        shopArmor.add(2, Utils.setLoreCost(new SlimyLeggings(Utils.randRarity())));
        shopArmor.add(3, Utils.setLoreCost(new SlimyBoots(Utils.randRarity())));
        shopArmor.add(4, Utils.setLoreCost(new MagmaHelmet(Utils.randRarity())));
        shopArmor.add(5, Utils.setLoreCost(new MagmaChestplate(Utils.randRarity())));
        shopArmor.add(6, Utils.setLoreCost(new MagmaLeggings(Utils.randRarity())));
        shopArmor.add(7, Utils.setLoreCost(new MagmaBoots(Utils.randRarity())));
        shopArmor.add(8, Utils.setLoreCost(new WoolHelmet(Utils.randRarity())));
        shopArmor.add(9, Utils.setLoreCost(new WoolChestplate(Utils.randRarity())));
        shopArmor.add(10, Utils.setLoreCost(new WoolLeggings(Utils.randRarity())));
        shopArmor.add(11, Utils.setLoreCost(new WoolBoots(Utils.randRarity())));
    }

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if ((e.getRightClicked() instanceof Player || e.getRightClicked() instanceof Villager) && e.getRightClicked().getName().equals(Utils.tacc("&6Smoky"))) {
            Inventory shop = getShopMenu(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("Shop").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("Shop").get(0).value(), e.getInventory())) {
            clickShopMenu(e);
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("ShopWeapons").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("ShopWeapons").get(0).value(), e.getInventory())) {
            clickShopWeapons(e);
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("ShopArmor").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("ShopArmor").get(0).value(), e.getInventory())) {
            clickShopArmor(e);
            e.setCancelled(true);
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
        if (slot > 9 && slot < 17 && e.getCurrentItem() != null) {
            int cost = Utils.getCost(e.getCurrentItem());
            if (VaultHook.econ.getBalance(player) >= cost) {
                if (!(e.getView().getBottomInventory().firstEmpty() == -1)) {
                    player.closeInventory();
                    player.getInventory().addItem(Utils.removeLastLore(e.getCurrentItem()));
                    VaultHook.econ.withdrawPlayer(player, cost);
                    Scoreboard.updateScoreboard((Player) e.getWhoClicked());
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
        if (slot > 9 && slot < 17 && e.getCurrentItem() != null) {
            int cost = Utils.getCost(e.getCurrentItem());
            if (VaultHook.econ.getBalance(player) >= cost) {
                if (!(e.getView().getBottomInventory().firstEmpty() == -1)) {
                    player.closeInventory();
                    player.getInventory().addItem(Utils.removeLastLore(e.getCurrentItem()));
                    VaultHook.econ.withdrawPlayer(player, cost);
                    Scoreboard.updateScoreboard((Player) e.getWhoClicked());
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
        weaponsMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        weaponsMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
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
        weaponsMeta.removeAttributeModifier(Attribute.GENERIC_ARMOR);
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

        gui.setItem(10, weaponItems.get(0));
        gui.setItem(11, weaponItems.get(1));
        gui.setItem(12, weaponItems.get(2));
        gui.setItem(13, weaponItems.get(3));
        gui.setItem(14, weaponItems.get(4));
        gui.setItem(15, weaponItems.get(5));
        gui.setItem(16, weaponItems.get(6));


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

        gui.setItem(10, armorItems.get(0));
        gui.setItem(11, armorItems.get(1));
        gui.setItem(12, armorItems.get(2));
        gui.setItem(13, armorItems.get(3));
        gui.setItem(14, armorItems.get(4));
        gui.setItem(15, armorItems.get(5));
        gui.setItem(16, armorItems.get(6));


        player.setMetadata("ShopArmor", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}