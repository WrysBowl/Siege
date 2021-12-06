package net.siegerpg.siege.core.commands;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import kotlin.Pair;
import net.siegerpg.siege.core.commands.admin.StatUpgrade;
import net.siegerpg.siege.core.fishing.catches.loot.gems.CrackedStrength;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.PristineStrengthGem;
import net.siegerpg.siege.core.items.implemented.misc.statgems.strengthGems.SimpleStrengthGem;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.listeners.NPC.GemRemover;
import net.siegerpg.siege.core.listeners.NPC.Herbert;
import net.siegerpg.siege.core.listeners.NPC.MeraTransit;
import net.siegerpg.siege.core.listeners.tasks.GoldReward;
import net.siegerpg.siege.core.miscellaneous.Levels;
import net.siegerpg.siege.core.miscellaneous.Scoreboard;
import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.VaultHook;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu implements CommandExecutor {

	private ChestGui menu;
	private static final Location farmLocation = new Location(Bukkit.getWorld("Hilly_Woods"),188.5, 61, -122.5, -90, 0);
	private static final Location villageLocation = new Location(Bukkit.getWorld("Hilly_Woods"),205.5, 93, 217.5, 180, 0);

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		Player player = (Player) sender;

		player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
		Menu instance = new Menu();
		this.menu = instance.getMenu(player);
		this.menu.show(player);
		return true;
	}

	private ChestGui getMenu(Player player) {
		//Menu
		ChestGui menu = new ChestGui(6, "Menu");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

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
		utilities.addItem(new GuiItem(getScrapperIcon(player), e -> new Herbert(player)));
		//Creating Gem Remover
		utilities.addItem(new GuiItem(getGemRemover(player), e -> new GemRemover().openInventory(player)));
		//Creating Stat Upgrade
		utilities.addItem(new GuiItem(getStatUpgradeIcon(player), e -> {
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			String command = "statUpgrade "+player.getName();
			Bukkit.dispatchCommand(console, command);
		}));
		//Creating Drops
		utilities.addItem(new GuiItem(getDropsIcon(), e -> new DropTable().getStartMenu(player).show(player)));

		/*
		  Warp Icons
		 */
		OutlinePane warps = new OutlinePane(8, 2, 1, 4);
		//Creating hub TP
		warps.addItem(new GuiItem(getHubTeleportIcon(), e -> player.performCommand("h")));
		//Creating Mera
		warps.addItem(new GuiItem(getMeraIcon(player), e -> player.openInventory(new MeraTransit().getGUIWorldTransit(player))));
		//Creating Farm TP
		warps.addItem(new GuiItem(getFarmTeleportIcon(player), e -> {
			Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);
			if (expLevel == null) expLevel = new Pair<>((short) 1, 0);
			if (expLevel.getFirst() >=5) player.teleport(farmLocation);
		}));
		//Creating Village TP
		warps.addItem(new GuiItem(getVillageTeleportIcon(player), e -> {
			Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);
			if (expLevel == null) expLevel = new Pair<>((short) 1, 0);
			if (expLevel.getFirst() >=15) player.teleport(villageLocation);
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
		//Creating gold display w/ gold milestone
		statistics.addItem(new GuiItem(getGoldStatusIcon(player)));

		/*
		  Player Games Icons
		 */
		OutlinePane games = new OutlinePane(5, 0, 3, 1);
		//Cookie clicker game
		statistics.addItem(new GuiItem(getCookieClickerIcon()));


		menu.addPane(vault);
		menu.addPane(enderChest);
		menu.addPane(warps);
		menu.addPane(armor);
		menu.addPane(hands);
		menu.addPane(utilities);
		menu.addPane(statistics);

		this.menu = menu;
		return menu;
	}

	private ItemStack getScrapperIcon(Player player) {
		ItemStack scrapperIcon = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta scrapperIconItemMeta = scrapperIcon.getItemMeta();

		if (player.hasPermission("siege.donor")) {
			scrapperIconItemMeta.displayName(Utils.lore("<yellow><bold>SCRAPPER"));
			scrapperIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Sell items"));
				}
			});
		} else {
			scrapperIcon = new ItemStack(Material.BARRIER);
			scrapperIconItemMeta.displayName(Utils.lore("<red><bold>SCRAPPER"));
			scrapperIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Sell items"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red><bold>/buy rank access"));
				}
			});
		}

		scrapperIcon.setItemMeta(scrapperIconItemMeta);
		return scrapperIcon;
	}

	private ItemStack getStatUpgradeIcon(Player player) {
		ItemStack statUpgradeIcon = new ItemStack(Material.ANVIL);
		ItemMeta statUpgradeIconItemMeta = statUpgradeIcon.getItemMeta();

		if (player.hasPermission("siege.donor")) {
			statUpgradeIconItemMeta.displayName(Utils.lore("<aqua><bold>Stat Upgrade"));
			statUpgradeIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Click to upgrade"));
					add(Utils.lore("<gray>your stats!"));
				}
			});
		} else {
			statUpgradeIcon = new ItemStack(Material.BARRIER);
			statUpgradeIconItemMeta.displayName(Utils.lore("<red><bold>Stat Upgrade"));
			statUpgradeIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Click to upgrade"));
					add(Utils.lore("<gray>your stats!"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red><bold>/buy rank access"));
				}
			});
		}

		statUpgradeIcon.setItemMeta(statUpgradeIconItemMeta);
		return statUpgradeIcon;
	}

	private ItemStack getGemRemover(Player player) {
		ItemStack gemIcon = new SimpleStrengthGem().getItem();
		ItemMeta gemIconItemMeta = gemIcon.getItemMeta();

		if (player.hasPermission("siege.donor")) {
			gemIconItemMeta.displayName(Utils.lore("<light_purple><bold>Gem Remover"));
			gemIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Remover gems"));
					add(Utils.lore("<gray>from your gear"));
				}
			});
		} else {
			gemIcon = new ItemStack(Material.BARRIER);
			gemIconItemMeta.displayName(Utils.lore("<red><bold>Gem Remover"));
			gemIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Remove gems"));
					add(Utils.lore("<gray>from your gear"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red><bold>/buy rank access"));
				}
			});
		}

		gemIcon.setItemMeta(gemIconItemMeta);
		return gemIcon;
	}

	private static ItemStack getDropsIcon() {
		ItemStack dropsIcon = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta dropsIconItemMeta = dropsIcon.getItemMeta();
		dropsIconItemMeta.displayName(Utils.lore("<red><bold>DROPS"));
		dropsIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>View Item Drops!"));
			}
		});

		dropsIcon.setItemMeta(dropsIconItemMeta);
		return dropsIcon;
	}

	private ItemStack getMeraIcon(Player player) {

		ItemStack mera = new ItemStack(Material.SKELETON_SKULL);
		ItemMeta meraMeta = mera.getItemMeta();
		meraMeta.displayName(Utils.lore("<gray><bold>Last Death"));

		if (player.hasPermission("siege.donor")) {
			meraMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Teleport to last death"));
				}
			});
		} else {
			mera = new ItemStack(Material.BARRIER);
			meraMeta.displayName(Utils.lore("<red><bold>Last Death"));
			meraMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Teleport to last death"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red><bold>/buy rank access"));
				}
			});
		}

		mera.setItemMeta(meraMeta);
		return mera;
	}

	private static ItemStack getVaultIcon(Player player) {
		ItemStack vaultIcon = new ItemStack(Material.CHEST);
		ItemMeta vaultIconItemMeta = vaultIcon.getItemMeta();

		if (player.hasPermission("siege.donor")) {
			vaultIconItemMeta.displayName(Utils.lore("<green><bold>VAULT"));
			vaultIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access vaults"));
				}
			});
		} else {
			vaultIcon = new ItemStack(Material.BARRIER);
			vaultIconItemMeta.displayName(Utils.lore("<red><bold>VAULT"));
			vaultIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access vaults"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red><bold>/buy rank access"));
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
			enderChestIconItemMeta.displayName(Utils.lore("<light_purple><bold>ENDER CHEST"));
			enderChestIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access Ender Chest"));
				}
			});
		} else {
			enderChestIcon = new ItemStack(Material.BARRIER);
			enderChestIconItemMeta = enderChestIcon.getItemMeta();
			enderChestIconItemMeta.displayName(Utils.lore("<red><bold>ENDER CHEST"));
			enderChestIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Access Ender Chest"));
					add(Utils.lore(""));
					add(Utils.lore("<gray>See in person"));
					add(Utils.lore("<red><bold>/buy rank access"));
				}
			});
		}

		enderChestIcon.setItemMeta(enderChestIconItemMeta);
		return enderChestIcon;
	}

	private static ItemStack getHubTeleportIcon() {
		ItemStack hubTPIcon = new ItemStack(Material.ENDER_PEARL);
		ItemMeta hubTPIconItemMeta = hubTPIcon.getItemMeta();
		hubTPIconItemMeta.displayName(Utils.lore("<dark_green><bold>HUB"));
		hubTPIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Teleport to Hub"));
			}
		});

		hubTPIcon.setItemMeta(hubTPIconItemMeta);
		return hubTPIcon;
	}

	private static ItemStack getFarmTeleportIcon(Player player) {
		ItemStack farmIcon = new ItemStack(Material.WHEAT);
		ItemMeta farmIconItemMeta = farmIcon.getItemMeta();
		Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);
		if (expLevel == null) expLevel = new Pair<>((short) 1, 0);

		if (expLevel.getFirst()>=5) {
			farmIconItemMeta.displayName(Utils.lore("<yellow><bold>FARM"));
			farmIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Teleport to Farm"));
				}
			});
		} else {
			farmIcon = new ItemStack(Material.BARRIER);
			farmIconItemMeta = farmIcon.getItemMeta();
			farmIconItemMeta.displayName(Utils.lore("<red><bold>FARM"));
			farmIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Teleport to Farm"));
					add(Utils.lore(""));
					add(Utils.lore("<red>Level 5 Required"));
				}
			});
		}

		farmIcon.setItemMeta(farmIconItemMeta);
		return farmIcon;
	}

	private static ItemStack getVillageTeleportIcon(Player player) {
		ItemStack villageIcon = new ItemStack(Material.EMERALD);
		ItemMeta villageIconItemMeta = villageIcon.getItemMeta();
		Pair< Short, Integer > expLevel = Levels.INSTANCE.blockingGetExpLevel(player);
		if (expLevel == null) expLevel = new Pair<>((short) 1, 0);

		if (expLevel.getFirst()>=15) {
			villageIconItemMeta.displayName(Utils.lore("<green><bold>VILLAGE"));
			villageIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Teleport to Village"));
				}
			});
		} else {
			villageIcon = new ItemStack(Material.BARRIER);
			villageIconItemMeta = villageIcon.getItemMeta();
			villageIconItemMeta.displayName(Utils.lore("<red><bold>VILLAGE"));
			villageIconItemMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>Teleport to Village"));
					add(Utils.lore(""));
					add(Utils.lore("<red>Level 15 Required"));
				}
			});
		}

		villageIcon.setItemMeta(villageIconItemMeta);
		return villageIcon;
	}

	private static ItemStack[] getHandIcons(Player player) {
		ItemStack armorIcon = new ItemStack(Material.BARRIER);
		ItemMeta armorIconItemMeta = armorIcon.getItemMeta();
		armorIconItemMeta.displayName(Utils.lore("<red><bold>EMPTY HAND"));
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
		armorIconItemMeta.displayName(Utils.lore("<red><bold>EMPTY"));
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
		levelIconItemMeta.displayName(Utils.lore("<dark_purple><bold>Level Stats"));
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

	private static ItemStack getGoldStatusIcon(Player player) {
		ItemStack goldIcon = new ItemStack(Material.SUNFLOWER);
		ItemMeta goldIconItemMeta = goldIcon.getItemMeta();
		goldIconItemMeta.displayName(Utils.lore("<yellow><bold>GOLD"));
		double goldDivision = Utils.round(((double) GoldReward.serverGold / GoldReward.goldRequirement) * 100, 1);

		goldIconItemMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore("<gray>Gold <yellow>"+String.format("%,d", (int) VaultHook.econ.getBalance(player))));
				add(Utils.lore(""));
				add(Utils.lore("<yellow>Gold Party"));
				add(Utils.lore("<gray>Gold Reward <yellow>+" + String.format("%,d", GoldReward.serverGoldReward)));
				add(Utils.lore("<gray>Gold Progress <yellow>" + goldDivision + "%"));
				add(Utils.lore("<gray>Gold Milestone <yellow>" + String.format("%,d", GoldReward.goldRequirement)));
				add(Utils.lore("<gray>Gold Collected <yellow>" + String.format("%,d", GoldReward.serverGold)));
			}
		});

		goldIcon.setItemMeta(goldIconItemMeta);
		return goldIcon;
	}

	private static ItemStack getCookieClickerIcon() {
		ItemStack cookieClickerIcon = new ItemStack(Material.COOKIE);
		ItemMeta cookieClickerIconItemMeta = cookieClickerIcon.getItemMeta();
		cookieClickerIconItemMeta.displayName(Utils.lore("<gold><bold>Cookie Clicker"));
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