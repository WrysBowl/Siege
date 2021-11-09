package net.siegerpg.siege.core.listeners;

import kotlin.Pair;
import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.DropUtils;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ChatListener implements Listener {

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        Pair<Short, Integer> levelExp = Levels.INSTANCE.blockingGetExpLevel(player);
        String level = "&8[&d" + (levelExp != null ? levelExp.getFirst() : 0) + "&8]";
        String prefix = net.siegerpg.siege.core.utils.VaultHook.perms.getPrimaryGroup(player);
        String message = e.getMessage().replaceAll("&k", "");
        String check = Utils.strip(message);

        if (check.equalsIgnoreCase("") || check.equalsIgnoreCase(" ")) {
            e.getPlayer().sendMessage(Utils.tacc("You can not send a empty message!"));
            e.setCancelled(true);
            return;
        }

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (message.contains(p.getName())) {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HARP, 1.0F, 2.0F);
            }
        }

        if (message.contains("[item]")) {
            e.setCancelled(true);
            if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                ItemStack item = player.getInventory().getItemInMainHand();
                String name = item.getItemMeta().getDisplayName();
                if (name.equals("")) name = player.getInventory().getItemInMainHand().getI18NDisplayName();
                Component miniMessage = Utils.lore("<yellow>" + item.getAmount() + "x " + name).hoverEvent(item);
                Component prefixes = Utils.lore(Utils.tacc(level + " " + prefix + " &7" + player.getName() + " &f"));
                Component actualMessage = Utils.lore(Utils.tacc(e.getMessage())).replaceText("[item]", miniMessage);
                Bukkit.getServer().sendMessage(prefixes.append(actualMessage));
                return;
            }
            player.sendMessage(Utils.lore("<red>You need an item to display!"));
        }
        if (player.hasPermission("siege.text.format")) {
            e.setFormat(Utils.tacc(level + " " + prefix + " ") + Utils.tacc("&7%1$s &f"+message));
        } else e.setFormat(Utils.tacc(level + " " + prefix + " ") + Utils.tacc("&7%1$s &f%2$s"));
    }
}
