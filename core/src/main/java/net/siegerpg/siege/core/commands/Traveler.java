package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.*;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.siegerpg.siege.core.listeners.NPC.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.jetbrains.annotations.*;

import java.util.*;

public class Traveler implements CommandExecutor {

	private ChestGui menu;

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player player)) return false;

		player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.75f, 1.0f);
		Traveler instance = new Traveler();
		this.menu = instance.getMenu(player);
		this.menu.show(player);
		return true;
	}

	private ChestGui getMenu(Player player) {
		//Menu
		ChestGui menu = new ChestGui(5, "Wagon Ride");
		menu.setOnGlobalClick(event -> {
			player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 0.75f);
			event.setCancelled(true);
		});

		OutlinePane background = new OutlinePane(0, 0, 9, 5, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		fillerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);


		/*
			Warp Locations
		 */
		Location locTwo = new Location(Bukkit.getWorld("Hilly_Woods"), 206.5, 60, -125.5, 90 ,0);
		Location locThree = new Location(Bukkit.getWorld("Hilly_Woods"), 214.5, 61, -3.5, 90 ,0);
		Location locFour = new Location(Bukkit.getWorld("Hilly_Woods"), 192, 88, 207, -45 ,0);
		Location locFive = new Location(Bukkit.getWorld("Hilly_Woods"), 14.5, 62, 221.5, 90 ,0);
		Location locSix = new Location(Bukkit.getWorld("Hilly_Woods"), -203, 72, 158, -90 ,0);
		Location locSeven = new Location(Bukkit.getWorld("Hilly_Woods"), -41.5, 117, 49.5, 0 ,0);
		Location locEight = new Location(Bukkit.getWorld("Hilly_Woods"), -36, 100, -123, 130 ,0);
		/*
		  Warp Icons
		 */
		OutlinePane areaTwo = new OutlinePane(1, 1, 1, 1);
		OutlinePane areaThree = new OutlinePane(3, 1, 1, 1);
		OutlinePane areaFour = new OutlinePane(5, 1, 1, 1);
		OutlinePane areaFive = new OutlinePane(7, 1, 1, 1);
		OutlinePane areaSix = new OutlinePane(1, 3, 1, 1);
		OutlinePane areaSeven = new OutlinePane(3, 3, 1, 1);
		OutlinePane areaEight = new OutlinePane(5, 3, 1, 1);

		int bal = (int) VaultHook.econ.getBalance(player);

		areaTwo.addItem(new GuiItem(getIcon(100, Utils.createHead("MHF_LavaSlime"), 2), e -> {
			if (bal < 100) return;
			VaultHook.econ.withdrawPlayer(player, 100);
			player.teleport(locTwo);
		}));
		areaThree.addItem(new GuiItem(getIcon(150, Utils.createHead("MHF_Cow"), 3), e -> {
			if (bal < 150) return;
			VaultHook.econ.withdrawPlayer(player, 150);
			player.teleport(locThree);
		}));
		areaFour.addItem(new GuiItem(getIcon(200, Utils.createHead("MHF_Enderman"), 4), e -> {
			if (bal < 200) return;
			VaultHook.econ.withdrawPlayer(player, 200);
			player.teleport(locFour);
		}));
		areaFive.addItem(new GuiItem(getIcon(275, Utils.createHead("MHF_Squid"), 5), e -> {
			if (bal < 275) return;
			VaultHook.econ.withdrawPlayer(player, 275);
			player.teleport(locFive);
		}));
		areaSix.addItem(new GuiItem(getIcon(350, Utils.createHead("MHF_WSkeleton"), 6), e -> {
			if (bal < 350) return;
			VaultHook.econ.withdrawPlayer(player, 350);
			player.teleport(locSix);
		}));
		areaSeven.addItem(new GuiItem(getIcon(450, Utils.createHead("BONG_CHUN"), 7), e -> {
			if (bal < 450) return;
			VaultHook.econ.withdrawPlayer(player, 450);
			player.teleport(locSeven);
		}));
		areaEight.addItem(new GuiItem(getIcon(550, Utils.createHead("MHF_Spider"), 8), e -> {
			if (bal < 550) return;
			VaultHook.econ.withdrawPlayer(player, 550);
			player.teleport(locEight);
		}));


		menu.addPane(areaTwo);
		menu.addPane(areaThree);
		menu.addPane(areaFour);
		menu.addPane(areaFive);
		menu.addPane(areaSix);
		menu.addPane(areaSeven);
		menu.addPane(areaEight);

		this.menu = menu;
		return menu;
	}

	private static ItemStack getIcon(int bal, ItemStack icon, int area) {
		//Creating Icon
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<gold>Area "+area));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<yellow>Costs <gray>"+String.format("%,d", bal)+" \u26C1"));
			}
		});
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

}