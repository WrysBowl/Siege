package net.siegerpg.siege.core.commands;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetItem implements CommandExecutor {

    @SneakyThrows
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (VaultHook.perms.getPrimaryGroup(player).contains("developer")) {
                if (args.length == 2) {
                    CustomItem item = CustomItem.class.newInstance();
                    if (Class.forName(args[0]).isInstance(item)) {
                        Gson gson = new Gson();
                        CustomItem obj = gson.fromJson(args[0], CustomItem.class);
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