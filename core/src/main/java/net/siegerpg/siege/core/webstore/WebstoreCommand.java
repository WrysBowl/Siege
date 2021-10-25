package net.siegerpg.siege.core.webstore;

import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import net.siegerpg.siege.core.webstore.categories.WebstorePackage;
import net.siegerpg.siege.core.webstore.categories.boosters.WebstoreBoosters;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class WebstoreCommand extends WebstoreUtils implements CommandExecutor {

    //Make sure to allow arg-1 to also be a player

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (sender instanceof Player) {
            ((Player) sender).performCommand("craftingstore:buy");
            return false;
        }
        if (args.length < 2) return false; //check if command was used properly

        final UUID uuid;
        Player player;

        //Parse UUID as a player and check if player is online
        try {
            player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                uuid = UUID.fromString(args[0]);
                player = Bukkit.getPlayer(uuid);
            } else {
                uuid = player.getUniqueId();
            }

        } catch (final IllegalArgumentException x) {
            Bukkit.getLogger().info(Utils.tacc("&cParsing of the UUID has thrown an error."));
            return false;
        }
        if (player == null) return false;
        if (player.isOnline()) { //if player is online then they get their item right away

            //Call the method that gets the package and calls the complete purchase method
            WebstoreUtils.packageDelivery(args, uuid);

        } else { //if player is not online then their information is stored in a database

        }


        return true;
    }
}