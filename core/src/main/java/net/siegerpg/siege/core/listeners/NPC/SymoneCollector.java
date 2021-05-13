package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.misc.wands.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class SymoneCollector implements Listener {


    ArrayList<ItemStack> lightMeleeList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new Twig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A x2"),
                    Utils.lore("<gold>Given when you first"),
                    Utils.lore("<gold>join the server")));
            add(Utils.setOriginLore(new StickyStick(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x2")));
            add(Utils.setOriginLore(new Spade(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A x1")));
            add(Utils.setOriginLore(new Shovel(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A x1")));
            add(Utils.setOriginLore(new Shank(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit drop")));
            add(Utils.setOriginLore(new Dagger(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit drop")));
            add(Utils.setOriginLore(new WoodenSword(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Wild Fox drop")));
            add(Utils.setOriginLore(new ScrapShard(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new SplinteredBone(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A x2"),
                    Utils.lore("<yellow>Bandit drop")));
            add(Utils.setOriginLore(new RefinedDagger(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x1")));
        }
    };

    ArrayList<ItemStack> heavyMeleeList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new Club(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x3")));
            add(Utils.setOriginLore(new GiantClub(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Orc drop")));
            add(Utils.setOriginLore(new FemurBone(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new StoneAxe(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new DoubleBladedAxe(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Orc drop")));
            add(Utils.setOriginLore(new GreatSword(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1")));
            add(Utils.setOriginLore(new WarHammer(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x4"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new IronAxe(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Orc drop")));
            add(Utils.setOriginLore(new Clobber(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x5")));
            add(Utils.setOriginLore(new EarthernHammer(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3")));
        }
    };

    ArrayList<ItemStack> armorList = new ArrayList<>(34){
        {
            add(Utils.setOriginLore(new SlimyHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A x5")));
            add(Utils.setOriginLore(new StrawHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A x5")));
            add(Utils.setOriginLore(new WoolHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Wool \u272A\u272A x5")));
            add(Utils.setOriginLore(new MagmaHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A x5")));
            add(Utils.setOriginLore(new LeatherHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Leather \u272A\u272A x5")));
            add(Utils.setOriginLore(new BoneHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A x5")));
            add(Utils.setOriginLore(new ChainHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Chain \u272A\u272A x5")));
            add(Utils.setOriginLore(new IronHelmet(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x5")));
            add(new ItemStack(Material.AIR));

            add(Utils.setOriginLore(new SlimyChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A x8")));
            add(Utils.setOriginLore(new StrawChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A x8")));
            add(Utils.setOriginLore(new WoolChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Wool \u272A\u272A x8")));
            add(Utils.setOriginLore(new MagmaChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A x8")));
            add(Utils.setOriginLore(new LeatherChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Leather \u272A\u272A x8")));
            add(Utils.setOriginLore(new BoneChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A x8")));
            add(Utils.setOriginLore(new ChainChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Chain \u272A\u272A x8")));
            add(Utils.setOriginLore(new IronChestplate(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x8")));
            add(new ItemStack(Material.AIR));

            add(Utils.setOriginLore(new SlimyLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A x7")));
            add(Utils.setOriginLore(new StrawLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A x7")));
            add(Utils.setOriginLore(new WoolLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Wool \u272A\u272A x7")));
            add(Utils.setOriginLore(new MagmaLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A x7")));
            add(Utils.setOriginLore(new LeatherLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Leather \u272A\u272A x7")));
            add(Utils.setOriginLore(new BoneLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A x7")));
            add(Utils.setOriginLore(new ChainLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Chain \u272A\u272A x7")));
            add(Utils.setOriginLore(new IronLeggings(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x7")));
            add(new ItemStack(Material.AIR));

            add(Utils.setOriginLore(new SlimyBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A x4")));
            add(Utils.setOriginLore(new StrawBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A x4")));
            add(Utils.setOriginLore(new WoolBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Wool \u272A\u272A x4")));
            add(Utils.setOriginLore(new MagmaBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A x4")));
            add(Utils.setOriginLore(new LeatherBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Leather \u272A\u272A x4")));
            add(Utils.setOriginLore(new BoneBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A x4")));
            add(Utils.setOriginLore(new ChainBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Chain \u272A\u272A x4")));
            add(Utils.setOriginLore(new IronBoots(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x4")));
            add(new ItemStack(Material.AIR));
        }
    };

    ArrayList<ItemStack> wandsList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new LivingTwig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Spruce Log drop")));
            add(Utils.setOriginLore(new GlisteningTwig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A x1")));
            add(Utils.setOriginLore(new GlowingTwig(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new SlimeSpoofer(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Prince Slimy drop")));
            add(Utils.setOriginLore(new RockWand(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new Torch(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")));
            add(Utils.setOriginLore(new FlamingHotTorch(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1")));
            add(Utils.setOriginLore(new EarthernWand(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x1")));
            add(Utils.setOriginLore(new HotRod(50).getUpdatedItem(true),
                    Utils.lore("<yellow>UNOBTAINABLE")));
            add(Utils.setOriginLore(new EarthernStaff(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x1")));
        }
    };

    ArrayList<ItemStack> rangedList = new ArrayList<>(){
        {
            add(Utils.setOriginLore(new ScrapyardBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A x3")));
            add(Utils.setOriginLore(new WoodenBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new PebbleShooter(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new ReinforcedBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new SewerShooter(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Slime \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new Crossbow(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit Archer drop")));
            add(Utils.setOriginLore(new RecurveBow(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Bandit Archer drop")));
            add(Utils.setOriginLore(new IronBow(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x3")));
            add(Utils.setOriginLore(new Trident(50).getUpdatedItem(true),
                    Utils.lore("<yellow>Undead Pirate drop")));
            add(Utils.setOriginLore(new Bowba(50).getUpdatedItem(true),
                    Utils.lore("<dark_aqua>Click to Craft"),
                    Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A\u272A x1"),
                    Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A\u272A x2"),
                    Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")));
        }
    };

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Symone") && e.getRightClicked() instanceof Villager) {
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
            clickLightMelee(e);
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneHeavyMelee").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneHeavyMelee").get(0).value(), e.getInventory())) {
            clickHeavyMelee(e);
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneArmor").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneArmor").get(0).value(), e.getInventory())) {
            clickArmor(e);
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneWand").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneWand").get(0).value(), e.getInventory())) {
            clickWand(e);
            e.setCancelled(true);
        } else if (e.getWhoClicked().getMetadata("SymoneRanged").size() > 0 &&
                Objects.equals(e.getWhoClicked().getMetadata("SymoneRanged").get(0).value(), e.getInventory())) {
            clickRanged(e);
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
    private void clickLightMelee(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ArrayList<ItemStack> reqIngredients = new ArrayList<>();
        ItemStack result = null;
        switch (e.getSlot()) {
            case 0: //Twig
                //Initialize Ingredients
                ItemStack twig1 = Stick.Companion.tier(1).getUpdatedItem(false);
                twig1.setAmount(2);

                //Add ingredients to required ingredients
                reqIngredients.add(twig1);
                //Set result of recipe
                result = new Twig(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 1: //Sticky Stick
                ItemStack stickyStick1 = Stick.Companion.tier(2).getUpdatedItem(false);
                stickyStick1.setAmount(2);
                ItemStack stickyStick2 = Slime.Companion.tier(2).getUpdatedItem(false);
                stickyStick2.setAmount(2);

                reqIngredients.add(stickyStick1);
                reqIngredients.add(stickyStick2);
                result = new StickyStick(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 2: //Spade
                ItemStack spade1 = Stick.Companion.tier(3).getUpdatedItem(false);
                spade1.setAmount(1);
                ItemStack spade2 = Pebble.Companion.tier(2).getUpdatedItem(false);
                spade2.setAmount(1);

                reqIngredients.add(spade1);
                reqIngredients.add(spade2);
                result = new Spade(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 3: //Shovel
                ItemStack shovel1 = Stick.Companion.tier(3).getUpdatedItem(false);
                shovel1.setAmount(2);
                ItemStack shovel2 = Pebble.Companion.tier(2).getUpdatedItem(false);
                shovel2.setAmount(1);

                reqIngredients.add(shovel1);
                reqIngredients.add(shovel2);
                result = new Shovel(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 7: //Scrap Shard
                ItemStack scrapShard1 = MetalScrap.Companion.tier(3).getUpdatedItem(false);
                scrapShard1.setAmount(2);

                reqIngredients.add(scrapShard1);
                result = new ScrapShard(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 8: //Splintered Bone
                ItemStack splinteredBone1 = Bone.Companion.tier(3).getUpdatedItem(false);
                splinteredBone1.setAmount(2);

                reqIngredients.add(splinteredBone1);
                result = new SplinteredBone(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 9: //Refined Dagger
                ItemStack refinedDagger1 = RefinedMetal.Companion.tier(3).getUpdatedItem(false);
                refinedDagger1.setAmount(1);
                ItemStack refinedDagger2 = Stick.Companion.tier(3).getUpdatedItem(false);
                refinedDagger2.setAmount(1);

                reqIngredients.add(refinedDagger1);
                reqIngredients.add(refinedDagger2);
                result = new RefinedDagger(Utils.randRarity()).getUpdatedItem(false);
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
        for (ItemStack item : reqIngredients) {
            player.getInventory().removeItem(item);
        }
        player.updateInventory();
        if (!(e.getView().getBottomInventory().firstEmpty() == -1)) {
            player.getInventory().addItem(result);
            return;
        }
        player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
    }
    private void clickHeavyMelee(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ArrayList<ItemStack> reqIngredients = new ArrayList<>();
        ItemStack result = null;
        switch (e.getSlot()) {
            case 0: //Club
                //Initialize Ingredients
                ItemStack club1 = Stick.Companion.tier(2).getUpdatedItem(false);
                club1.setAmount(2);

                //Add ingredients to required ingredients
                reqIngredients.add(club1);
                //Set result of recipe
                result = new Club(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 2: //Femur Bone
                ItemStack femurBone1 = Stick.Companion.tier(3).getUpdatedItem(false);
                femurBone1.setAmount(3);

                reqIngredients.add(femurBone1);
                result = new StickyStick(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 3: //Stone Axe
                ItemStack stoneAxe1 = Stick.Companion.tier(3).getUpdatedItem(false);
                stoneAxe1.setAmount(2);
                ItemStack stoneAxe2 = Pebble.Companion.tier(3).getUpdatedItem(false);
                stoneAxe2.setAmount(3);

                reqIngredients.add(stoneAxe1);
                reqIngredients.add(stoneAxe2);
                result = new StoneAxe(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 5: //Great Sword
                ItemStack greatSword1 = MetalScrap.Companion.tier(3).getUpdatedItem(false);
                greatSword1.setAmount(2);
                ItemStack greatSword2 = Stick.Companion.tier(3).getUpdatedItem(false);
                greatSword2.setAmount(1);

                reqIngredients.add(greatSword1);
                reqIngredients.add(greatSword2);
                result = new GreatSword(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 6: //War Hammer
                ItemStack warHammer1 = MetalScrap.Companion.tier(3).getUpdatedItem(false);
                warHammer1.setAmount(1);
                ItemStack warHammer2 = Pebble.Companion.tier(3).getUpdatedItem(false);
                warHammer2.setAmount(4);
                ItemStack warHammer3 = Stick.Companion.tier(3).getUpdatedItem(false);
                warHammer3.setAmount(2);

                reqIngredients.add(warHammer1);
                reqIngredients.add(warHammer2);
                reqIngredients.add(warHammer3);
                result = new WarHammer(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 8: //Clobber
                ItemStack clobber1 = RefinedMetal.Companion.tier(3).getUpdatedItem(false);
                clobber1.setAmount(5);

                reqIngredients.add(clobber1);
                result = new Clobber(Utils.randRarity()).getUpdatedItem(false);
                break;
            case 9: //Earthern Hammer
                ItemStack earthernHammer1 = PlantMatter.Companion.tier(4).getUpdatedItem(false);
                earthernHammer1.setAmount(2);
                ItemStack earthernHammer2 = Stick.Companion.tier(3).getUpdatedItem(false);
                earthernHammer2.setAmount(3);

                reqIngredients.add(earthernHammer1);
                reqIngredients.add(earthernHammer2);
                result = new EarthernHammer(Utils.randRarity()).getUpdatedItem(false);
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
        for (ItemStack item : reqIngredients) {
            player.getInventory().removeItem(item);
        }
        player.updateInventory();
        if (!(e.getView().getBottomInventory().firstEmpty() == -1)) {
            player.getInventory().addItem(result);
            return;
        }
        player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
    }
    private void clickArmor(InventoryClickEvent e) {
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
    private void clickWand(InventoryClickEvent e) {
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
    private void clickRanged(InventoryClickEvent e) {
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
        Inventory gui = Bukkit.createInventory(null, 54, "Armor Weapons");

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
