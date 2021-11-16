package net.siegerpg.siege.core.webstore;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.miscellaneous.WebstoreDB;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WebstoreCommand extends WebstoreUtils implements CommandExecutor {

    //Make sure to allow arg-1 to also be a player

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            ((Player) sender).performCommand("craftingstore:buy");
            return false;
        }
        if (2 > args.length) return false; //check if command was used properly

        UUID uuid;
        OfflinePlayer player;

        try {
            uuid = UUID.fromString(args[0]);
            player = Bukkit.getOfflinePlayer(uuid);
        } catch (IllegalArgumentException x) {
            String msg = Utils.tacc("&cParsing of the UUID has thrown an error.");
            Bukkit.getLogger().info(msg);
            return false;
        }
        if (player.isOnline()) { //if player is online then they get their item right away
            //Call the method that gets the package and calls the complete purchase method
            WebstoreUtils.packageDelivery(Arrays.copyOfRange(args, 1, args.length), uuid);

        } else { //if player is not online then their information is stored in a database

            //converts the list into a string separated by a space
            String stringArgs = WebstoreUtils.stringify(
                    Arrays.copyOfRange(args, 1, args.length) //remove uuid from args
            );

            //stores the arguments under the player's UUID in a database
            WebstoreDB.INSTANCE.setStoreCommand(player, stringArgs);

            String msg = Utils.tacc("&ePlayer is not online. Webstore purchase stored in database.");
            Bukkit.getLogger().info(msg);
        }


        return true;
    }
}