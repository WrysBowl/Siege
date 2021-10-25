package net.siegerpg.siege.core.commands;

import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Level implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        if (args.length > 0) {
            final OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);
            this.doTheThing(sender, argPlayer);
            return true;
        }
        final Player player = (Player) sender;
        this.doTheThing(sender, player);

        return true;

    }

    public void doTheThing(final CommandSender executor, final OfflinePlayer player) {
        Levels.INSTANCE.getExpLevel(player, pair -> {
            if (pair == null) {
                executor.sendMessage(Utils.lore("<red>That player can not be found."));
            }
            final float reqExp = Levels.INSTANCE.calculateRequiredExperience(pair.getFirst());
            final double division = pair.getSecond() / reqExp;
            final String name = player.getName();
            final String levelPercent = String.valueOf(Utils.round(Utils.round(division, 3) * 100, 2));

            int total = 0;
            for (int i = 2; i < pair.getFirst(); i++) {

                total = total + Levels.INSTANCE.calculateRequiredExperience((short) i);

            }
            total = total + pair.getSecond();
            final String totalFormat = String.format("%,d", total);
            final String expLeft = String.format("%,d", (int) (reqExp - pair.getSecond()));

            executor.sendMessage(Utils.lore("<dark_purple><bold>Level Statistics"));
            executor.sendMessage(Utils.lore(" "));
            executor.sendMessage(Utils.lore(" "));
            executor.sendMessage(Utils.lore("<gold>" + name));
            executor.sendMessage(Utils.lore("<gray>Level         <reset><dark_purple>" + pair.getFirst()));
            executor.sendMessage(Utils.lore("<gray>Exp %         <reset><light_purple>" + levelPercent + "%"));
            executor.sendMessage(Utils.lore("<gray>Exp            <reset><light_purple>" + pair.getSecond()));
            executor.sendMessage(Utils.lore("<gray>Exp to Next  <reset><light_purple>" + expLeft));
            executor.sendMessage(Utils.lore("<gray>Total Exp     <reset><light_purple>" + totalFormat));
            executor.sendMessage(Utils.lore(" "));
            return null;
        });
    }

}

