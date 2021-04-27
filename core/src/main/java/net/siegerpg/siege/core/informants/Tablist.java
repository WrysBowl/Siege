package net.siegerpg.siege.core.informants;

import net.siegemc.core.utils.VaultHook;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Tablist {
    public void tablistUpdate() {
        for (Player p : Bukkit.getOnlinePlayers()) {

            String header = Utils.tacc("\n" +
                    "&6&lSiegeRPG\n" +
                    "&6&oplay.SiegeRPG.net" +
                    "&f\n" +
                    "");

            String footer = Utils.tacc("\n" +
                    "&6Discord: &7/discord\n" +
                    "&6Website: &7/website\n" +
                    "&7There are &6&o"+Bukkit.getOnlinePlayers().size()+"&7 players online!\n" +
                    "");
            String tabName = Utils.tacc(VaultHook.perms.getPrimaryGroup(p) + " &7" + p.getName());
            p.setPlayerListName(tabName);
            p.setPlayerListHeader(header);
            p.setPlayerListFooter(footer);
        }
    }
}
