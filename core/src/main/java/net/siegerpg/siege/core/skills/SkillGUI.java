package net.siegerpg.siege.core.skills;

import com.github.stefvanschie.inventoryframework.gui.*;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.kyori.adventure.text.*;
import net.siegerpg.siege.core.items.types.misc.*;
import net.siegerpg.siege.core.miscellaneous.*;
import net.siegerpg.siege.core.skills.archer.*;
import net.siegerpg.siege.core.skills.mage.*;
import net.siegerpg.siege.core.skills.warrior.*;
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

	//TODO Make the GUI less laggy
	//TODO Finish the upgrade page for the GUI

	/**
	 * Menu
	 *         Displays all three classes IF the  player does not have one
	 *         Displays the player's skill tree IF the player has one
	 * Warrior/Archer/Mage GUIs
	 *         Each page is created with its own method
	 *         Displays skill points in top right
	 *         - Displays level of skill, and cost of upgrade if unlocked
	 *         Displays skill description, mana cost, and cooldown
	 *         Displays yellow pane if skill is unlockable (end of a branch)
	 *         Displays red pane if skill is locked
	 *         Displays green pane if skill has been unlocked
	 *         Tree-like structure of skill tree (this is going to be really tedious)
	 * Increase Level of Skill
	 *         - Displays level of skill
	 *         - Displays cost to upgrade
	 *         - Displays button to purchase skill upgrade, and confirmation afterward
	 *         - Update button (show the menu again)
	 */

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
		if (!(sender instanceof Player)) {
			Player player = Bukkit.getPlayer(args[0]);
			if (player == null) return false;
			try {
				String name = args[1]; //name of the skill 'skills Wrys Armory'
				boolean parent = args[2].equals("true");
				List<Skill> skills = getSkills(name, parent);

				//this is laggy
				getSkillPage(player, skills).show(player);

			} catch (Exception x) {
				return false;
			}
			return true;
		}
		if (args.length < 1) {
			Player player = (Player) sender;
			getClassMenu(player).show(player);
		}
		return true;
	}




	/**
	 * Gets the starting menu when player runs skill GUI command
	 * @return Starting menu
	 */
	public ChestGui getClassMenu(Player player) {
		/*
		- Displays all three classes IF the  player does not have one
	    - Displays the player's skill tree IF the player has one
	    */
		SkillClass skillClass = SkillData.getSkillClass(player);
		if (skillClass != null) {
			switch(skillClass) {
				case MAGE:
					return getMageGUI(player);
				case WARRIOR:
					return getWarriorGUI(player);
				case ARCHER:
					return getArcherGUI(player);
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
			getArcherGUI(player).show(player);
		}));

		menu.addPane(row);
		return menu;
	}

	/*
	GUIs
	 */

	private ChestGui getMageGUI(Player player) {

		ChestGui menu = new ChestGui(6, "Warrior Skills");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

		//fill background
		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		/*
		Branch creation
		 */
		OutlinePane invigorate = branchFiller(new OutlinePane(1, 2, 1, 4), player, new Invigorate());
		OutlinePane iceBolt = branchFiller(new OutlinePane(4, 2, 1, 4), player, new IceBolt());
		OutlinePane hex = branchFiller(new OutlinePane(7, 2, 1, 4), player, new Hex());

		menu.addPane(invigorate);
		menu.addPane(iceBolt);
		menu.addPane(hex);

		return menu;
	}

	private ChestGui getWarriorGUI(Player player) {

		ChestGui menu = new ChestGui(6, "Warrior Skills");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

		//fill background
		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		/*
		Branch creation
		 */
		OutlinePane criticalShot = branchFiller(new OutlinePane(2, 2, 1, 4), player, new Slash());
		OutlinePane achillesHeel = branchFiller(new OutlinePane(6, 2, 1, 4), player, new Lunge());

		menu.addPane(criticalShot);
		menu.addPane(achillesHeel);

		return menu;
	}

	private ChestGui getArcherGUI(Player player) {

		ChestGui menu = new ChestGui(6, "Archer Skills");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

		//fill background
		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		/*
		Branch creation
		 */
		OutlinePane criticalShot = branchFiller(new OutlinePane(2, 2, 1, 4), player, new CriticalShot());
		OutlinePane achillesHeel = branchFiller(new OutlinePane(6, 2, 1, 4), player, new AchillesHeel());

		menu.addPane(criticalShot);
		menu.addPane(achillesHeel);

		return menu;
	}

	private ChestGui getSkillPage(Player player, List<Skill> skills) {
		int length = skills.size();
		ChestGui skillPage = switch (length) {
			case 2 -> get1BranchGUI(player, skills);
			case 3 -> get2BranchGUI(player, skills);
			case 4 -> get3BranchGUI(player, skills);
			default -> getClassMenu(player);
		};

		//check if roots are contained in skills. If so, it should go to the menu page
		//TODO Figure out a way to go from first skill to main menu again
		//if (SkillTree.getRoots().contains(skills.get(0)) && length > 1) skillPage = getClassMenu(player);

		OutlinePane profile = new OutlinePane(8, 0, 1, 1);
		ItemStack profileIcon = getProfileIcon(player);
		profile.addItem(new GuiItem(profileIcon));

		return skillPage;
	}

	/*
	Work on the branches (TEST THEM)
	 */
	private ChestGui get1BranchGUI(Player player, List<Skill> skills) {

		//makes sure the amount of branches is 1
		if (skills.size() != 2) return getClassMenu(player);

		//identify class of the skill
		SkillClass skillClass = skills.get(0).skillClass;
		if (skillClass == null) return getClassMenu(player);

		//menu creation
		ChestGui menu = new ChestGui(6, skillClass.getName()+" Skills");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

		//fill background
		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		//identify the skills
		Skill mainSkill;
		Skill firstSkill;
		try {
			mainSkill = skills.get(0);
			firstSkill = skills.get(1);
		} catch (Exception x) {
			return getClassMenu(player);
		}


		/*
		Branch creation
		 */
		OutlinePane main = mainFiller(new OutlinePane(4, 0, 1, 3), player, mainSkill);
		OutlinePane branchOne = branchFiller(new OutlinePane(4, 3, 1, 3), player, firstSkill);

		menu.addPane(main);
		menu.addPane(branchOne);

		return menu;
	}
	private ChestGui get2BranchGUI(Player player, List<Skill> skills) {

		//makes sure the amount of branches is 2
		if (skills.size() != 3) return getClassMenu(player);

		//identify class of the skill
		SkillClass skillClass = skills.get(0).skillClass;
		if (skillClass == null) return getClassMenu(player);

		//menu creation
		ChestGui menu = new ChestGui(6, skillClass.getName()+" Skills");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

		//fill background
		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		//identify the skills
		Skill mainSkill;
		Skill firstSkill;
		Skill secondSkill;
		try {
			mainSkill = skills.get(0);
			firstSkill = skills.get(1);
			secondSkill = skills.get(2);
		} catch (Exception x) {
			return getClassMenu(player);
		}


		/*
		Branch creation
		 */
		OutlinePane main = mainFiller(new OutlinePane(4, 0, 1, 3), player, mainSkill);

		OutlinePane mainOne = new OutlinePane(3, 3, 2, 1);
		OutlinePane mainTwo = new OutlinePane(4, 3, 2, 1);

		OutlinePane branchOne = branchFiller(new OutlinePane(2, 3, 1, 3), player, firstSkill);
		OutlinePane branchTwo = branchFiller(new OutlinePane(6, 3, 1, 3), player, secondSkill);

		//main branch one creation
		ItemStack mainOnePane = getPane(player, mainSkill, true, true);
		mainOne.addItem(new GuiItem(mainOnePane));
		mainOne.setRepeat(true);

		//main branch two creation
		ItemStack mainTwoPane = getPane(player, mainSkill, true, true);
		mainTwo.addItem(new GuiItem(mainTwoPane));
		mainTwo.setRepeat(true);

		menu.addPane(main);
		menu.addPane(mainOne);
		menu.addPane(mainTwo);
		menu.addPane(branchOne);
		menu.addPane(branchTwo);

		return menu;
	}
	private ChestGui get3BranchGUI(Player player, List<Skill> skills) {

		//makes sure the amount of branches is 3
		if (skills.size() != 4) return getClassMenu(player);

		//identify class of the skill
		SkillClass skillClass = skills.get(0).skillClass;
		if (skillClass == null) return getClassMenu(player);

		//menu creation
		ChestGui menu = new ChestGui(6, skillClass.getName()+" Skills");
		menu.setOnGlobalClick(event -> event.setCancelled(true));

		//fill background
		OutlinePane background = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.displayName(Utils.lore(""));
		filler.setItemMeta(fillerMeta);
		background.addItem(new GuiItem(filler));
		background.setRepeat(true);
		menu.addPane(background);

		//identify the skills
		Skill mainSkill;
		Skill firstSkill;
		Skill secondSkill;
		Skill thirdSkill;
		try {
			mainSkill = skills.get(0);
			firstSkill = skills.get(1);
			secondSkill = skills.get(2);
			thirdSkill = skills.get(3);
		} catch (Exception x) {
			return getClassMenu(player);
		}

		/*
		Branch creation
		 */
		OutlinePane main = mainFiller(new OutlinePane(4, 0, 1, 3), player, mainSkill);

		OutlinePane mainOne = new OutlinePane(2, 3, 2, 1);
		OutlinePane mainTwo = new OutlinePane(5, 3, 2, 1);

		OutlinePane branchOne = branchFiller(new OutlinePane(1, 3, 1, 3), player, firstSkill);
		OutlinePane branchTwo = branchFiller(new OutlinePane(4, 3, 1, 3), player, secondSkill);
		OutlinePane branchThree = branchFiller(new OutlinePane(7, 3, 1, 3), player, thirdSkill);

		//main branch one creation
		ItemStack mainOnePane = getPane(player, mainSkill, true, true);
		mainOne.addItem(new GuiItem(mainOnePane));
		mainOne.setRepeat(true);

		//main branch two creation
		ItemStack mainTwoPane = getPane(player, mainSkill, true, true);
		mainTwo.addItem(new GuiItem(mainTwoPane));
		mainTwo.setRepeat(true);

		menu.addPane(main);
		menu.addPane(mainOne);
		menu.addPane(mainTwo);
		menu.addPane(branchOne);
		menu.addPane(branchTwo);
		menu.addPane(branchThree);

		return menu;
	}

	private OutlinePane mainFiller(OutlinePane outlinePane, Player player, Skill skill) {
		//third branch creation
		ItemStack pane = getPane(player, skill, true, false);
		ItemStack glass = getGlass(player, skill);
		outlinePane.addItem(new GuiItem(glass, inventoryClickEvent -> {
			getSkillUpgradeGUI(player, skill).show(player);
		}));
		int size = outlinePane.getHeight() * outlinePane.getLength();
		Skill finalSkill = SkillTree.getSkill(i -> i.getClass().equals(skill.getClass()));
		if (finalSkill == null) return outlinePane;
		for (int i = 0; size > i; i++) {
			outlinePane.addItem(new GuiItem(pane, inventoryClickEvent -> {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				String cmd = "skills "+player.getName()+" "+finalSkill.getIdentifier()+" true";
				Bukkit.getLogger().info(cmd);

				Bukkit.dispatchCommand(console, cmd);
			}));
		}

		return outlinePane;
	}

	private OutlinePane branchFiller(OutlinePane outlinePane, Player player, Skill skill) {
		//third branch creation
		ItemStack pane = getPane(player, skill, false, false);

		ItemStack glass = getGlass(player, skill);

		outlinePane.addItem(new GuiItem(glass, inventoryClickEvent -> {
			getSkillUpgradeGUI(player, skill).show(player);
		}));

		int size = outlinePane.getHeight() * outlinePane.getLength();
		Skill finalSkill = SkillTree.getSkill(i -> i.getClass().equals(skill.getClass()));
		if (finalSkill == null) return outlinePane;
		for (int i = 0; size > i; i++) {
			outlinePane.addItem(new GuiItem(pane, inventoryClickEvent -> {
				if (!pane.getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {
					ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
					String cmd = "skills "+player.getName()+" "+finalSkill.getIdentifier()+" false";
					Bukkit.dispatchCommand(console, cmd);
				}
			}));
		}
		return outlinePane;
	}

	private ChestGui getSkillUpgradeGUI(Player player, Skill skill) {

		Integer skillLevel = SkillData.getSkillLevel(player, skill);
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



		OutlinePane lastButton = new OutlinePane(0, 5, 1, 1);
		lastButton.addItem(new GuiItem(getIconBack(), inventoryClickEvent -> {
			getSkillPage(player, getParentSkills(skill)).show(player);
		}));

		menu.addPane(row);
		menu.addPane(lastButton);

		return menu;
	}




	/*
	ITEMS
	 */

	/**
	 * Gets the Mage icon
	 * @return Mage icon
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
				add(Utils.lore("<color:#DA97EC><underlined>                  "));
			}
		});
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	/**
	 * Gets the Warrior icon
	 * @return Warrior icon
	 */
	private static ItemStack getWarriorIcon() {
		ItemStack icon = new ItemStack(Material.IRON_SWORD);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#E35D73><bold><underlined>Warrior"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View skills"));
				add(Utils.lore("<yellow>(Right Click)"));
				add(Utils.lore("<color:#E35D73><underlined>               "));
			}
		});
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	/**
	 * Gets the Archer icon
	 * @return Archer icon
	 */
	private static ItemStack getArcherIcon() {
		ItemStack icon = new ItemStack(Material.BOW);
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<color:#97CEEC><bold><underlined>Archer"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(Utils.lore("<gray>View skills"));
				add(Utils.lore("<yellow>Right Click"));
				add(Utils.lore("<color:#97CEEC><underlined>                 "));
			}
		});
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	/**
	 * Gets the profile icon. Displays gold and skill points
	 * @return Profile icon
	 */
	private static ItemStack getProfileIcon(Player player) {
		//Creating Next Icon
		ItemStack icon = new ItemStack(Material.LEGACY_SKULL_ITEM);
		SkullMeta iconMeta = (SkullMeta) icon.getItemMeta();
		iconMeta.setOwner(player.getName());

		int gold = (int) VaultHook.econ.getBalance(player);
		int skillPoints = SkillData.getSkillPoints(player);
		Component goldMessage = Utils.lore("<yellow>"+String.format("%,d", gold) +" \u26C1");
		Component pointsMessage = Utils.lore("<aqua>"+String.format("%,d", skillPoints) +" \u272A");

		iconMeta.displayName(Utils.lore("<color:#60cc9d><bold>PROFILE"));
		iconMeta.lore(new ArrayList<>() {
			{
				add(Utils.lore(""));
				add(goldMessage);
				add(pointsMessage);
				add(Utils.lore("<color:#60cc9d><underlined>                 "));
			}
		});

		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	/**
	 * Gets the 'forwards' icon
	 * @return Forwards icon
	 */
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
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	/**
	 * Gets the 'back' icon
	 * @return Back icon
	 */
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
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);
		return icon;
	}

	/**
	 * Get the status of a skill relevant to the player
	 * @return Green/Yellow/Red
	 */
	private Color getSkillStatus(Player player, Skill skill) {
		Color icon = Color.RED;
		if (SkillData.hasSkillUnlocked(player, skill)) {
			icon = Color.GREEN;
		} else if (SkillData.canUnlockSkill(player, skill)) {
			icon = Color.YELLOW;
		}
		return icon;
	}

	private ItemStack getPane(Player player, Skill skill, boolean main, boolean connector) {
		Color status = getSkillStatus(player, skill);
		ItemStack icon = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta iconMeta = icon.getItemMeta();
		String name = "";

		//Get material type & color of icon
		if (Color.GREEN.equals(status)) {
			icon.setType(Material.GREEN_STAINED_GLASS_PANE);
			name += "<green>";
		} else if (Color.YELLOW.equals(status)) {
			icon.setType(Material.YELLOW_STAINED_GLASS_PANE);
			name += "<yellow>";
		} else if (Color.RED.equals(status)) {
			icon.setType(Material.RED_STAINED_GLASS_PANE);
			name += "<red>";
		}

		//set the name
		if (!connector) {
			if (main) {
				name += "   \u25B2";
			} else {
				name += "   \u25BC";
			}
			iconMeta.lore(new ArrayList<>() {
				{
					add(Utils.lore("<gray>(Click)"));
				}
			});
		}
		iconMeta.displayName(Utils.lore(name));


		//gray-stained glass pane
		Skill finalSkill = SkillTree.getSkill(i -> i.getClass().equals(skill.getClass()));
		if (finalSkill != null) {
			if (finalSkill.getChildren().isEmpty()) {
				icon.setType(Material.GRAY_STAINED_GLASS_PANE);
				iconMeta.displayName(Utils.lore(""));
				iconMeta.lore(new ArrayList<>());
			}
		}

		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);

		return icon;
	}

		/**
		 * Gets the item representing the status of the skill in a player's skill tree
		 * @return itemStack
		 */
	@NotNull
	private ItemStack getGlass(Player player, Skill skill) {

		//Creating Icon Status
		Color status = getSkillStatus(player, skill);
		int level = SkillData.getSkillLevel(player, skill);
		ItemStack icon = new ItemStack(Material.KNOWLEDGE_BOOK);
		int cost = skill.getGoldCost(level);

		//Get material type & color of icon
		if (Color.GREEN.equals(status)) {
			icon.setType(Material.GREEN_STAINED_GLASS);
		} else if (Color.YELLOW.equals(status)) {
			icon.setType(Material.YELLOW_STAINED_GLASS);
		} else {
			icon.setType(Material.RED_STAINED_GLASS);
		}

		//Skill Information
		ItemMeta iconMeta = icon.getItemMeta();
		iconMeta.displayName(Utils.lore("<gold>"+skill.getName(level)));
		ArrayList<Component> lore = new ArrayList<>();

		lore.add(Utils.lore(" "));
		lore.add(Utils.lore(" <gray>Cost <yellow>"+String.format("%,d", cost) + " \u26C1"));
		lore.add(Utils.lore(" <gray>Cooldown <aqua>"+skill.getCooldown(level).getSeconds()));
		lore.add(Utils.lore(" <gray>Mana <color:#72E5D3>"+skill.getManaCost(level)));
		lore.add(Utils.lore(" "));

		int length = Math.max(skill.getName(level).length(), 16);
		for (String string : Utils.getTextArray(skill.description, length)) {
			lore.add(Utils.lore("<r><dark_gray>"+string));
		}
		lore.add(Utils.lore(" "));
		lore.add(Utils.lore("<yellow><bold>CLICK TO VIEW"));


		iconMeta.lore(lore);
		iconMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		icon.setItemMeta(iconMeta);

		return icon;
	}

	/*
	UTILITIES
	 */

	private List<Skill> getChildSkills(Skill skill) {
		//collect the skills
		List<Skill> listOfSkills = new LinkedList<Skill>();
		Skill finalSkill = SkillTree.getSkill(i -> i.getClass().equals(skill.getClass()));
		if (finalSkill != null) {
			listOfSkills.add(finalSkill);
			listOfSkills.addAll(finalSkill.getChildren());
		}
		return listOfSkills;
	}

	private List<Skill> getParentSkills(Skill skill) {
		//collect the skills
		List<Skill> listOfSkills = new LinkedList<Skill>();
		Skill newSkill = SkillTree.getSkill(i -> i.getClass().equals(skill.getClass()));

		if (newSkill == null) return listOfSkills;

		if (newSkill.getParent() == null) return listOfSkills;

		Skill finalSkill = SkillTree.getSkill(i -> i.getClass().equals(newSkill.getParent().getClass()));
		if (finalSkill != null) {

			listOfSkills.add(finalSkill);
			listOfSkills.addAll(finalSkill.getChildren());
		}
		return listOfSkills;
	}

	private List<Skill> getSkills(String name, boolean parent) {
		//collect the skills
		List<Skill> listOfSkills = new LinkedList<Skill>();
		Skill skill = SkillTree.getSkill(i -> i.getIdentifier().equals(name));

		if (skill == null) return listOfSkills;

		if (parent) {
			listOfSkills.addAll(getParentSkills(skill));
		} else {
			listOfSkills.addAll(getChildSkills(skill));
		}
		return listOfSkills;
	}
}
