package net.siegerpg.siege.core.commands.admin;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetItem implements CommandExecutor {

    @SneakyThrows
    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player) sender;
            if (player.hasPermission("SiegeCore.getItem")) {
                if (args.length == 2) {
                    final CustomItem item = CustomItem.class.newInstance();
                    if (Class.forName(args[0]).isInstance(item)) {
                        final Gson gson = new Gson();
                        final CustomItem obj = gson.fromJson(args[0], CustomItem.class);
                        player.getInventory().addItem(obj.getUpdatedItem(Boolean.getBoolean(args[1])));
                        return true;
                    }
                    player.sendMessage(Utils.parse("<red>This is not a valid item"));
                    return false;
                } else if (args.length == 1) {
                    player.sendMessage(Utils.parse("<red>Please add true/false for rarity display to the end of your command"));
                    return false;
                } else if (args.length == 0) {
                    player.sendMessage(Utils.parse("<red>Get what item?"));
                    return false;
                }
                player.sendMessage(Utils.parse("<red>Too many arguments!"));
                return false;
            }
            player.sendMessage(Utils.parse("<red>You're not a developer!"));
            return false;
        }
        Bukkit.getLogger().info(Utils.tacc("<red>An entity other than the player ran the /hub command"));
        return false;
    }
}