package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
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

            if (player.getInventory().getItemInMainHand().getType() != Material.AIR ) {

                String name = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

                List<String> lore = player.getInventory().getItemInMainHand().getItemMeta().getLore();

            }

        }
        e.setFormat(Utils.tacc(level + " " + prefix + " ") + Utils.tacc("&7%1$s &f%2$s"));
    }
}
