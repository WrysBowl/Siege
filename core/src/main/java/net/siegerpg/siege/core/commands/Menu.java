package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import kotlin.Pair;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.listeners.NPC.GemRemover;
import net.siegerpg.siege.core.listeners.NPC.Herbert;
import net.siegerpg.siege.core.listeners.NPC.RarityRoll;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import net.siegerpg.siege.core.miscellaneous.cache.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Menu implements CommandExecutor {

	private ChestGui menu;
	private static final Location farmLocation = new Location(Bukkit.getWorld("Hilly_Woods"),188.5, 61, -122.5, -90, 0);
	private static final Location villageLocation = new Location(Bukkit.getWorld("Hilly_Woods"),205.5, 93, 217.5, 180, 0);

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player player)) {
			return false;
		}

		player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.75f, 1.0f);
		Menu instance = new Menu();
		this.menu = instance.getMenu(player);
		this.menu.show(player);
		return true;
	}

	private ChestGui getMenu(Player player) {
		//Menu
		ChestGui menu = new ChestGui(6, "Menu");
		menu.setOnGlobalClick(event -> {
			player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 0.5f, 0.75f);
			event.setCancelled(true);
		});

		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		fillerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		OutlinePane row = new OutlinePane(0, 1, 9, 1);
		ItemStack rowItem = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
		ItemMeta rowItemMeta = rowItem.getItemMeta();
		rowItemMeta.displayName(Utils.lore(""));
		rowItem.setItemMeta(rowItemMeta);
		row.addItem(new GuiItem(rowItem));
		row.setRepeat(true);
		menu.addPane(row);

		/*
		  Storage Icons
		 */
		//Creating vault
		OutlinePane vault = new OutlinePane(0, 0, 1, 1);
		vault.addItem(new GuiItem(getVaultIcon(player), e -> player.performCommand("pv")));

		//Creating ender chest
		OutlinePane enderChest = new OutlinePane(1, 0, 1, 1);
		enderChest.addItem(new GuiItem(geteChestIcon(player), e -> player.performCommand("ec")));


		/*
		  Utility Icons
		 */
		OutlinePane utilities = new OutlinePane(0, 2, 1, 4);
		//Creating scrapper
		utilities.addItem(new GuiItem(getScrapperIcon(player), e -> {
			if (player.hasPermission("siege.donor")) {
				new Herbert(player);
			} else {
				player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 0.5f, 0.75f);
			}
		}));
		//Creating Gem Remover
		utilities.addItem(new GuiItem(getGemRemover(), e -> {
			new GemRemover().openInventory(player);
		}));
		//Creating Drops
		utilities.addItem(new GuiItem(getDropsIcon(), e -> new Drops().getStartMenu(player).show(player)));
		//Creating ReRoll Icon
		utilities.addItem(new GuiItem(getReRollIcon(), e -> new RarityRoll().openInventory(player)));


		/*
		  Warp Icons
		 */
		OutlinePane warps = new OutlinePane(8, 2, 1, 4);
		//Creating set home icon
		warps.addItem(new GuiItem(getIconHome(player), e -> {
			int homeNumber = getHomePermissionNumber(player);
			int bal = (int) VaultHook.econ.getBalance(player);
			int cost = (int) (Math.pow(homeNumber + 4, 3) * 1000);
			String homeString = getNextHome(player);


			//check if player has enough to purchase the new home
			if (cost > bal || homeNumber == 4 || homeString.equals("")) {
				player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 0.5f, 0.75f);
				return;
			} else {
				player.sendMessage(Utils.lore("<yellow>Purchased a new home slot! Use /sethome /home /delhome"));
				player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_YES, 0.5f, 0.75f);
			}
			VaultHook.econ.withdrawPlayer(player, cost);

			//set new home permission node
			VaultHook.perms.playerAdd(null, player, "essentials.sethome.multiple."+homeString);

			player.performCommand("menu");
		}));

		/*
		  Player Statistic Icons
		 */
		OutlinePane statistics = new OutlinePane(4, 3, 1, 2);

		//Creating main hand and offhand display
		OutlinePane hands = new OutlinePane(2, 3, 1, 2);
		for(ItemStack handItem : getHandIcons(player)) {
			hands.addItem(new GuiItem(handItem));
		}
		//Creating Armor Display
		OutlinePane armor = new OutlinePane(3, 2, 1, 4);
		for(ItemStack armorPiece : getArmorIcons(player)) {
			armor.addItem(new GuiItem(armorPiece));
		}
		//Creating level and exp display w/ click for more info
		statistics.addItem(new GuiItem(getLevelIcon(player)));

		/*
		  Player Games Icons
		 */
		OutlinePane games = new OutlinePane(5, 0, 3, 1);
		//Cookie clicker game
		games.addItem(new GuiItem(getCookieClickerIcon(), e -> player.performCommand("cookieclicker")));


		menu.addPane(vault);
		menu.addPane(enderChest);
		menu.addPane(warps);
		menu.addPane(armor);
		menu.addPane(hands);
		menu.addPane(utilities);
		menu.addPane(statistics);
		menu.addPane(games);

		this.menu = menu;
		return menu;
	}

	private static int getHomePermissionNumber(Player player) {
		int permission = 0;
		if (player.hasPermission("essentials.sethome.multiple.one")) {
			permission = 1;
		}
		if (player.hasPermission("essentials.sethome.multiple.two")) {
			permission = 2;
		}
		if (player.hasPermission("essentials.sethome.multiple.three")) {
			permission = 3;
		}
		if (player.hasPermission("essentials.sethome.multiple.four")) {
			permission = 4;
		}
		return permission;
	}

	private static String getNextHome(Player player) {
		String permission = "one";
		if (player.hasPermission("essentials.sethome.multiple.one")) {
			permission = "two";
		}
		if (player.hasPermission("essentials.sethome.multiple.two")) {
			permission = "three";
		}
		if (player.hasPermission("essentials.sethome.multiple.three")) {
			permission = "four";
		}
		if (player.hasPermission("essentials.sethome.multiple.four")) {
			permission = "";
		}
		return permission;
	}

	private static ItemStack getScrapperIcon(Player player) {
		ItemStack scrapperIcon = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta scrapperIconItemMeta = scrapperIcon.getItemMeta();

		if (player.hasPermission("siege.donor")) {
			scrapperIconItemMeta.displayName(Utils.lore("<yellow>SCRAPPER"));
			scrapperIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Sell items"));
				}
			});
		} else {
			scrapperIcon = new ItemStack(Material.BARRIER);
			scrapperIconItemMeta.displayName(Utils.lore("<red>SCRAPPER"));
			scrapperIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Sell items"));
					add(Utils.lore(""));
					add(Utils.lore("<red>/buy rank access"));
				}
			});
		}

		scrapperIcon.setItemMeta(scrapperIconItemMeta);
		return scrapperIcon;
	}

	private static ItemStack getGemRemover() {
		ItemStack gemIcon = new SimpleStrengthGem().getItem();
		ItemMeta gemIconItemMeta = gemIcon.getItemMeta();

		gemIconItemMeta.displayName(Utils.lore("<color:#ba72b2>Gem Remover"));
		gemIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Remover gems"));
				add(Utils.lore("<gray>from your gear"));
			}
		});

		gemIcon.setItemMeta(gemIconItemMeta);
		return gemIcon;
	}

	private static ItemStack getDropsIcon() {
		ItemStack dropsIcon = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta dropsIconItemMeta = dropsIcon.getItemMeta();
		dropsIconItemMeta.displayName(Utils.lore("<red>Drops"));
		dropsIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>View Item Drops!"));
			}
		});

		dropsIcon.setItemMeta(dropsIconItemMeta);
		return dropsIcon;
	}

	private static ItemStack getReRollIcon() {
		ItemStack dropsIcon = new ItemStack(Material.RESPAWN_ANCHOR);
		ItemMeta dropsIconItemMeta = dropsIcon.getItemMeta();
		dropsIconItemMeta.displayName(Utils.lore("<color:#B5EB5A>RE-ROLL"));
		dropsIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Re-roll your item's quality!"));
			}
		});

		dropsIcon.setItemMeta(dropsIconItemMeta);
		return dropsIcon;
	}

	private static ItemStack getVaultIcon(Player player) {
		ItemStack vaultIcon = new ItemStack(Material.CHEST);
		ItemMeta vaultIconItemMeta = vaultIcon.getItemMeta();

		if (player.hasPermission("siege.donor")) {
			vaultIconItemMeta.displayName(Utils.lore("<green>VAULT"));
			vaultIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access vaults"));
				}
			});
		} else {
			vaultIcon = new ItemStack(Material.BARRIER);
			vaultIconItemMeta.displayName(Utils.lore("<red>VAULT"));
			vaultIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access vaults"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red>/buy rank access"));
				}
			});
		}

		vaultIcon.setItemMeta(vaultIconItemMeta);
		return vaultIcon;
	}

	private static ItemStack geteChestIcon(Player player) {
		ItemStack enderChestIcon = new ItemStack(Material.ENDER_CHEST);
		ItemMeta enderChestIconItemMeta = enderChestIcon.getItemMeta();

		if (player.hasPermission("essentials.enderchest")) {
			enderChestIconItemMeta.displayName(Utils.lore("<light_purple>ENDER CHEST"));
			enderChestIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access Ender Chest"));
				}
			});
		} else {
			enderChestIcon = new ItemStack(Material.BARRIER);
			enderChestIconItemMeta = enderChestIcon.getItemMeta();
			enderChestIconItemMeta.displayName(Utils.lore("<red>ENDER CHEST"));
			enderChestIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access Ender Chest"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red>/buy rank access"));
				}
			});
		}

		enderChestIcon.setItemMeta(enderChestIconItemMeta);
		return enderChestIcon;
	}

	private static ItemStack getIconHome(Player player) {
		ItemStack icon = new ItemStack(Material.RED_BED);
		ItemMeta iconMeta = icon.getItemMeta();
		String homeNumber = getNextHome(player);
		int num = getHomePermissionNumber(player);
		int cost = (int) (Math.pow(num + 4, 3) * 1000);

		iconMeta.displayName(Utils.lore("<color:#E7C261>Purchase Home"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>Purchase home "+homeNumber));
				add(Utils.lore("<gray>Costs <yellow>"+String.format("%,d", cost)+" \u26C1"));
				add(Utils.lore(""));
				add(Utils.lore("<dark_gray>Allows you to save a"));
				add(Utils.lore("<dark_gray>location to teleport to"));
				add(Utils.lore(""));
				add(Utils.lore("<dark_gray>Usage: /sethome, /home"));
			}

		});

		icon.setItemMeta(iconMeta);
		return icon;
	}

	private static ItemStack[] getHandIcons(Player player) {
		ItemStack armorIcon = new ItemStack(Material.BARRIER);
		ItemMeta armorIconItemMeta = armorIcon.getItemMeta();
		armorIconItemMeta.displayName(Utils.lore("<red>EMPTY HAND"));
		armorIcon.setItemMeta(armorIconItemMeta);

		ArrayList<ItemStack> armorPieces = new ArrayList<>();

		if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
			armorPieces.add(player.getInventory().getItemInMainHand());
		} else {
			armorPieces.add(armorIcon);
		}

		if (player.getInventory().getItemInOffHand().getType() != Material.AIR) {
			armorPieces.add(player.getInventory().getItemInOffHand());
		} else {
			armorPieces.add(armorIcon);
		}

		ItemStack[] array = new ItemStack[armorPieces.size()];
		return armorPieces.toArray(array);
	}

	private static ItemStack[] getArmorIcons(Player player) {
		ItemStack armorIcon = new ItemStack(Material.BARRIER);
		ItemMeta armorIconItemMeta = armorIcon.getItemMeta();
		armorIconItemMeta.displayName(Utils.lore("<red>EMPTY"));
		armorIcon.setItemMeta(armorIconItemMeta);

		ArrayList<ItemStack> armorPieces = new ArrayList<>();

		if (player.getInventory().getHelmet() != null) {
			armorPieces.add(player.getInventory().getHelmet());
		} else {
			armorPieces.add(armorIcon);
		}

		if (player.getInventory().getChestplate() != null) {
			armorPieces.add(player.getInventory().getChestplate());
		} else {
			armorPieces.add(armorIcon);
		}

		if (player.getInventory().getLeggings() != null) {
			armorPieces.add(player.getInventory().getLeggings());
		} else {
			armorPieces.add(armorIcon);
		}

		if (player.getInventory().getBoots() != null) {
			armorPieces.add(player.getInventory().getBoots());
		} else {
			armorPieces.add(armorIcon);
		}

		ItemStack[] array = new ItemStack[armorPieces.size()];
		return armorPieces.toArray(array);
	}

	private static ItemStack getLevelIcon(Player player) {
		ItemStack levelIcon = new ItemStack(Material.EXPERIENCE_BOTTLE);
		ItemMeta levelIconItemMeta = levelIcon.getItemMeta();
		Pair< Short, Integer > pair = Levels.INSTANCE.blockingGetExpLevel(player);
		if (pair == null) pair = new Pair<>((short) 1, 0);

		float reqExp = Levels.INSTANCE.calculateRequiredExperience(pair.getFirst());
		double division = pair.getSecond() / reqExp;
		String levelPercent = Utils.round(Utils.round(division, 3) * 100, 2) + "%";

		int total = 0;
		for (int i = 2; i < pair.getFirst(); i++) {
			total = total + Levels.INSTANCE.calculateRequiredExperience((short) i);

		}
		total = total + pair.getSecond();
		String totalFormat = String.format("%,d", total);
		String expLeft = String.format("%,d", (int) (reqExp - pair.getSecond()));
		levelIconItemMeta.displayName(Utils.lore("<dark_purple>Level Stats"));
		Pair< Short, Integer > finalPair = pair;
		levelIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Level <reset><dark_purple>" + finalPair.getFirst()));
				add(Utils.lore("<gray>Exp % <reset><light_purple>" + levelPercent));
				add(Utils.lore("<gray>Exp <reset><light_purple>" + finalPair.getSecond()));
				add(Utils.lore("<gray>Exp to Next <reset><light_purple>" + expLeft));
				add(Utils.lore("<gray>Total Exp <reset><light_purple>" + totalFormat));
			}
		});
		levelIcon.setItemMeta(levelIconItemMeta);
		return levelIcon;
	}

	private static ItemStack getCookieClickerIcon() {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold>Cookie Clicker"));
		cookieClickerIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Click to Play"));
				add(Utils.lore("<gray>Cookie Clicker!"));
			}
		});

		cookieClickerIcon.setItemMeta(cookieClickerIconItemMeta);
		return cookieClickerIcon;
	}

}