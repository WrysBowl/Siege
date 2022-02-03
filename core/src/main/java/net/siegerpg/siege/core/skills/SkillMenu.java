package net.siegerpg.siege.core.skills;

import com.github.stefvanschie.inventoryframework.gui.*;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.siegerpg.siege.core.items.*;
import net.siegerpg.siege.core.items.enums.*;
import net.siegerpg.siege.core.items.types.subtypes.*;
import net.siegerpg.siege.core.listeners.NPC.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SkillMenu {


	/*
	INSTRUCTIONS

	1. Create new player menu that displays the three class options
	2. Create methods to return GUIs for 1-4 skills that look like a continuation
	of a tree the options are a part of.

	- Make the method require a list of the appropriate amount of skills to display
	in order and whether a boolean for if it's the starting page or not
	- Check if the skill has a child node, if so add lines to represent a continuation,
	if not, don't.
	- Set the skill to glass and make the lines into panes. Skills should be red if they
	aren't unlocked yet, yellow if the player can upgrade it next, and green if the player
	has already unlocked the skill. The lines can be red if the player has not unlocked
	the path, yellow if the player can unlock the path, and green if the player has
	already unlocked the path.

	3. Make methods for each separate GUI that displays a skill, and it's child nodes.
	Make arrows at the end of each line clickable to open the next GUI
	4. Make the player open to their skill class when they use the command, if they have
	already specialized in a class
	5. Create a back button in all GUIs to go to the previous GUI. Set the variable each
	time the player requests to open another GUI
	6. When a player clicks on a green skill a GUI should pop up with three icons:

	- Cost of upgrading the skill
	- The skill's book with the upgraded values shown in the description
	- Go back to the previous GUI

	7. When a player clicks on a yellow skill a GUI should pop up with two icons

	- Unlock this skill for X skill points
	- Go back to the previous GUI

	8. Remember to add special sounds! Enchanting, magical, confirmation sounds

	 */


/*
	private ChestGui previousGUI;
	private Player player;

	public SkillMenu() {
		previousGUI = null;
	}
	public SkillMenu(Player player) {
		this.player = player;
	}

	public void openInventory(Player player) {
		CustomItem customItem = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
		if (customItem instanceof CustomArmor || customItem instanceof CustomWeapon) {
			SkillMenu instance = new SkillMenu(customItem);
			instance.getMenu(player).show(player);
			return;
		}
		player.sendMessage(Utils.lore("<red>You must be holding a weapon!"));
	}


	private ChestGui getMenu(Player player) {

		//Menu
		ChestGui menu = new ChestGui(3, "Rarity Roll");
		menu.setOnGlobalClick(event -> {
			player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 0.75f);
			event.setCancelled(true);
		});

		OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		fillerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane exitIcon = new OutlinePane(6, 1, 1, 1);
		OutlinePane reRollIcon = new OutlinePane(2, 1, 1, 1);
		OutlinePane itemIcon = new OutlinePane(4, 1, 1, 1);

		//Creating rows
		exitIcon.addItem(new GuiItem(getIconExit(), e -> {
			player.getInventory().close();
		}));
		reRollIcon.addItem(new GuiItem(getIconReRoll(), e -> {
			reRoll(player);
		}));
		itemIcon.addItem(new GuiItem(this.item.getUpdatedItem(false)));

		menu.addPane(exitIcon);
		menu.addPane(itemIcon);
		menu.addPane(reRollIcon);

		return menu;
	}
	private ItemStack getIconExit() {
		ItemStack icon = new ItemStack(Material.BARRIER);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<red><bold>EXIT"));
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private ItemStack getIconReRoll() {
		ItemStack icon = new ItemStack(Material.RESPAWN_ANCHOR);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#B5EB5A><bold>RE-ROLL"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click to roll a"));
				add(Utils.lore("<gray>new rarity for"));
				add(Utils.lore("<yellow>"+getCost()+" \u26C1"));
			}
		});
		icon.setItemMeta(iconMeta);
		return icon;
	}
	private int getCost() {
		try {
			int levelReq = this.item.getLevelRequirement();
			return (levelReq * levelReq) * 5;
		} catch (Exception ignored) {}
		return 0;
	}

	private void reRoll(Player player) {

		//save a copy of current item
		CustomItem copiedItem = this.item;

		//check if player has balance to pay for re-roll
		double bal = VaultHook.econ.getBalance(player);
		if (bal < getCost()) {
			player.sendMessage(Utils.tacc("&cYou are too poor to re-roll your item!"));
			player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
			return;
		}

		//removes cost of re-roll from player's balance
		player.sendMessage(Utils.tacc("&eYou re-rolled your item's quality!"));
		player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0f, 1.0f);
		VaultHook.econ.withdrawPlayer(player, getCost());
		Scoreboard.updateScoreboard(player);

		//remove item from player's inventory
		player.getInventory().remove(this.item.getItem().asOne());

		//change quality of copied item
		int rarity = Utils.randRarity();
		copiedItem.setQuality(rarity);
		copiedItem.setRarity(Rarity.Companion.getFromInt(rarity));
		copiedItem.serialize();

		//remove old item from player
		player.getInventory().remove(this.item.getItem().asOne());

		//set this.item to copied item
		this.item = copiedItem;

		//give player copied item
		Utils.giveItem(player, copiedItem.getUpdatedItem(false));
		openInventory(player);
	}
*/

}
