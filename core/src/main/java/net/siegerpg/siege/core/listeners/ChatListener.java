package net.siegerpg.siege.core.listeners;

import io.papermc.paper.chat.*;
import io.papermc.paper.event.player.*;
import kotlin.Pair;
import net.kyori.adventure.audience.*;
import net.kyori.adventure.text.*;
import net.siegerpg.siege.core.miscellaneous.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.intellij.lang.annotations.*;
import org.jetbrains.annotations.*;

public class ChatListener implements Listener, ChatRenderer {

	@EventHandler
	public void playerChat(AsyncChatEvent e) {
		Player player = e.getPlayer();
		Component message = e.originalMessage();

		//get the level of the player
		Pair< Short, Integer > levelExp = Levels.INSTANCE.blockingGetExpLevel(player);
		int lvl = (levelExp != null ? levelExp.getFirst() : 0);

		//sets the level format of the message
		String lvlColor = LevelColor.Companion.getFromInt(lvl).getColor();
		String lvlFormatted = lvlColor+"[" + lvl + "]";

		String prefix = net.siegerpg.siege.core.miscellaneous.VaultHook.perms.getPrimaryGroup(player);

		//make necessary checks
		message = replaceText(message, "&k", "");
		message = replaceText(message, "%", "%%");
		if (isEmpty(message)) {
			player.sendMessage(Utils.lore("<red>You can not send a empty message!"));
			e.setCancelled(true);
			return;
		}

		//notify players if a player has typed their name
		notifyName(message);

		if (saidItem(message)) {

			ItemStack item = player.getInventory().getItemInMainHand();

			//if player has an empty hand
			if (item.getType() == Material.AIR) {
				player.sendMessage(Utils.lore("<red>You need an item to display!"));
				e.setCancelled(true);
				return;
			}

			//replace [item] with the displayed item
			Component msg = message;
			message = replaceText(msg, "[item]", itemMessage(item));
			Bukkit.getLogger().info("Message w/ [item] "+((TextComponent)message).content());
		}
		e.message(message);

		if (player.hasPermission("siege.text.format")) {
			e.renderer((source, sourceDisplayName, msg, viewer) ->
					           Utils.lore(lvlFormatted + " " + Utils.tacc(prefix) + " " +"<gray>"+
					                      ((TextComponent)sourceDisplayName).content())
					                .append(Utils.lore(" "))
					                .append(Utils.lore(((TextComponent)msg).content())));
		} else {
			e.renderer((source, sourceDisplayName, msg, viewer) ->
					           Utils.lore(lvlFormatted + " " + Utils.tacc(prefix) + " " +"<gray>"+
					                      ((TextComponent)sourceDisplayName).content())
					                .append(Utils.lore(" "))
					                .append(msg));
		}
	}

	private boolean saidItem(Component msg) {
		String message = ((TextComponent)msg).content();
		return message.contains("[item]");
	}
	
	private Component itemMessage(ItemStack item) {
		String name = item.getItemMeta().getDisplayName();
		if (name.equals("")) name = item.getI18NDisplayName();

		return Utils.lore("<yellow>" + item.getAmount() + "x " + name)
		            .hoverEvent(item);
	}

	private boolean isEmpty(Component msg) {
		String message = ((TextComponent)msg).content();
		String check = Utils.strip(message);
		return check.equalsIgnoreCase("") || check.equalsIgnoreCase(" ");
	}

	private static Component replaceText(Component message, @RegExp String match, String replacement) {
		return message.replaceText(
				TextReplacementConfig.builder()
				                     .match(match)
				                     .replacement(replacement).build());
	}

	private static Component replaceText(Component message, @RegExp String match, Component replacement) {
		return message.replaceText(
				TextReplacementConfig.builder()
				                     .match(match)
				                     .replacement(replacement).build());
	}

	private void notifyName(Component msg) {
		String message = ((TextComponent)msg).content();
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (message.contains(p.getName())) {
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1.0F, 2.0F);
			}
		}
	}


	@Override
	public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
		return Component.text().append(sourceDisplayName)
		                .append(Component.text(" "))
		                .append(message).build();
	}

}
