package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.utils.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent e) {
        String player = e.getPlayer().getDisplayName();
        String level = "&8[&d"+ Levels.getLevel(e.getPlayer())+"&8]";
        String prefix = VaultHook.perms.getPrimaryGroup(e.getPlayer());
        String message = e.getMessage().replaceAll("&k", "");
        String check = Utils.strip(message);
        if (check.equalsIgnoreCase("") || check.equalsIgnoreCase(" ")) {
            e.getPlayer().sendMessage(Utils.tacc("You can not send a empty message!"));
            e.setCancelled(true);
            return;
        }
        e.setFormat(Utils.tacc(level + " " + prefix + " &7%1$s »&f %2$s"));
        //e.setFormat(Utils.tacc(String.format("%s %s &7%s »&f %s", level, prefix, player, message)));
    }
}
