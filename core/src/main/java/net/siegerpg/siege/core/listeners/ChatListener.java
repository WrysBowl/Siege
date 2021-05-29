package net.siegerpg.siege.core.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.chat.BaseComponent;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ChatListener implements Listener {

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String level = "&8[&d"+ Levels.INSTANCE.getExpLevel(player).getFirst()+"&8]";
        String prefix = net.siegerpg.siege.core.utils.VaultHook.perms.getPrimaryGroup(player);
        String message = e.getMessage().replaceAll("&k", "");
        String check = Utils.strip(message);
        if (check.equalsIgnoreCase("") || check.equalsIgnoreCase(" ")) {
            e.getPlayer().sendMessage(Utils.tacc("You can not send a empty message!"));
            e.setCancelled(true);
            return;
        }
        if (message.contains("[item]")) {
            e.setCancelled(true);
            if (player.getInventory().getItemInMainHand().getType() != Material.AIR ) {
                String name = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                if (name.equals("")) name = player.getInventory().getItemInMainHand().getI18NDisplayName();
                List<String> lore = player.getInventory().getItemInMainHand().getItemMeta().getLore();
                StringBuilder itemDisplay = new StringBuilder(name + "\n");
                if (lore != null) {
                    for (String line : lore) {
                        itemDisplay.append(line).append("\n");
                    }
                }
                itemDisplay.deleteCharAt(itemDisplay.length()-1);
                Component miniMessage = MiniMessage.get().parse("<hover:show_text:<itemDisplay>><gold><bold>[ITEM]</bold>", "itemDisplay", itemDisplay.toString());
                Component prefixes = Utils.lore(Utils.tacc(level + " " + prefix + " &7" + player.getName() + " &f"));
                Component actualMessage = Utils.lore(e.getMessage()).replaceText("[item]", miniMessage);
                Bukkit.getServer().sendMessage(prefixes.append(actualMessage));
                return;
            }
            player.sendMessage(Utils.lore("<red>You need an item to display!"));
        }
        e.setFormat(Utils.tacc(level + " " + prefix + " ") + Utils.tacc("&7%1$s &f%2$s"));
    }
}
