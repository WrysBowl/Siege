package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String level = "&8[&d"+ Levels.getLevel(player)+"&8]";
        String prefix = net.siegerpg.siege.core.utils.VaultHook.perms.getPrimaryGroup(player);
        String message = e.getMessage().replaceAll("&k", "");
        String check = Utils.strip(message);
        if (check.equalsIgnoreCase("") || check.equalsIgnoreCase(" ")) {
            e.getPlayer().sendMessage(Utils.tacc("You can not send a empty message!"));
            e.setCancelled(true);
            return;
        }
        e.setFormat(Utils.tacc(level + " " + prefix + " &7" + player.getName() + " &f" + message));
    }
}
