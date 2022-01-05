package net.siegerpg.siege.core.commands.admin.dailyRewards;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DailyReward {

	ItemStack[] items;
	int day;
	int gold;
	int exp;

	public DailyReward(ItemStack[] items, int day, int gold, int exp) {
		this.items = items;
		this.day = day;
		this.gold = gold;
		this.exp = exp;
	}

	public DailyReward() {
		this.items = null;
		this.day = 1;
		this.gold = 1;
		this.exp = 1;
	}

	public void sendReward(Player player) {
		player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST_FAR, 1.0f, 5.0f);

		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#86DFC6><bold><underlined>      Daily Reward      <reset>"));
		player.sendMessage(Utils.parse("<color:#B1F1DF>Day "+day+" reward collected"));
		player.sendMessage("");
		if (gold > 0) {
			player.sendMessage(Utils.parse("<yellow>+ "+String.format("%,d", gold)+" \u26C1"));
			GoldExpListener.giveGold(player, gold);
		}
		if (exp > 0) {
			player.sendMessage(Utils.parse("<light_purple>+ "+String.format("%,d", exp)+" \u2742"));
			GoldExpListener.giveGold(player, exp);
		}
		for (ItemStack item : items) {
			final Component miniMessage = Utils.lore("<gray>\u27A5 " + item.getItemMeta().getDisplayName()).hoverEvent(item);
			player.sendMessage(miniMessage);
			Utils.giveItem(player, item);
		}
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#86DFC6><underlined>                                  "));
		player.sendMessage("");
	}

	public int getDay() {
		return day;
	}

	public int getExp() {
		return exp;
	}

	public int getGold() {
		return gold;
	}

	public ItemStack[] getItems() {
		return items;
	}



}
