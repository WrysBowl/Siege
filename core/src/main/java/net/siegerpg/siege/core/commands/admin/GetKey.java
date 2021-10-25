package net.siegerpg.siege.core.commands.admin;

import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GetKey implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(Utils.lore("<red>Only console can use this command."));
            return false;
        }
        if (args.length != 3) {
            sender.sendMessage(Utils.lore("<red>You did not fill in the proper arguments /getKey player HillyWoods/Twilight amount."));
            return false;
        }
        final Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage(Utils.lore("<red>This player is null."));
            return false;
        }
        final String type;
        final int amount;
        try {
            type = args[1];
            amount = Integer.parseInt(args[2]);
        } catch (final Exception e){
            sender.sendMessage(Utils.lore("<red>Exception parsing command."));
            return false;
        }
        return true;
    }
}