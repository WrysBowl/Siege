package net.siegerpg.siege.core.informants;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.utils.Utils;
import net.siegemc.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tablist {
    public void tablistUpdate() {
        for (Player p : Bukkit.getOnlinePlayers()) {

            Component header = Utils.parse("\n" +
                    "<gold><b>SiegeRPG</b>\n" +
                    "<gold><i>play.SiegeRPG.net</i>" +
                    "<white>\n" +
                    "");

            Component footer = Utils.parse("\n" +
                    "<gold>Discord: <gray>/discord\n" +
                    "<gold>Website: <gray>/website\n" +
                    "<gray>There are <gold><underlined>"+Bukkit.getOnlinePlayers().size()+"<gray> players online!\n" +
                    "");
            Component tabName = Utils.parse(VaultHook.perms.getPrimaryGroup(p) + " " + "<gray>" + p.getName());
            p.playerListName(tabName);
            p.sendPlayerListHeader(header);
            p.sendPlayerListFooter(footer);
        }
    }
}
