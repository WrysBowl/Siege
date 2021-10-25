package net.siegerpg.siege.core.webstore.categories.ranks;

import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GladiatorRank extends WebstoreRanks {

    public GladiatorRank() {
        super("rank", "gladiator");
    }

    @SuppressWarnings("Deprecated")
    @Override
    public void completePurchase(final UUID uuid) {

        final Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        final String cmd = "lp user " + player.getName() + " parent add Gladiator";
        Bukkit.dispatchCommand(console, cmd);

        final int highestPV = Utils.getHighestPV(player);
        final int diff = 54 - highestPV;
        int addPV = highestPV+3;

        if (VaultHook.perms.playerInGroup(player, "warrior")) {
            addPV = highestPV+1;
            if (diff < 1) addPV = diff;
            final ConsoleCommandSender console4 = Bukkit.getServer().getConsoleSender();
            final String cmd3 = "lp user " + player.getName() + " parent remove warrior";
            Bukkit.dispatchCommand(console4, cmd3);
        } else {
            if (diff < 3) addPV = diff;
        }

        final ConsoleCommandSender console2 = Bukkit.getServer().getConsoleSender();
        final String cmd2 = "lp user " + player.getName() + " permission set cosmicvaults.amount."+addPV+" true global";
        Bukkit.dispatchCommand(console2, cmd2);

        Bukkit.broadcastMessage(Utils.tacc(""));
        Bukkit.broadcastMessage(Utils.tacc("  &b" + player.getName() + " has bought &2Gladiator &erank!"));
        Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
        Bukkit.broadcastMessage(Utils.tacc(""));
    }
}
