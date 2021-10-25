package net.siegerpg.siege.core.webstore.categories.ranks;

import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class WarriorRank extends WebstoreRanks {

    public WarriorRank() {
        super("rank", "warrior");
    }

    @SuppressWarnings("Deprecated")
    @Override
    public void completePurchase(final UUID uuid) {

        final Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        final String cmd = "lp user " + player.getName() + " parent add Warrior";
        Bukkit.dispatchCommand(console, cmd);

        final int highestPV = Utils.getHighestPV(player);
        final int diff = 54 - highestPV;
        int addPV = highestPV+2;
        if (diff < 2) addPV = diff;

        final ConsoleCommandSender console2 = Bukkit.getServer().getConsoleSender();
        final String cmd2 = "lp user " + player.getName() + " permission set cosmicvaults.amount."+addPV+" true global";
        Bukkit.dispatchCommand(console2, cmd2);

        Bukkit.broadcastMessage(Utils.tacc(""));
        Bukkit.broadcastMessage(Utils.tacc("  &b" + player.getName() + " has bought &2Warrior &erank!"));
        Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
        Bukkit.broadcastMessage(Utils.tacc(""));
    }
}
