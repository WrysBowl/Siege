package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Stats implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        OfflinePlayer player = (Player) sender;
        if (args.length > 0) {
            OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);
            if (!argPlayer.isOnline()) {
                ((Player) player).sendMessage(Utils.lore("<red>That player can not be found."));
                return false;
            }
            player = argPlayer;
        }

        double health = CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.HEALTH);
        double strength = CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.STRENGTH);
        double toughness = CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.TOUGHNESS);
        double luck = CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.LUCK);
        double regeneration = CustomItemUtils.INSTANCE.getPlayerStat((Player) player, StatTypes.REGENERATION);

        sender.sendMessage(Utils.lore(" "));
        sender.sendMessage(Utils.lore("<yellow><bold>Player Statistics"));
        sender.sendMessage(Utils.lore(" "));
        sender.sendMessage(Utils.lore("<gold>" + player.getName()));
        sender.sendMessage(Utils.lore("  <gray>Strength        <reset><dark_red>" + strength));
        sender.sendMessage(Utils.lore("  <gray>Toughness     <reset><blue>" + toughness));
        sender.sendMessage(Utils.lore("  <gray>Health           <reset><red>" + health));
        sender.sendMessage(Utils.lore("  <gray>Regeneration  <reset><gold>" + regeneration));
        sender.sendMessage(Utils.lore("  <gray>Luck             <reset><green>" + luck));
        sender.sendMessage(Utils.lore(" "));

        return true;
    }

}

