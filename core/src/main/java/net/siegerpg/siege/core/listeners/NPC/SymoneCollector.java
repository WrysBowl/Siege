package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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
import java.util.Objects;

public class SymoneCollector implements Listener {


    ArrayList<ItemStack> lightMeleeList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new Twig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A x2"),
                    Utils.lore("<gold>Given when you first"),
                    Utils.lore("<gold>join the server")));
            add(Utils.setOriginLore(new StickyStick(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x2")));
            add(Utils.setOriginLore(new Spade(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A x1")));
            add(Utils.setOriginLore(new Shovel(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A x1")));
            add(Utils.setOriginLore(new Shank(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit drop")));
            add(Utils.setOriginLore(new Dagger(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit drop")));
            add(Utils.setOriginLore(new WoodenSword(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Wild Fox drop")));
            add(Utils.setOriginLore(new ScrapShard(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new SplinteredBone(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A x2"),
                    Utils.lore("<yellow>Bandit drop")));
            add(Utils.setOriginLore(new RefinedDagger(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x1")));
        }
    };

    ArrayList<ItemStack> heavyMeleeList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new Club(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x3")));
            add(Utils.setOriginLore(new GiantClub(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Orc drop")));
            add(Utils.setOriginLore(new FemurBone(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new StoneAxe(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new DoubleBladedAxe(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Orc drop")));
            add(Utils.setOriginLore(new GreatSword(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1")));
            add(Utils.setOriginLore(new WarHammer(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x4"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new IronAxe(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Orc drop")));
            add(Utils.setOriginLore(new Clobber(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x5")));
            add(Utils.setOriginLore(new EarthernHammer(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3")));
        }
    };

    ArrayList<ItemStack> armorList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new SlimyChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A x8")));
            add(Utils.setOriginLore(new MagmaChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A x8")));
            add(Utils.setOriginLore(new WoolChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Wool \u272A\u272A x8")));
            add(Utils.setOriginLore(new BoneChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A x8")));
            add(Utils.setOriginLore(new ChainChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Chain \u272A\u272A x8")));
            add(Utils.setOriginLore(new IronChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x8")));
        }
    };

    ArrayList<ItemStack> wandsList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new LivingTwig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Spruce Log drop")));
            add(Utils.setOriginLore(new GlisteningTwig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A x1")));
            add(Utils.setOriginLore(new GlowingTwig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new SlimeSpoofer(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Prince Slimy drop")));
            add(Utils.setOriginLore(new RockWand(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new Torch(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new FlamingHotTorch(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1")));
            add(Utils.setOriginLore(new EarthernWand(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x1")));
            add(Utils.setOriginLore(new HotRod(50).getUpdatedItem(true),
                    Utils.lore("<yellow>UNOBTAINABLE")));
            add(Utils.setOriginLore(new EarthernStaff(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x1")));
        }
    };

    ArrayList<ItemStack> rangedList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new ScrapyardBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A x3")));
            add(Utils.setOriginLore(new WoodenBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new PebbleShooter(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new ReinforcedBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new SewerShooter(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new Crossbow(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit Archer drop")));
            add(Utils.setOriginLore(new RecurveBow(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit Archer drop")));
            add(Utils.setOriginLore(new IronBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new Trident(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Undead Pirate drop")));
            add(Utils.setOriginLore(new Bowba(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Crafting"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
        }
    };

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains(Utils.tacc("&6Symone"))) {
            e.getPlayer().openInventory(getMenu(e.getPlayer()));
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getWhoClicked().getMetadata("SymoneMenu").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneMenu").get(0).value(), e.getInventory())) {
            clickMenu(e);
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneLightMelee").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneLightMelee").get(0).value(), e.getInventory())) {
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneHeavyMelee").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneHeavyMelee").get(0).value(), e.getInventory())) {
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneArmor").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneArmor").get(0).value(), e.getInventory())) {
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneWand").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneWand").get(0).value(), e.getInventory())) {
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneRanged").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneRanged").get(0).value(), e.getInventory())) {
            e.setCancelled(true);
        }
    }

    private void clickMenu(InventoryClickEvent e) {
        int slot = e.getSlot();
        Player player = (Player) e.getWhoClicked();

        if (slot == 11) {
            player.openInventory(getLightMelee(player));
        } else if (slot == 12) {
            player.openInventory(getHeavyMelee(player));
        } else if (slot == 13) {
            player.openInventory(getArmor(player));
        } else if (slot == 14) {
            player.openInventory(getWand(player));
        } else if (slot == 15) {
            player.openInventory(getRanged(player));
        }
    }

    private Inventory getMenu(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Symone's Collection");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        //Creating Light Melee Icon
        ItemStack lightMelee = new ItemStack (Material.WOODEN_SWORD);
        ItemMeta lightMeleeMeta = lightMelee.getItemMeta();
        lightMeleeMeta.displayName(Utils.lore("<red>Light Melee"));
        lightMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        lightMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
        lightMelee.setItemMeta(lightMeleeMeta);

        //Creating Heavy Melee Icon
        ItemStack heavyMelee = new ItemStack (Material.WOODEN_AXE);
        ItemMeta heavyMeleeMeta = heavyMelee.getItemMeta();
        heavyMeleeMeta.displayName(Utils.lore("<dark_red>Heavy Melee"));
        heavyMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        heavyMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
        heavyMelee.setItemMeta(heavyMeleeMeta);

        //Creating Armor Icon
        ItemStack armor = new ItemStack (Material.IRON_CHESTPLATE);
        ItemMeta armorMeta = armor.getItemMeta();
        armorMeta.displayName(Utils.lore("<dark_aqua>Armor"));
        armorMeta.removeAttributeModifier(Attribute.GENERIC_ARMOR);
        armor.setItemMeta(armorMeta);

        //Creating Wand Icon
        ItemStack wand = new ItemStack (Material.WOODEN_HOE);
        ItemMeta wandMeta = wand.getItemMeta();
        wandMeta.displayName(Utils.lore("<dark_green>Wands"));
        wandMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
        wandMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
        wand.setItemMeta(wandMeta);

        //Creating Ranged Icon
        ItemStack ranged = new ItemStack (Material.BOW);
        ItemMeta rangedMeta = ranged.getItemMeta();
        rangedMeta.displayName(Utils.lore("<green>Ranged Weapons"));
        ranged.setItemMeta(rangedMeta);

        //This is where you decide what slot the item goes into
        gui.setItem(11, lightMelee);
        gui.setItem(12, heavyMelee);
        gui.setItem(13, armor);
        gui.setItem(14, wand);
        gui.setItem(15, ranged);

        player.setMetadata("SymoneMenu", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }



    private Inventory getLightMelee(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Light Melee Weapons");

        //Fill in the GUI
        for (int i = 0; i < lightMeleeList.size(); i++) {
            gui.setItem(i, lightMeleeList.get(i));
        }

        player.setMetadata("SymoneLightMelee", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
    private Inventory getHeavyMelee(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Heavy Melee Weapons");

        //Fill in the GUI
        for (int i = 0; i < heavyMeleeList.size(); i++) {
            gui.setItem(i, heavyMeleeList.get(i));
        }

        player.setMetadata("SymoneHeavyMelee", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
    private Inventory getArmor(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Armor Weapons");

        //Fill in the GUI
        for (int i = 0; i < armorList.size(); i++) {
            gui.setItem(i, armorList.get(i));
        }

        player.setMetadata("SymoneArmor", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
    private Inventory getWand(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Wand Weapons");

        //Fill in the GUI
        for (int i = 0; i < wandsList.size(); i++) {
            gui.setItem(i, wandsList.get(i));
        }

        player.setMetadata("SymoneWand", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
    private Inventory getRanged(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "Ranged Weapons");

        //Fill in the GUI
        for (int i = 0; i < rangedList.size(); i++) {
            gui.setItem(i, rangedList.get(i));
        }

        player.setMetadata("SymoneRanged", new FixedMetadataValue(Core.plugin(), gui));
        return gui;
    }
}
