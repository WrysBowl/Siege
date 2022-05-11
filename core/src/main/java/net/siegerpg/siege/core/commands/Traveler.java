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
		Location locOne = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		Location locTwo = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		Location locThree = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		Location locFour = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		Location locFive = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		Location locSix = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		Location locSeven = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		Location locEight = new Location(Bukkit.getWorld("Hilly_Woods"), 0, 0, 0, 0 ,0);
		/*
		  Warp Icons
		 */
		OutlinePane areaOne = new OutlinePane(1, 1, 1, 1);
		OutlinePane areaTwo = new OutlinePane(3, 1, 1, 1);
		OutlinePane areaThree = new OutlinePane(5, 1, 1, 1);
		OutlinePane areaFour = new OutlinePane(7, 1, 1, 1);
		OutlinePane areaFive = new OutlinePane(1, 3, 1, 1);
		OutlinePane areaSix = new OutlinePane(3, 3, 1, 1);
		OutlinePane areaSeven = new OutlinePane(5, 3, 1, 1);
		OutlinePane areaEight = new OutlinePane(7, 3, 1, 1);

		areaOne.addItem(new GuiItem(Utils.createHead("MHF_Slime"), e -> player.teleport(locOne)));
		areaTwo.addItem(new GuiItem(Utils.createHead("MHF_LavaSlime"), e -> player.teleport(locTwo)));
		areaThree.addItem(new GuiItem(Utils.createHead("MHF_Cow"), e -> player.teleport(locThree)));
		areaFour.addItem(new GuiItem(Utils.createHead("MHF_Enderman"), e -> player.teleport(locFour)));
		areaFive.addItem(new GuiItem(Utils.createHead("MHF_Squid"), e -> player.teleport(locFive)));
		areaSix.addItem(new GuiItem(Utils.createHead("MHF_WSkeleton"), e -> player.teleport(locSix)));
		areaSeven.addItem(new GuiItem(Utils.createHead("BONG_CHUN"), e -> player.teleport(locSeven)));
		areaEight.addItem(new GuiItem(Utils.createHead("MHF_Spider"), e -> player.teleport(locEight)));


		menu.addPane(areaOne);
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

}