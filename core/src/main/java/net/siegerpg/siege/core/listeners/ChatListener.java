package net.siegerpg.siege.core.listeners;

import kotlin.Pair;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

public class ChatListener implements Listener {

    @EventHandler
    public void playerChat(final AsyncPlayerChatEvent e) {
        final Player player = e.getPlayer();
        final Pair<Short, Integer> levelExp = Levels.INSTANCE.blockingGetExpLevel(player);
        final String level = "&8[&d" + (levelExp != null ? levelExp.getFirst() : 0) + "&8]";
        final String prefix = net.siegerpg.siege.core.utils.VaultHook.perms.getPrimaryGroup(player);
        final String message = e.getMessage().replaceAll("&k", "");
        final String check = Utils.strip(message);
        if (check.equalsIgnoreCase("") || check.equalsIgnoreCase(" ")) {
            e.getPlayer().sendMessage(Utils.tacc("You can not send a empty message!"));
            e.setCancelled(true);
            return;
        }
        if (message.contains("[item]")) {
            e.setCancelled(true);
            if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                final ItemStack item = player.getInventory().getItemInMainHand();
                String name = item.getItemMeta().getDisplayName();
                if (name.equals("")) name = player.getInventory().getItemInMainHand().getI18NDisplayName();
                final Component miniMessage = Utils.lore("<bold><yellow>" + item.getAmount() + "x " + name).hoverEvent(item);
                final Component prefixes = Utils.lore(Utils.tacc(level + " " + prefix + " &7" + player.getName() + " &f"));
                final Component actualMessage = Utils.lore(e.getMessage()).replaceText("[item]", miniMessage);
                Bukkit.getServer().sendMessage(prefixes.append(actualMessage));
                return;
            }
            player.sendMessage(Utils.lore("<red>You need an item to display!"));
        }
        e.setFormat(Utils.tacc(level + " " + prefix + " ") + Utils.tacc("&7%1$s &f%2$s"));
    }
}
