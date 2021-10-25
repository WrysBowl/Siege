package net.siegerpg.siege.core.utils;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.utils.VaultHook;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tablist {
    public static void tablistUpdate(final Player p) {

        final Component header = Utils.parse("\n" +
                "<gold><b>SiegeRPG</b>\n" +
                "<gold><i>play.SiegeRPG.net</i>" +
                "<white>\n" +
                "");

        final Component footer = Utils.parse("\n" +
                "<gold>Discord: <gray>/discord\n" +
                "<gold>Webstore: <gray>/webstore\n" +
                "<gray>There are <gold><underlined>"+Bukkit.getOnlinePlayers().size()+"<reset><gray> players online!\n" +
                "");
        final String tabName = Utils.tacc(VaultHook.perms.getPrimaryGroup(p) + " &7" + p.getName());
        p.setPlayerListName(tabName);
        p.sendPlayerListHeader(header);
        p.sendPlayerListFooter(footer);
    }
}
