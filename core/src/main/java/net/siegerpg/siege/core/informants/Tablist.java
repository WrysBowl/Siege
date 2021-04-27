package net.siegerpg.siege.core.informants;

import net.kyori.adventure.text.Component;
import net.siegemc.core.utils.VaultHook;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tablist {
    public void tablistUpdate() {
        for (Player p : Bukkit.getOnlinePlayers()) {

            Component header = Utils.parse("\n" +
                    "<gold><b>SiegeRPG\n" +
                    "<gold><b>play.SiegeRPG.net" +
                    "<white>\n" +
                    "");

            Component footer = Utils.parse("\n" +
                    "<gold>Discord: <gray>/discord\n" +
                    "<gold>Website: <gray>/website\n" +
                    "<gray>There are <gold><i>"+Bukkit.getOnlinePlayers().size()+"<gray> players online!\n" +
                    "");
            Component tabName = Utils.parse(VaultHook.perms.getPrimaryGroup(p) + " <gray>" + p.getName());
            p.playerListName(tabName);
            p.sendPlayerListHeader(header);
            p.sendPlayerListFooter(footer);
        }
    }
}
