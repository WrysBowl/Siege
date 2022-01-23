package net.siegerpg.siege.core.commands.admin.questRewards;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.listeners.GoldExpListener;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class QuestReward {

	ItemStack[] items;
	String id;
	int gold;
	int exp;

	public QuestReward(ItemStack[] items, String id, int gold, int exp) {
		this.items = items;
		this.id = id;
		this.gold = gold;
		this.exp = exp;
	}

	public QuestReward() {
		this.items = new ItemStack[0];
		this.id = "";
		this.gold = 1;
		this.exp = 1;
	}

	public void extraReward(Player player) {}

	public void sendReward(Player player) {
		player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST_FAR, 1.0f, 5.0f);

		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#5DD5BD><bold><underlined>      Quest Reward      <reset>"));
		player.sendMessage(Utils.parse("<color:#5DD5BD>[Quest reward collected]"));
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
			final Component miniMessage = Utils.lore("<gray>\u27A5 " + item.getItemMeta().getDisplayName() + " <yellow>x" + item.getAmount()).hoverEvent(item);
			player.sendMessage(miniMessage);
			Utils.giveItem(player, item);
		}
		player.sendMessage("");
		player.sendMessage(Utils.parse("<color:#5DD5BD><underlined>                                  "));
		player.sendMessage("");
		extraReward(player);
	}

	public String getID() {
		return id;
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
