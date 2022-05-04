package net.siegerpg.siege.core.skills;

import com.github.stefvanschie.inventoryframework.gui.*;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import io.lumine.xikage.mythicmobs.*;
import io.lumine.xikage.mythicmobs.mobs.*;
import net.siegerpg.siege.core.drops.*;
import net.siegerpg.siege.core.listeners.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class SkillGUI implements CommandExecutor {

	ItemStack mageIcon;
	ItemStack warriorIcon;
	ItemStack archerIcon;
	ItemStack next;

	/**
	 * Menu
	 *         - Displays all three classes IF the  player does not have one
	 *         - Displays the player's skill tree IF the player has one
	 * Warrior/Archer/Mage GUIs
	 *         - Each page is created with it's own method
	 *         - Displays skill points in top right
	 *         - Displays level of skill, and cost of upgrade if unlocked
	 *         - Displays skill description, mana cost, and cooldown
	 *         - Displays yellow pane if skill is unlockable (end of a branch)
	 *         - Displays red pane if skill is locked
	 *         - Displays green pane if skill has been unlocked
	 *         - Tree-like structure of skill tree (this is going to be really tedious)
	 * Increase Level of Skill
	 *         - Displays level of skill
	 *         - Displays cost to upgrade
	 *         - Displays button to purchase skill upgrade, and confirmation afterward
	 *         - Update button (show the menu again)
	 */

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player player)) {
			return false;
		}
		getClassMenu(player);
		return true;
	}


	public ChestGui getClassMenu(Player player) {
		/*
		- Displays all three classes IF the  player does not have one
	    - Displays the player's skill tree IF the player has one
	    */
		SkillClass skillClass = SkillData.getSkillClass(player);
		if (skillClass != null) {
			switch(skillClass) {
				case ARCHER:
					return getMageGUI(player);
				case MAGE:
					return getWarriorGUI(player);
				case WARRIOR:
					return getWarriorGUI(player);
				default:
					break;
			}
		}


		//Menu
		ChestGui menu = new ChestGui(3, "Explore Classes");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));

		background.setRepeat(true);

		menu.addPane(background);

		OutlinePane row = new OutlinePane(2, 1, 5, 1);

		this.next = getIconNext();
		this.mageIcon = getMageIcon();
		this.warriorIcon = getWarriorIcon();
		this.archerIcon = getArcherIcon();

		row.addItem(new GuiItem(this.mageIcon, inventoryClickEvent -> {
			getMageGUI(player).show(player);
		}));
		row.addItem(new GuiItem(filler));
		row.addItem(new GuiItem(this.warriorIcon, inventoryClickEvent -> {
			getWarriorGUI(player).show(player);
		}));
		row.addItem(new GuiItem(filler));
		row.addItem(new GuiItem(this.archerIcon, inventoryClickEvent -> {
			getWarriorGUI(player).show(player);
		}));



		menu.addPane(row);
		return menu;
	}

	private ChestGui getMageGUI(Player player) {
		/*
		switch statement to determine which GUI to use
		 */

		ChestGui menu = new ChestGui(6, "Mage Skills");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 1, 7, 4);


		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		menu.addPane(row);
		menu.addPane(nextButton);

		return menu;
	}


	private ChestGui getWarriorGUI(Player player) {
		//Menu
		ChestGui menu = new ChestGui(6, "Mob Drops");

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 1, 7, 4);



		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		menu.addPane(row);
		menu.addPane(nextButton);

		return menu;
	}

	private ChestGui getSkillUpgradeGUI(Player player, Skill skill) {

		Integer skillLevel = SkillData.getSkillLevel(player, skill);
		if (skillLevel == null) skillLevel = 0;
		String skillName = skill.getName(skillLevel);

		ChestGui menu = new ChestGui(6, skillName);

		menu.setOnGlobalClick(event -> event.setCancelled(true));

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);

		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(1, 1, 7, 4);



		OutlinePane nextButton = new OutlinePane(8, 5, 1, 1);

		menu.addPane(row);
		menu.addPane(nextButton);

		return menu;
	}







	/*
	ICONS
	 */
	private static ItemStack getMageIcon() {
		ItemStack icon = new ItemStack(Material.BLAZE_ROD);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#DA97EC><bold><underlined>Mage"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View skills"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#A4CE51><underlined>                  "));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getWarriorIcon() {
		ItemStack icon = new ItemStack(Material.IRON_SWORD);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#E35D73><bold><underlined>Warrior"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View skills"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#E7234A><underlined>               "));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getArcherIcon() {
		ItemStack icon = new ItemStack(Material.BOW);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#97CEEC><bold><underlined>Archer"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View skills"));
				add(Utils.lore("<yellow>Right Click"));
				add(Utils.lore("<color:#A22525><underlined>                 "));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getIconNext() {
		//Creating Next Icon
		ItemStack icon = new ItemStack(Material.SKELETON_SKULL);
		SkullMeta iconMeta = (SkullMeta) icon.getItemMeta();
		iconMeta.setOwner("MHF_ArrowRight");
		iconMeta.displayName(Utils.lore("<green>Next"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Next page"));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private static ItemStack getIconBack() {
		//Creating Back Icon
		ItemStack icon = new ItemStack(Material.SKELETON_SKULL);
		SkullMeta iconMeta = (SkullMeta) icon.getItemMeta();
		iconMeta.setOwner("MHF_ArrowLeft");
		iconMeta.displayName(Utils.lore("<red>Back"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Last page"));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
}
