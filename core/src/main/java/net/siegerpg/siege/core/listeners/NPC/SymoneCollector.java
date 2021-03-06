package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.implemented.armor.boots.*;
import net.siegerpg.siege.core.items.implemented.armor.chestplate.*;
import net.siegerpg.siege.core.items.implemented.armor.helmet.*;
import net.siegerpg.siege.core.items.implemented.armor.leggings.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.*;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.*;
import net.siegerpg.siege.core.items.implemented.weapons.ranged.*;
import net.siegerpg.siege.core.items.implemented.weapons.wands.*;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
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


	ArrayList< ItemStack > lightMeleeList = new ArrayList<>() {
		{
			add(Utils.addLore(
					new Twig(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A x2"),
					Utils.lore("<gold>Given when you first"),
					Utils.lore("<gold>join the server")
			                 ));
			add(Utils.addLore(
					new StickyStick(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A x2"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A x2")
			                 ));
			add(Utils.addLore(
					new Spade(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A x1")
			                 ));
			add(Utils.addLore(
					new Shovel(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A x1")
			                 ));
			add(Utils.addLore(
					new Shank(50).getUpdatedItem(false),
					Utils.lore("<yellow>Bandit drop")
			                 ));
			add(Utils.addLore(
					new Dagger(50).getUpdatedItem(false),
					Utils.lore("<yellow>Bandit drop")
			                 ));
			add(Utils.addLore(
					new WoodenSword(50).getUpdatedItem(false),
					Utils.lore("<yellow>Wild Fox drop")
			                 ));
			add(Utils.addLore(
					new ScrapShard(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x2")
			                 ));
			add(Utils.addLore(
					new SplinteredBone(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A x2"),
					Utils.lore("<yellow>Bandit drop")
			                 ));
			add(Utils.addLore(
					new RefinedDagger(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x1")
			                 ));
		}
	};
	ArrayList< ItemStack > heavyMeleeList = new ArrayList<>() {
		{
			add(Utils.addLore(
					new Club(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new GiantClub(50).getUpdatedItem(false),
					Utils.lore("<yellow>Orc drop")
			                 ));
			add(Utils.addLore(
					new FemurBone(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new StoneAxe(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x3"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")
			                 ));
			add(Utils.addLore(
					new DoubleBladedAxe(50).getUpdatedItem(false),
					Utils.lore("<yellow>Orc drop")
			                 ));
			add(Utils.addLore(
					new GreatSword(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1")
			                 ));
			add(Utils.addLore(
					new WarHammer(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x4"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")
			                 ));
			add(Utils.addLore(
					new IronAxe(50).getUpdatedItem(false),
					Utils.lore("<yellow>Orc drop")
			                 ));
			add(Utils.addLore(
					new Clobber(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new EarthernHammer(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3")
			                 ));
		}
	};
	ArrayList< ItemStack > armorList = new ArrayList<>() {
		{
			add(Utils.addLore(
					new SlimyHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new StrawHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new WoolHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new MagmaHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new LeatherHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new BoneHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new ChainHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A\u272A x5")
			                 ));
			add(Utils.addLore(
					new IronHelmet(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x5")
			                 ));
			add(new ItemStack(Material.AIR));

			add(Utils.addLore(
					new SlimyChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					new StrawChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					new WoolChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					new MagmaChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					new LeatherChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					new BoneChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					new ChainChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					new IronChestplate(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.AIR));

			add(Utils.addLore(
					new SlimyLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A x7")
			                 ));
			add(Utils.addLore(
					new StrawLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A\u272A x7")
			                 ));
			add(Utils.addLore(
					new WoolLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A\u272A x7")
			                 ));
			add(Utils.addLore(
					new MagmaLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A x7")
			                 ));
			add(Utils.addLore(
					new LeatherLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A\u272A x7")
			                 ));
			add(Utils.addLore(
					new BoneLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A x7")
			                 ));
			add(Utils.addLore(
					new ChainLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A\u272A x7")
			                 ));
			add(Utils.addLore(
					new IronLeggings(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x7")
			                 ));
			add(new ItemStack(Material.AIR));

			add(Utils.addLore(
					new SlimyBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A x4")
			                 ));
			add(Utils.addLore(
					new StrawBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A\u272A x4")
			                 ));
			add(Utils.addLore(
					new WoolBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A\u272A x4")
			                 ));
			add(Utils.addLore(
					new MagmaBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A x4")
			                 ));
			add(Utils.addLore(
					new LeatherBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A\u272A x4")
			                 ));
			add(Utils.addLore(
					new BoneBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A x4")
			                 ));
			add(Utils.addLore(
					new ChainBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A\u272A x4")
			                 ));
			add(Utils.addLore(
					new IronBoots(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x4")
			                 ));
			add(new ItemStack(Material.AIR));
		}
	};
	ArrayList< ItemStack > mobDropsList = new ArrayList<>() {
		{
			add(Utils.addLore(
					Slime.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A x8")
			                 ));
			add(Utils.addLore(
					Slime.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Slime.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Slime.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					Magma.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A x8")
			                 ));
			add(Utils.addLore(
					Magma.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Magma.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Magma.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A\u272A x8")
			                 ));

			add(Utils.addLore(
					Ectoplasm.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Ectoplasm \u272A x8")
			                 ));
			add(Utils.addLore(
					Ectoplasm.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Ectoplasm \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Ectoplasm.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Ectoplasm \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Ectoplasm.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Ectoplasm \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					Bone.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A x8")
			                 ));
			add(Utils.addLore(
					Bone.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Bone.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Bone.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A\u272A x8")
			                 ));

			add(Utils.addLore(
					Wool.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A x8")
			                 ));
			add(Utils.addLore(
					Wool.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Wool.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Wool.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wool \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					Leather.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A x8")
			                 ));
			add(Utils.addLore(
					Leather.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Leather.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Leather.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Leather \u272A\u272A\u272A\u272A x8")
			                 ));

			add(Utils.addLore(
					Feather.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Feather \u272A x8")
			                 ));
			add(Utils.addLore(
					Feather.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Feather \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Feather.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Ectoplasm \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Feather.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Feather \u272A\u272A\u272A\u272A x8")
			                 ));
		}
	};
	ArrayList< ItemStack > blockDropsList = new ArrayList<>() {
		{
			add(Utils.addLore(
					PlantMatter.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Plant Matter \u272A x8")
			                 ));
			add(Utils.addLore(
					PlantMatter.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					PlantMatter.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					PlantMatter.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					Seed.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Seed \u272A x8")
			                 ));
			add(Utils.addLore(
					Seed.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Seed \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Seed.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Seed.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A\u272A x8")
			                 ));

			add(Utils.addLore(
					Coal.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Coal \u272A x8")
			                 ));
			add(Utils.addLore(
					Coal.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Coal \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Coal.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Coal.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					Vine.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Vine \u272A x8")
			                 ));
			add(Utils.addLore(
					Vine.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Vine.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Vine.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A\u272A x8")
			                 ));

			add(Utils.addLore(
					Stick.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A x8")
			                 ));
			add(Utils.addLore(
					Stick.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Stick.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Stick.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					Pebble.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Pebble \u272A x8")
			                 ));
			add(Utils.addLore(
					Pebble.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Pebble.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Pebble.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A\u272A x8")
			                 ));

			add(Utils.addLore(
					Chain.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A x8")
			                 ));
			add(Utils.addLore(
					Chain.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Chain.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Chain.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Chain \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					MetalScrap.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A x8")
			                 ));
			add(Utils.addLore(
					MetalScrap.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					MetalScrap.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					MetalScrap.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A\u272A\u272A\u272A x8")
			                 ));

			add(Utils.addLore(
					RefinedMetal.Companion
							.tier(1)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Metal Scrap \u272A x9")
			                 ));
			add(Utils.addLore(
					RefinedMetal.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A x8")
			                 ));
			add(Utils.addLore(
					RefinedMetal.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					RefinedMetal.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					RefinedMetal.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A\u272A x8")
			                 ));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
			add(Utils.addLore(
					Wheat.Companion
							.tier(2)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A x8")
			                 ));
			add(Utils.addLore(
					Wheat.Companion
							.tier(3)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Wheat.Companion
							.tier(4)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A\u272A\u272A x8")
			                 ));
			add(Utils.addLore(
					Wheat.Companion
							.tier(5)
							.getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Wheat \u272A\u272A\u272A\u272A x8")
			                 ));
		}
	};
	ArrayList< ItemStack > miscList = new ArrayList<>();
	ArrayList< ItemStack > wandsList = new ArrayList<>() {
		{
			add(Utils.addLore(
					new LivingTwig(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Spruce Log drop")
			                 ));
			add(Utils.addLore(
					new GlisteningTwig(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Seed \u272A\u272A x1"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A x1"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A x1")
			                 ));
			add(Utils.addLore(
					new GlowingTwig(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new SlimeSpoofer(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Prince Slimy drop")
			                 ));
			add(Utils.addLore(
					new RockWand(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")
			                 ));
			add(Utils.addLore(
					new Torch(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2")
			                 ));
			add(Utils.addLore(
					new FlamingHotTorch(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x1")
			                 ));
			add(Utils.addLore(
					new EarthernWand(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x1")
			                 ));
			add(Utils.addLore(
					new HotRod(50).getUpdatedItem(false),
					Utils.lore("<yellow>UNOBTAINABLE")
			                 ));
			add(Utils.addLore(
					new EarthernStaff(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Coal \u272A\u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Seed \u272A\u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Plant Matter \u272A\u272A\u272A x1")
			                 ));
		}
	};
	ArrayList< ItemStack > rangedList = new ArrayList<>() {
		{
			add(Utils.addLore(
					new ScrapyardBow(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A x3"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new WoodenBow(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new PebbleShooter(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Pebble \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new ReinforcedBow(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new SewerShooter(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Slime \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Magma \u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Stick \u272A\u272A\u272A x3"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new Crossbow(50).getUpdatedItem(false),
					Utils.lore("<yellow>Bandit Archer drop")
			                 ));
			add(Utils.addLore(
					new RecurveBow(50).getUpdatedItem(false),
					Utils.lore("<yellow>Bandit Archer drop")
			                 ));
			add(Utils.addLore(
					new IronBow(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A x3")
			                 ));
			add(Utils.addLore(
					new Trident(50).getUpdatedItem(false),
					Utils.lore("<yellow>Undead Pirate drop")
			                 ));
			add(Utils.addLore(
					new Bowba(50).getUpdatedItem(false),
					Utils.lore("<dark_aqua>Click to Craft"),
					Utils.lore("<dark_aqua>Bone \u272A\u272A\u272A\u272A x1"),
					Utils.lore("<dark_aqua>Refined Metal \u272A\u272A\u272A\u272A x2"),
					Utils.lore("<dark_aqua>Vine \u272A\u272A\u272A x3")
			                 ));
		}
	};

	@EventHandler
	public void onRightClickOnEntity(PlayerInteractEntityEvent e) {

		if (e
				    .getRightClicked()
				    .getName()
				    .contains("Symone") && e
				    .getRightClicked()
				    .getName()
				    .contains("6")) {
			e
					.getPlayer()
					.openInventory(getMenu(e.getPlayer()));
		}
	}

	@EventHandler
	public void guiClick(InventoryClickEvent e) {

		if (!(e.getWhoClicked() instanceof Player)) {
			return;
		}
		if (e
				    .getWhoClicked()
				    .getMetadata("SymoneMenu")
				    .size() > 0 &&
		    Objects.equals(e
				                   .getWhoClicked()
				                   .getMetadata("SymoneMenu")
				                   .get(0)
				                   .value(), e.getInventory())) {
			clickMenu(e);
			e.setCancelled(true);

		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneLightMelee")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneLightMelee")
				                          .get(0)
				                          .value(), e.getInventory())) {
			clickLightMelee(e);
			e.setCancelled(true);
		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneHeavyMelee")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneHeavyMelee")
				                          .get(0)
				                          .value(), e.getInventory())) {
			clickHeavyMelee(e);
			e.setCancelled(true);
		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneArmor")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneArmor")
				                          .get(0)
				                          .value(), e.getInventory())) {
			clickArmor(e);
			e.setCancelled(true);
		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneMobDrops")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneMobDrops")
				                          .get(0)
				                          .value(), e.getInventory())) {
			clickMobDrops(e);
			e.setCancelled(true);
		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneMisc")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneMisc")
				                          .get(0)
				                          .value(), e.getInventory())) {
			clickMisc(e);
			e.setCancelled(true);
		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneBlockDrops")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneBlockDrops")
				                          .get(0)
				                          .value(), e.getInventory())) {
			clickBlockDrops(e);
			e.setCancelled(true);
		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneWand")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneWand")
				                          .get(0)
				                          .value(), e.getInventory())) {
			clickWand(e);
			e.setCancelled(true);
		} else if (e
				           .getWhoClicked()
				           .getMetadata("SymoneRanged")
				           .size() > 0 &&
		           Objects.equals(e
				                          .getWhoClicked()
				                          .getMetadata("SymoneRanged")
				                          .get(0)
				                          .value(), e.getInventory())) {
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
		} else if (slot == 21) {
			player.openInventory(mobDropsList(player));
		} else if (slot == 22) {
			player.openInventory(miscList(player));
		} else if (slot == 23) {
			player.openInventory(blockDropsList(player));
		}
	}

	private void clickLightMelee(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		ArrayList< ItemStack > reqIngredients = new ArrayList<>();
		ItemStack result = null;
		switch (e.getSlot()) {
			case 0: //Twig
				//Initialize Ingredients
				ItemStack twig1 = Stick.Companion
						.tier(1)
						.getUpdatedItem(false);
				twig1.setAmount(2);

				//Add ingredients to required ingredients
				reqIngredients.add(twig1);
				//Set result of recipe
				result = new Twig(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 1: //Sticky Stick
				ItemStack stickyStick1 = Stick.Companion
						.tier(2)
						.getUpdatedItem(false);
				stickyStick1.setAmount(2);
				ItemStack stickyStick2 = Slime.Companion
						.tier(2)
						.getUpdatedItem(false);
				stickyStick2.setAmount(2);

				reqIngredients.add(stickyStick1);
				reqIngredients.add(stickyStick2);
				result = new StickyStick(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 2: //Spade
				ItemStack spade1 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				spade1.setAmount(1);
				ItemStack spade2 = Pebble.Companion
						.tier(2)
						.getUpdatedItem(false);
				spade2.setAmount(1);

				reqIngredients.add(spade1);
				reqIngredients.add(spade2);
				result = new Spade(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 3: //Shovel
				ItemStack shovel1 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				shovel1.setAmount(2);
				ItemStack shovel2 = Pebble.Companion
						.tier(2)
						.getUpdatedItem(false);
				shovel2.setAmount(1);

				reqIngredients.add(shovel1);
				reqIngredients.add(shovel2);
				result = new Shovel(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 7: //Scrap Shard
				ItemStack scrapShard1 = MetalScrap.Companion
						.tier(3)
						.getUpdatedItem(false);
				scrapShard1.setAmount(2);

				reqIngredients.add(scrapShard1);
				result = new ScrapShard(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 8: //Splintered Bone
				ItemStack splinteredBone1 = Bone.Companion
						.tier(3)
						.getUpdatedItem(false);
				splinteredBone1.setAmount(2);

				reqIngredients.add(splinteredBone1);
				result = new SplinteredBone(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 9: //Refined Dagger
				ItemStack refinedDagger1 = RefinedMetal.Companion
						.tier(3)
						.getUpdatedItem(false);
				refinedDagger1.setAmount(1);
				ItemStack refinedDagger2 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				refinedDagger2.setAmount(1);

				reqIngredients.add(refinedDagger1);
				reqIngredients.add(refinedDagger2);
				result = new RefinedDagger(Utils.randRarity()).getUpdatedItem(false);
				break;
			default:
				return;
		}
		for (ItemStack item : reqIngredients) {
			if (!player
					.getInventory()
					.containsAtLeast(item, item.getAmount())) {
				player.sendMessage(Utils.parse(
						"<red>You do not have the required materials to craft this item."));
				return;
			}
		}

		if (!(
				e
						.getView()
						.getBottomInventory()
						.firstEmpty() == -1
		)) {
			for (ItemStack item : reqIngredients) {
				player
						.getInventory()
						.removeItem(item);
			}
			player.updateInventory();
			player
					.getInventory()
					.addItem(result);
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
			return;
		}
		player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
	}

	private void clickHeavyMelee(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		ArrayList< ItemStack > reqIngredients = new ArrayList<>();
		ItemStack result = null;
		switch (e.getSlot()) {
			case 0: //Club
				//Initialize Ingredients
				ItemStack club1 = Stick.Companion
						.tier(2)
						.getUpdatedItem(false);
				club1.setAmount(2);

				//Add ingredients to required ingredients
				reqIngredients.add(club1);
				//Set result of recipe
				result = new Club(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 2: //Femur Bone
				ItemStack femurBone1 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				femurBone1.setAmount(3);

				reqIngredients.add(femurBone1);
				result = new StickyStick(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 3: //Stone Axe
				ItemStack stoneAxe1 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				stoneAxe1.setAmount(2);
				ItemStack stoneAxe2 = Pebble.Companion
						.tier(3)
						.getUpdatedItem(false);
				stoneAxe2.setAmount(3);

				reqIngredients.add(stoneAxe1);
				reqIngredients.add(stoneAxe2);
				result = new StoneAxe(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 5: //Great Sword
				ItemStack greatSword1 = MetalScrap.Companion
						.tier(3)
						.getUpdatedItem(false);
				greatSword1.setAmount(2);
				ItemStack greatSword2 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				greatSword2.setAmount(1);

				reqIngredients.add(greatSword1);
				reqIngredients.add(greatSword2);
				result = new GreatSword(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 6: //War Hammer
				ItemStack warHammer1 = MetalScrap.Companion
						.tier(3)
						.getUpdatedItem(false);
				warHammer1.setAmount(1);
				ItemStack warHammer2 = Pebble.Companion
						.tier(3)
						.getUpdatedItem(false);
				warHammer2.setAmount(4);
				ItemStack warHammer3 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				warHammer3.setAmount(2);

				reqIngredients.add(warHammer1);
				reqIngredients.add(warHammer2);
				reqIngredients.add(warHammer3);
				result = new WarHammer(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 8: //Clobber
				ItemStack clobber1 = RefinedMetal.Companion
						.tier(3)
						.getUpdatedItem(false);
				clobber1.setAmount(5);

				reqIngredients.add(clobber1);
				result = new Clobber(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 9: //Earthern Hammer
				ItemStack earthernHammer1 = PlantMatter.Companion
						.tier(4)
						.getUpdatedItem(false);
				earthernHammer1.setAmount(2);
				ItemStack earthernHammer2 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				earthernHammer2.setAmount(3);

				reqIngredients.add(earthernHammer1);
				reqIngredients.add(earthernHammer2);
				result = new EarthernHammer(Utils.randRarity()).getUpdatedItem(false);
				break;
			default:
				return;
		}
		for (ItemStack item : reqIngredients) {
			if (!player
					.getInventory()
					.containsAtLeast(item, item.getAmount())) {
				player.sendMessage(Utils.parse(
						"<red>You do not have the required materials to craft this item."));
				return;
			}
		}
		if (!(
				e
						.getView()
						.getBottomInventory()
						.firstEmpty() == -1
		)) {
			for (ItemStack item : reqIngredients) {
				player
						.getInventory()
						.removeItem(item);
			}
			player.updateInventory();
			player
					.getInventory()
					.addItem(result);
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
			return;
		}
		player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
	}

	private void clickArmor(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		ArrayList< ItemStack > reqIngredients = new ArrayList<>();
		ItemStack result = null;
		ItemStack ing1 = null;
		switch (e.getSlot()) {
			case 0: //Slimy Helmet
				//Initialize Ingredients
				ing1 = Slime.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new SlimyHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 1: //Straw Hat
				//Initialize Ingredients
				ing1 = Wheat.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new StrawHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 2: //Wool Helmet
				//Initialize Ingredients
				ing1 = Wool.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new WoolHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 3: //Magma Helmet
				//Initialize Ingredients
				ing1 = Magma.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new MagmaHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 4: //Hardened Leather Helmet
				//Initialize Ingredients
				ing1 = Leather.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new LeatherHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 5: //Bone Helmet
				//Initialize Ingredients
				ing1 = Bone.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new BoneHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 6: //Chain Helmet
				//Initialize Ingredients
				ing1 = Chain.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new ChainHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 7: //Iron Helmet
				//Initialize Ingredients
				ing1 = RefinedMetal.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(5);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new IronHelmet(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 9: //Slimy Chestplate
				//Initialize Ingredients
				ing1 = Slime.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new SlimyChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 10: //Straw Chestplate
				//Initialize Ingredients
				ing1 = Wheat.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new StrawChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 11: //Wool Chestplate
				//Initialize Ingredients
				ing1 = Wool.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new WoolChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 12: //Magma Chestplate
				//Initialize Ingredients
				ing1 = Magma.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new MagmaChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 13: //Hardened Leather Chestplate
				//Initialize Ingredients
				ing1 = Leather.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new LeatherChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 14: //Bone Chestplate
				//Initialize Ingredients
				ing1 = Bone.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new BoneChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 15: //Chain Chestplate
				//Initialize Ingredients
				ing1 = Chain.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new ChainChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 16: //Iron Chestplate
				//Initialize Ingredients
				ing1 = RefinedMetal.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(8);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new IronChestplate(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 18: //Slimy Leggings
				//Initialize Ingredients
				ing1 = Slime.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new SlimyLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 19: //Straw Leggings
				//Initialize Ingredients
				ing1 = Wheat.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new StrawLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 20: //Wool Leggings
				//Initialize Ingredients
				ing1 = Wool.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new WoolLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 21: //Magma Leggings
				//Initialize Ingredients
				ing1 = Magma.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new MagmaLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 22: //Hardened Leather Leggings
				//Initialize Ingredients
				ing1 = Leather.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new LeatherLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 23: //Bone Leggings
				//Initialize Ingredients
				ing1 = Bone.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new BoneLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 24: //Chain Leggings
				//Initialize Ingredients
				ing1 = Chain.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new ChainLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 25: //Iron Leggings
				//Initialize Ingredients
				ing1 = RefinedMetal.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(7);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new IronLeggings(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 27: //Slimy Boots
				//Initialize Ingredients
				ing1 = Slime.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new SlimyBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 28: //Straw Boots
				//Initialize Ingredients
				ing1 = Wheat.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new StrawBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 29: //Wool Boots
				//Initialize Ingredients
				ing1 = Wool.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new WoolBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 30: //Magma Boots
				//Initialize Ingredients
				ing1 = Magma.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new MagmaBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 31: //Hardened Leather Boots
				//Initialize Ingredients
				ing1 = Leather.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new LeatherBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 32: //Bone Boots
				//Initialize Ingredients
				ing1 = Bone.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new BoneBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 33: //Chain Boots
				//Initialize Ingredients
				ing1 = Chain.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new ChainBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 34: //Iron Boots
				//Initialize Ingredients
				ing1 = RefinedMetal.Companion
						.tier(2)
						.getUpdatedItem(false);
				ing1.setAmount(4);

				//Add ingredients to required ingredients
				reqIngredients.add(ing1);
				//Set result of recipe
				result = new IronBoots(Utils.randRarity()).getUpdatedItem(false);
				break;

			default:
				return;
		}
		for (ItemStack item : reqIngredients) {
			if (!player
					.getInventory()
					.containsAtLeast(item, item.getAmount())) {
				player.sendMessage(Utils.parse(
						"<red>You do not have the required materials to craft this item."));
				return;
			}
		}
		if (!(
				e
						.getView()
						.getBottomInventory()
						.firstEmpty() == -1
		)) {
			for (ItemStack item : reqIngredients) {
				player
						.getInventory()
						.removeItem(item);
			}
			player.updateInventory();
			player
					.getInventory()
					.addItem(result);
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
			return;
		}
		player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
	}

	private void clickWand(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		ArrayList< ItemStack > reqIngredients = new ArrayList<>();
		ItemStack result = null;
		switch (e.getSlot()) {
			case 1: //Glistening twig

				//Initialize Ingredients
				ItemStack GlisteningTwig1 = Seed.Companion
						.tier(2)
						.getUpdatedItem(false);
				GlisteningTwig1.setAmount(1);
				ItemStack GlisteningTwig2 = Stick.Companion
						.tier(2)
						.getUpdatedItem(false);
				GlisteningTwig2.setAmount(1);
				ItemStack GlisteningTwig3 = PlantMatter.Companion
						.tier(2)
						.getUpdatedItem(false);
				GlisteningTwig3.setAmount(1);

				//Add ingredients to required ingredients
				reqIngredients.add(GlisteningTwig1);
				reqIngredients.add(GlisteningTwig2);
				reqIngredients.add(GlisteningTwig3);
				//Set result of recipe

				result = new GlisteningTwig(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 2: //Glowing Twig

				ItemStack GlowingTwig1 = PlantMatter.Companion
						.tier(3)
						.getUpdatedItem(false);
				GlowingTwig1.setAmount(3);

				reqIngredients.add(GlowingTwig1);

				result = new GlowingTwig(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 4: //Rock wand

				ItemStack RockWand1 = Pebble.Companion
						.tier(3)
						.getUpdatedItem(false);
				RockWand1.setAmount(1);
				ItemStack RockWand2 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				RockWand2.setAmount(2);

				reqIngredients.add(RockWand1);
				reqIngredients.add(RockWand2);

				result = new RockWand(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 5: //Torch

				ItemStack Torch1 = Magma.Companion
						.tier(3)
						.getUpdatedItem(false);
				Torch1.setAmount(1);
				ItemStack Torch2 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				Torch2.setAmount(2);

				reqIngredients.add(Torch1);
				reqIngredients.add(Torch2);

				result = new Torch(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 6: //Flaming Hot Torch

				ItemStack FlamingHotTorch1 = Magma.Companion
						.tier(4)
						.getUpdatedItem(false);
				FlamingHotTorch1.setAmount(1);
				ItemStack FlamingHotTorch2 = Seed.Companion
						.tier(4)
						.getUpdatedItem(false);
				FlamingHotTorch2.setAmount(1);
				ItemStack FlamingHotTorch3 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				FlamingHotTorch3.setAmount(1);

				reqIngredients.add(FlamingHotTorch1);
				reqIngredients.add(FlamingHotTorch2);
				reqIngredients.add(FlamingHotTorch3);

				result = new FlamingHotTorch(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 8: //Earthen Wand

				ItemStack EarthernWand1 = PlantMatter.Companion
						.tier(3)
						.getUpdatedItem(false);
				EarthernWand1.setAmount(1);
				ItemStack EarthernWand2 = Seed.Companion
						.tier(3)
						.getUpdatedItem(false);
				EarthernWand2.setAmount(2);
				ItemStack EarthernWand3 = Coal.Companion
						.tier(3)
						.getUpdatedItem(false);
				EarthernWand3.setAmount(2);

				reqIngredients.add(EarthernWand1);
				reqIngredients.add(EarthernWand2);
				reqIngredients.add(EarthernWand3);

				result = new EarthernWand(Utils.randRarity()).getUpdatedItem(false);
				break;

			case 9: //Earthern Staff

				ItemStack EarthernStaff1 = PlantMatter.Companion
						.tier(3)
						.getUpdatedItem(false);
				EarthernStaff1.setAmount(1);
				ItemStack EarthernStaff2 = Seed.Companion
						.tier(4)
						.getUpdatedItem(false);
				EarthernStaff2.setAmount(2);
				ItemStack EarthernStaff3 = Coal.Companion
						.tier(4)
						.getUpdatedItem(false);
				EarthernStaff3.setAmount(2);

				reqIngredients.add(EarthernStaff1);
				reqIngredients.add(EarthernStaff2);
				reqIngredients.add(EarthernStaff3);

				result = new EarthernStaff(Utils.randRarity()).getUpdatedItem(false);
				break;

			default:
				return;
		}
		for (ItemStack item : reqIngredients) {
			if (!player
					.getInventory()
					.containsAtLeast(item, item.getAmount())) {
				player.sendMessage(Utils.parse(
						"<red>You do not have the required materials to craft this item."));
				return;
			}
		}
		if (!(
				e
						.getView()
						.getBottomInventory()
						.firstEmpty() == -1
		)) {
			for (ItemStack item : reqIngredients) {
				player
						.getInventory()
						.removeItem(item);
			}
			player.updateInventory();
			player
					.getInventory()
					.addItem(result);
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
			return;
		}
		player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
	}

	private void clickRanged(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		ArrayList< ItemStack > reqIngredients = new ArrayList<>();
		ItemStack result = null;
		switch (e.getSlot()) {
			case 0: //Scrap yard bow
				//Initialize Ingredients
				ItemStack scrapyawrdbow1 = Stick.Companion
						.tier(2)
						.getUpdatedItem(false);
				scrapyawrdbow1.setAmount(3);
				ItemStack scrapyawrdbow2 = Stick.Companion
						.tier(2)
						.getUpdatedItem(false);
				scrapyawrdbow2.setAmount(3);

				//Add ingredients to required ingredients
				reqIngredients.add(scrapyawrdbow1);
				reqIngredients.add(scrapyawrdbow2);
				//Set result of recipe
				result = new ScrapyardBow(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 1: //Wooden Bow
				ItemStack woodenBow1 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				woodenBow1.setAmount(3);
				ItemStack woodenBow2 = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				woodenBow2.setAmount(3);

				reqIngredients.add(woodenBow1);
				reqIngredients.add(woodenBow2);
				result = new WoodenBow(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 2: //Pebble Shooter
				ItemStack pebble1 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				pebble1.setAmount(2);
				ItemStack pebble2 = Pebble.Companion
						.tier(3)
						.getUpdatedItem(false);
				pebble2.setAmount(1);
				ItemStack pebble3 = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				pebble3.setAmount(3);

				reqIngredients.add(pebble1);
				reqIngredients.add(pebble2);
				reqIngredients.add(pebble3);
				result = new PebbleShooter(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 3: //Reinforced Bow
				ItemStack reinforcedBow1 = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				reinforcedBow1.setAmount(3);
				ItemStack reinforcedBow2 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				reinforcedBow2.setAmount(3);

				reqIngredients.add(reinforcedBow1);
				reqIngredients.add(reinforcedBow2);
				result = new ReinforcedBow(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 4: //Sewer Shooter
				ItemStack sewerShooter1 = Slime.Companion
						.tier(3)
						.getUpdatedItem(false);
				sewerShooter1.setAmount(1);
				ItemStack sewerShooter2 = Magma.Companion
						.tier(3)
						.getUpdatedItem(false);
				sewerShooter2.setAmount(1);
				ItemStack sewerShooter3 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				sewerShooter3.setAmount(3);
				ItemStack sewerShooter4 = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				sewerShooter4.setAmount(3);

				reqIngredients.add(sewerShooter1);
				reqIngredients.add(sewerShooter2);
				reqIngredients.add(sewerShooter3);
				reqIngredients.add(sewerShooter4);
				result = new SewerShooter(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 7: //Iron Bow
				ItemStack ironBow1 = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				ironBow1.setAmount(3);
				ItemStack ironBow2 = RefinedMetal.Companion
						.tier(3)
						.getUpdatedItem(false);
				ironBow2.setAmount(3);

				reqIngredients.add(ironBow1);
				reqIngredients.add(ironBow2);
				result = new Clobber(Utils.randRarity()).getUpdatedItem(false);
				break;
			case 9: //Bowba
				ItemStack bowba1 = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				bowba1.setAmount(3);
				ItemStack bowba2 = Bone.Companion
						.tier(4)
						.getUpdatedItem(false);
				bowba2.setAmount(1);
				ItemStack bowba3 = RefinedMetal.Companion
						.tier(4)
						.getUpdatedItem(false);
				bowba3.setAmount(2);

				reqIngredients.add(bowba1);
				reqIngredients.add(bowba2);
				reqIngredients.add(bowba3);
				result = new Bowba(Utils.randRarity()).getUpdatedItem(false);
				break;
			default:
				return;
		}
		for (ItemStack item : reqIngredients) {
			if (!player
					.getInventory()
					.containsAtLeast(item, item.getAmount())) {
				player.sendMessage(Utils.parse(
						"<red>You do not have the required materials to craft this item."));
				return;
			}
		}
		if (!(
				e
						.getView()
						.getBottomInventory()
						.firstEmpty() == -1
		)) {
			for (ItemStack item : reqIngredients) {
				player
						.getInventory()
						.removeItem(item);
			}
			player.updateInventory();
			player
					.getInventory()
					.addItem(result);
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
			return;
		}
		player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
	}

	private void clickMobDrops(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		ArrayList< ItemStack > reqIngredients = new ArrayList<>();
		ItemStack result = null;
		switch (e.getSlot()) {
			case 0: //Slime 2
				ItemStack slime1 = Slime.Companion
						.tier(1)
						.getUpdatedItem(false);
				slime1.setAmount(8);
				reqIngredients.add(slime1);
				result = Slime.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 1: //Slime 3
				ItemStack slime2 = Slime.Companion
						.tier(2)
						.getUpdatedItem(false);
				slime2.setAmount(8);
				reqIngredients.add(slime2);
				result = Slime.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 2: //Slime 4
				ItemStack slime3 = Slime.Companion
						.tier(3)
						.getUpdatedItem(false);
				slime3.setAmount(8);
				reqIngredients.add(slime3);
				result = Slime.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 3: //Slime 5
				ItemStack slime4 = Slime.Companion
						.tier(4)
						.getUpdatedItem(false);
				slime4.setAmount(8);
				reqIngredients.add(slime4);
				result = Slime.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 5: //Magma 2
				ItemStack magma1 = Magma.Companion
						.tier(1)
						.getUpdatedItem(false);
				magma1.setAmount(8);
				reqIngredients.add(magma1);
				result = Magma.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 6: //Magma 3
				ItemStack magma2 = Magma.Companion
						.tier(2)
						.getUpdatedItem(false);
				magma2.setAmount(8);
				reqIngredients.add(magma2);
				result = Magma.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 7: //Magma 4
				ItemStack magma3 = Magma.Companion
						.tier(3)
						.getUpdatedItem(false);
				magma3.setAmount(8);
				reqIngredients.add(magma3);
				result = Magma.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 8: //Magma 5
				ItemStack magma4 = Magma.Companion
						.tier(4)
						.getUpdatedItem(false);
				magma4.setAmount(8);
				reqIngredients.add(magma4);
				result = Magma.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 9: //Ectoplasm 1
				ItemStack ectoplasm1 = Ectoplasm.Companion
						.tier(1)
						.getUpdatedItem(false);
				ectoplasm1.setAmount(8);
				reqIngredients.add(ectoplasm1);
				result = Ectoplasm.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 10: //Ectoplasm 3
				ItemStack ectoplasm2 = Ectoplasm.Companion
						.tier(2)
						.getUpdatedItem(false);
				ectoplasm2.setAmount(8);
				reqIngredients.add(ectoplasm2);
				result = Ectoplasm.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 11: //Ectoplasm 4
				ItemStack ectoplasm3 = Ectoplasm.Companion
						.tier(3)
						.getUpdatedItem(false);
				ectoplasm3.setAmount(8);
				reqIngredients.add(ectoplasm3);
				result = Ectoplasm.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 12: //Ectoplasm 5
				ItemStack ectoplasm4 = Ectoplasm.Companion
						.tier(4)
						.getUpdatedItem(false);
				ectoplasm4.setAmount(8);
				reqIngredients.add(ectoplasm4);
				result = Ectoplasm.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 14: //Bone 1
				ItemStack bone1 = Bone.Companion
						.tier(1)
						.getUpdatedItem(false);
				bone1.setAmount(8);
				reqIngredients.add(bone1);
				result = Bone.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 15: //Bone 3
				ItemStack bone2 = Bone.Companion
						.tier(2)
						.getUpdatedItem(false);
				bone2.setAmount(8);
				reqIngredients.add(bone2);
				result = Bone.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 16: //Bone 4
				ItemStack bone3 = Bone.Companion
						.tier(3)
						.getUpdatedItem(false);
				bone3.setAmount(8);
				reqIngredients.add(bone3);
				result = Bone.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 17: //Bone 5
				ItemStack bone4 = Bone.Companion
						.tier(4)
						.getUpdatedItem(false);
				bone4.setAmount(8);
				reqIngredients.add(bone4);
				result = Bone.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 18: //Wool 1
				ItemStack wool1 = Wool.Companion
						.tier(1)
						.getUpdatedItem(false);
				wool1.setAmount(8);
				reqIngredients.add(wool1);
				result = Wool.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 19: //Wool 3
				ItemStack wool2 = Wool.Companion
						.tier(2)
						.getUpdatedItem(false);
				wool2.setAmount(8);
				reqIngredients.add(wool2);
				result = Wool.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 20: //Wool 4
				ItemStack wool3 = Wool.Companion
						.tier(3)
						.getUpdatedItem(false);
				wool3.setAmount(8);
				reqIngredients.add(wool3);
				result = Wool.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 21: //Wool 5
				ItemStack wool4 = Wool.Companion
						.tier(4)
						.getUpdatedItem(false);
				wool4.setAmount(8);
				reqIngredients.add(wool4);
				result = Wool.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 23: //Leather 1
				ItemStack leather1 = Leather.Companion
						.tier(1)
						.getUpdatedItem(false);
				leather1.setAmount(8);
				reqIngredients.add(leather1);
				result = Leather.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 24: //Leather 3
				ItemStack leather2 = Leather.Companion
						.tier(2)
						.getUpdatedItem(false);
				leather2.setAmount(8);
				reqIngredients.add(leather2);
				result = Leather.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 25: //Leather 4
				ItemStack leather3 = Leather.Companion
						.tier(3)
						.getUpdatedItem(false);
				leather3.setAmount(8);
				reqIngredients.add(leather3);
				result = Leather.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 26: //Leather 5
				ItemStack leather4 = Leather.Companion
						.tier(4)
						.getUpdatedItem(false);
				leather4.setAmount(8);
				reqIngredients.add(leather4);
				result = Leather.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 27: //Feather 1
				ItemStack feather1 = Feather.Companion
						.tier(1)
						.getUpdatedItem(false);
				feather1.setAmount(8);
				reqIngredients.add(feather1);
				result = Feather.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 28: //Feather 3
				ItemStack feather2 = Feather.Companion
						.tier(2)
						.getUpdatedItem(false);
				feather2.setAmount(8);
				reqIngredients.add(feather2);
				result = Feather.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 29: //Feather 4
				ItemStack feather3 = Feather.Companion
						.tier(3)
						.getUpdatedItem(false);
				feather3.setAmount(8);
				reqIngredients.add(feather3);
				result = Feather.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 30: //Feather 5
				ItemStack feather4 = Feather.Companion
						.tier(4)
						.getUpdatedItem(false);
				feather4.setAmount(8);
				reqIngredients.add(feather4);
				result = Feather.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			default:
				return;
		}
		for (ItemStack item : reqIngredients) {
			if (!player
					.getInventory()
					.containsAtLeast(item, item.getAmount())) {
				player.sendMessage(Utils.parse(
						"<red>You do not have the required materials to craft this item."));
				return;
			}
		}
		if (!(
				e
						.getView()
						.getBottomInventory()
						.firstEmpty() == -1
		)) {
			for (ItemStack item : reqIngredients) {
				player
						.getInventory()
						.removeItem(item);
			}
			player.updateInventory();
			player
					.getInventory()
					.addItem(result);
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
			return;
		}
		player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
	}

	private void clickBlockDrops(InventoryClickEvent e) {

		Player player = (Player) e.getWhoClicked();
		ArrayList< ItemStack > reqIngredients = new ArrayList<>();
		ItemStack result = null;
		switch (e.getSlot()) {
			case 0: //Plant Matter 2
				ItemStack PlantMatter1 = PlantMatter.Companion
						.tier(1)
						.getUpdatedItem(false);
				PlantMatter1.setAmount(8);
				reqIngredients.add(PlantMatter1);
				result = PlantMatter.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 1: //Plant Matter 3
				ItemStack PlantMatter2 = PlantMatter.Companion
						.tier(2)
						.getUpdatedItem(false);
				PlantMatter2.setAmount(8);
				reqIngredients.add(PlantMatter2);
				result = PlantMatter.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 2: //Plant Matter 4
				ItemStack PlantMatter3 = PlantMatter.Companion
						.tier(3)
						.getUpdatedItem(false);
				PlantMatter3.setAmount(8);
				reqIngredients.add(PlantMatter3);
				result = PlantMatter.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 3: //Plant Matter 5
				ItemStack PlantMatter4 = PlantMatter.Companion
						.tier(4)
						.getUpdatedItem(false);
				PlantMatter4.setAmount(8);
				reqIngredients.add(PlantMatter4);
				result = PlantMatter.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 5: //Seed 2
				ItemStack Seed1 = Seed.Companion
						.tier(1)
						.getUpdatedItem(false);
				Seed1.setAmount(8);
				reqIngredients.add(Seed1);
				result = Seed.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 6: //Seed 3
				ItemStack Seed2 = Seed.Companion
						.tier(2)
						.getUpdatedItem(false);
				Seed2.setAmount(8);
				reqIngredients.add(Seed2);
				result = Seed.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 7: //Seed 4
				ItemStack Seed3 = Seed.Companion
						.tier(3)
						.getUpdatedItem(false);
				Seed3.setAmount(8);
				reqIngredients.add(Seed3);
				result = Seed.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 8: //Seed 5
				ItemStack Seed4 = Seed.Companion
						.tier(4)
						.getUpdatedItem(false);
				Seed4.setAmount(8);
				reqIngredients.add(Seed4);
				result = Seed.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 9: //Coal 2
				ItemStack Coal1 = Coal.Companion
						.tier(1)
						.getUpdatedItem(false);
				Coal1.setAmount(8);
				reqIngredients.add(Coal1);
				result = Coal.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 10: //Coal 3
				ItemStack Coal2 = Coal.Companion
						.tier(2)
						.getUpdatedItem(false);
				Coal2.setAmount(8);
				reqIngredients.add(Coal2);
				result = Coal.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 11: //Coal 4
				ItemStack Coal3 = Coal.Companion
						.tier(3)
						.getUpdatedItem(false);
				Coal3.setAmount(8);
				reqIngredients.add(Coal3);
				result = Coal.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 12: //Coal 5
				ItemStack Coal4 = Coal.Companion
						.tier(4)
						.getUpdatedItem(false);
				Coal4.setAmount(8);
				reqIngredients.add(Coal4);
				result = Coal.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 14: //Vine 2
				ItemStack Vine1 = Vine.Companion
						.tier(1)
						.getUpdatedItem(false);
				Vine1.setAmount(8);
				reqIngredients.add(Vine1);
				result = Vine.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 15: //Vine 3
				ItemStack Vine2 = Vine.Companion
						.tier(2)
						.getUpdatedItem(false);
				Vine2.setAmount(8);
				reqIngredients.add(Vine2);
				result = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 16: //Vine 4
				ItemStack Vine3 = Vine.Companion
						.tier(3)
						.getUpdatedItem(false);
				Vine3.setAmount(8);
				reqIngredients.add(Vine3);
				result = Vine.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 17: //Vine 5
				ItemStack Vine4 = Vine.Companion
						.tier(4)
						.getUpdatedItem(false);
				Vine4.setAmount(8);
				reqIngredients.add(Vine4);
				result = Vine.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 18: //Stick 2
				ItemStack Stick1 = Stick.Companion
						.tier(1)
						.getUpdatedItem(false);
				Stick1.setAmount(8);
				reqIngredients.add(Stick1);
				result = Stick.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 19: //Stick 3
				ItemStack Stick2 = Stick.Companion
						.tier(2)
						.getUpdatedItem(false);
				Stick2.setAmount(8);
				reqIngredients.add(Stick2);
				result = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 20: //Stick 4
				ItemStack Stick3 = Stick.Companion
						.tier(3)
						.getUpdatedItem(false);
				Stick3.setAmount(8);
				reqIngredients.add(Stick3);
				result = Stick.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 21: //Stick 5
				ItemStack Stick4 = Stick.Companion
						.tier(4)
						.getUpdatedItem(false);
				Stick4.setAmount(8);
				reqIngredients.add(Stick4);
				result = Stick.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 23: //Pebble 2
				ItemStack Pebble1 = Pebble.Companion
						.tier(1)
						.getUpdatedItem(false);
				Pebble1.setAmount(8);
				reqIngredients.add(Pebble1);
				result = Pebble.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 24: //Pebble 3
				ItemStack Pebble2 = Pebble.Companion
						.tier(2)
						.getUpdatedItem(false);
				Pebble2.setAmount(8);
				reqIngredients.add(Pebble2);
				result = Pebble.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 25: //Pebble 4
				ItemStack Pebble3 = Pebble.Companion
						.tier(3)
						.getUpdatedItem(false);
				Pebble3.setAmount(8);
				reqIngredients.add(Pebble3);
				result = Pebble.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 26: //Pebble 5
				ItemStack Pebble4 = Pebble.Companion
						.tier(4)
						.getUpdatedItem(false);
				Pebble4.setAmount(8);
				reqIngredients.add(Pebble4);
				result = Pebble.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 27: //Chain 2
				ItemStack Chain1 = Chain.Companion
						.tier(1)
						.getUpdatedItem(false);
				Chain1.setAmount(8);
				reqIngredients.add(Chain1);
				result = Chain.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 28: //Chain 3
				ItemStack Chain2 = Chain.Companion
						.tier(2)
						.getUpdatedItem(false);
				Chain2.setAmount(8);
				reqIngredients.add(Chain2);
				result = Chain.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 29: //Chain 4
				ItemStack Chain3 = Chain.Companion
						.tier(3)
						.getUpdatedItem(false);
				Chain3.setAmount(8);
				reqIngredients.add(Chain3);
				result = Chain.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 30: //Chain 5
				ItemStack Chain4 = Chain.Companion
						.tier(4)
						.getUpdatedItem(false);
				Chain4.setAmount(8);
				reqIngredients.add(Chain4);
				result = Chain.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 32: //Metal Scrap 2
				ItemStack MetalScrap1 = MetalScrap.Companion
						.tier(1)
						.getUpdatedItem(false);
				MetalScrap1.setAmount(8);
				reqIngredients.add(MetalScrap1);
				result = MetalScrap.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 33: //Metal Scrap 3
				ItemStack MetalScrap2 = MetalScrap.Companion
						.tier(2)
						.getUpdatedItem(false);
				MetalScrap2.setAmount(8);
				reqIngredients.add(MetalScrap2);
				result = MetalScrap.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 34: //Metal Scrap 4
				ItemStack MetalScrap3 = MetalScrap.Companion
						.tier(3)
						.getUpdatedItem(false);
				MetalScrap3.setAmount(8);
				reqIngredients.add(MetalScrap3);
				result = MetalScrap.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 35: //Metal Scrap 5
				ItemStack MetalScrap4 = MetalScrap.Companion
						.tier(4)
						.getUpdatedItem(false);
				MetalScrap4.setAmount(8);
				reqIngredients.add(MetalScrap4);
				result = MetalScrap.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 36: //Refined Metal 1
				ItemStack RefinedMetal0 = MetalScrap.Companion
						.tier(1)
						.getUpdatedItem(false);
				RefinedMetal0.setAmount(9);
				reqIngredients.add(RefinedMetal0);
				result = RefinedMetal.Companion
						.tier(1)
						.getUpdatedItem(false);
				break;
			case 37: //Refined Metal 2
				ItemStack RefinedMetal1 = RefinedMetal.Companion
						.tier(1)
						.getUpdatedItem(false);
				RefinedMetal1.setAmount(8);
				reqIngredients.add(RefinedMetal1);
				result = RefinedMetal.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 38: //Refined Metal 3
				ItemStack RefinedMetal2 = RefinedMetal.Companion
						.tier(2)
						.getUpdatedItem(false);
				RefinedMetal2.setAmount(8);
				reqIngredients.add(RefinedMetal2);
				result = RefinedMetal.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 39: //Refined Metal 4
				ItemStack RefinedMetal3 = RefinedMetal.Companion
						.tier(3)
						.getUpdatedItem(false);
				RefinedMetal3.setAmount(8);
				reqIngredients.add(RefinedMetal3);
				result = RefinedMetal.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 40: //Refined Metal 5
				ItemStack RefinedMetal4 = RefinedMetal.Companion
						.tier(4)
						.getUpdatedItem(false);
				RefinedMetal4.setAmount(8);
				reqIngredients.add(RefinedMetal4);
				result = RefinedMetal.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			case 45: //Wheat 2
				ItemStack Wheat1 = Wheat.Companion
						.tier(1)
						.getUpdatedItem(false);
				Wheat1.setAmount(8);
				reqIngredients.add(Wheat1);
				result = Wheat.Companion
						.tier(2)
						.getUpdatedItem(false);
				break;
			case 46: //Wheat 3
				ItemStack Wheat2 = Wheat.Companion
						.tier(2)
						.getUpdatedItem(false);
				Wheat2.setAmount(8);
				reqIngredients.add(Wheat2);
				result = Wheat.Companion
						.tier(3)
						.getUpdatedItem(false);
				break;
			case 47: //Wheat 4
				ItemStack Wheat3 = Wheat.Companion
						.tier(3)
						.getUpdatedItem(false);
				Wheat3.setAmount(8);
				reqIngredients.add(Wheat3);
				result = Wheat.Companion
						.tier(4)
						.getUpdatedItem(false);
				break;
			case 48: //Wheat 5
				ItemStack Wheat4 = Wheat.Companion
						.tier(4)
						.getUpdatedItem(false);
				Wheat4.setAmount(8);
				reqIngredients.add(Wheat4);
				result = Wheat.Companion
						.tier(5)
						.getUpdatedItem(false);
				break;
			default:
				return;
		}
		for (ItemStack item : reqIngredients) {
			if (!player
					.getInventory()
					.containsAtLeast(item, item.getAmount())) {
				player.sendMessage(Utils.parse(
						"<red>You do not have the required materials to craft this item."));
				return;
			}
		}
		if (!(
				e
						.getView()
						.getBottomInventory()
						.firstEmpty() == -1
		)) {
			for (ItemStack item : reqIngredients) {
				player
						.getInventory()
						.removeItem(item);
			}
			player.updateInventory();
			player
					.getInventory()
					.addItem(result);
			player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
			return;
		}
		player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));
	}

	private void clickMisc(InventoryClickEvent e) {
        /*
        Player player = (Player) e.getWhoClicked();
        ArrayList<ItemStack> reqIngredients = new ArrayList<>();
        ItemStack result = null;
        switch (e.getSlot()) {
            case 0: //Arrows

                //Initialize Ingredients
                ItemStack arrow1 = Pebble.Companion.tier(1).getUpdatedItem(false);
                arrow1.setAmount(4);
                ItemStack arrow2 = Stick.Companion.tier(2).getUpdatedItem(false);
                arrow2.setAmount(1);
                ItemStack arrow3 = Feather.Companion.tier(1).getUpdatedItem(false);
                arrow3.setAmount(4);

                //Add ingredients to required ingredients
                reqIngredients.add(arrow1);
                reqIngredients.add(arrow2);
                reqIngredients.add(arrow3);
                //Set result of recipe

                result = new ItemStack(Material.ARROW, 64);
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
        if (!(e.getView().getBottomInventory().firstEmpty() == -1)) {
            for (ItemStack item : reqIngredients) {
                player.getInventory().removeItem(item);
            }
            player.updateInventory();
            player.getInventory().addItem(result);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
            return;
        }
        player.sendMessage(Utils.parse("<red>Your inventory is full! Please make room."));*/
	}


	private Inventory getMenu(Player player) {

		Inventory gui = Bukkit.createInventory(null, 27, "Symone's Collection");

		//Fill in the GUI
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		for (int i = 0; i < gui.getSize(); i++) {
			gui.setItem(i, filler);
		}

		//Creating Light Melee Icon
		ItemStack lightMelee = new ItemStack(Material.WOODEN_SWORD);
		ItemMeta lightMeleeMeta = lightMelee.getItemMeta();
		lightMeleeMeta.displayName(Utils.lore("<red>Light Melee"));
		lightMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
		lightMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
		lightMelee.setItemMeta(lightMeleeMeta);

		//Creating Heavy Melee Icon
		ItemStack heavyMelee = new ItemStack(Material.WOODEN_AXE);
		ItemMeta heavyMeleeMeta = heavyMelee.getItemMeta();
		heavyMeleeMeta.displayName(Utils.lore("<dark_red>Heavy Melee"));
		heavyMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
		heavyMeleeMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
		heavyMelee.setItemMeta(heavyMeleeMeta);

		//Creating Armor Icon
		ItemStack armor = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta armorMeta = armor.getItemMeta();
		armorMeta.displayName(Utils.lore("<dark_aqua>Armor"));
		armorMeta.removeAttributeModifier(Attribute.GENERIC_ARMOR);
		armor.setItemMeta(armorMeta);

		//Creating Wand Icon
		ItemStack wand = new ItemStack(Material.WOODEN_HOE);
		ItemMeta wandMeta = wand.getItemMeta();
		wandMeta.displayName(Utils.lore("<dark_green>Wands"));
		wandMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
		wandMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
		wand.setItemMeta(wandMeta);

		//Creating Ranged Icon
		ItemStack ranged = new ItemStack(Material.BOW);
		ItemMeta rangedMeta = ranged.getItemMeta();
		rangedMeta.displayName(Utils.lore("<green>Ranged Weapons"));
		ranged.setItemMeta(rangedMeta);

		//Creating Mob Drop
		ItemStack mobDrop = new ItemStack(Material.SLIME_BALL);
		ItemMeta mobDropMeta = mobDrop.getItemMeta();
		mobDropMeta.displayName(Utils.lore("<light_purple>Mob Drops"));
		mobDrop.setItemMeta(mobDropMeta);

		//Creating misc
		ItemStack misc = new ItemStack(Material.FEATHER);
		ItemMeta miscMeta = misc.getItemMeta();
		miscMeta.displayName(Utils.lore("<aqua>Miscellaneous"));
		misc.setItemMeta(miscMeta);

		//Creating Block Drop
		ItemStack blockDrop = new ItemStack(Material.STONE);
		ItemMeta blockDropMeta = blockDrop.getItemMeta();
		blockDropMeta.displayName(Utils.lore("<yellow>Block Drops"));
		blockDrop.setItemMeta(blockDropMeta);

		//This is where you decide what slot the item goes into
		gui.setItem(11, lightMelee);
		gui.setItem(12, heavyMelee);
		gui.setItem(13, armor);
		gui.setItem(14, wand);
		gui.setItem(15, ranged);
		gui.setItem(21, mobDrop);
		gui.setItem(22, misc);
		gui.setItem(23, blockDrop);

		player.setMetadata("SymoneMenu", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory getLightMelee(Player player) {

		Inventory gui = Bukkit.createInventory(null, 18, "Light Melee Weapons");

		//Fill in the GUI
		for (int i = 0; i < lightMeleeList.size(); i++) {
			gui.setItem(i, lightMeleeList.get(i));
		}

		player.setMetadata("SymoneLightMelee", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory getHeavyMelee(Player player) {

		Inventory gui = Bukkit.createInventory(null, 18, "Heavy Melee Weapons");

		//Fill in the GUI
		for (int i = 0; i < heavyMeleeList.size(); i++) {
			gui.setItem(i, heavyMeleeList.get(i));
		}

		player.setMetadata("SymoneHeavyMelee", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory getArmor(Player player) {

		Inventory gui = Bukkit.createInventory(null, 36, "Armor");

		//Fill in the GUI
		for (int i = 0; i < armorList.size(); i++) {
			gui.setItem(i, armorList.get(i));
		}

		player.setMetadata("SymoneArmor", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory mobDropsList(Player player) {

		Inventory gui = Bukkit.createInventory(null, 36, "Mob Drops");
		for (int i = 0; i < mobDropsList.size(); i++) {
			gui.setItem(i, mobDropsList.get(i));
		}
		player.setMetadata("SymoneMobDrops", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory blockDropsList(Player player) {

		Inventory gui = Bukkit.createInventory(null, 54, "Block Drops");
		for (int i = 0; i < blockDropsList.size(); i++) {
			gui.setItem(i, blockDropsList.get(i));
		}
		player.setMetadata("SymoneBlockDrops", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory miscList(Player player) {

		Inventory gui = Bukkit.createInventory(null, 9, "Miscellaneous");
		for (int i = 0; i < miscList.size(); i++) {
			gui.setItem(i, miscList.get(i));
		}
		player.setMetadata("SymoneMisc", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory getWand(Player player) {

		Inventory gui = Bukkit.createInventory(null, 18, "Wand Weapons");

		//Fill in the GUI
		for (int i = 0; i < wandsList.size(); i++) {
			gui.setItem(i, wandsList.get(i));
		}

		player.setMetadata("SymoneWand", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

	private Inventory getRanged(Player player) {

		Inventory gui = Bukkit.createInventory(null, 18, "Ranged Weapons");

		//Fill in the GUI
		for (int i = 0; i < rangedList.size(); i++) {
			gui.setItem(i, rangedList.get(i));
		}

		player.setMetadata("SymoneRanged", new FixedMetadataValue(Core.plugin(), gui));
		return gui;
	}

}
