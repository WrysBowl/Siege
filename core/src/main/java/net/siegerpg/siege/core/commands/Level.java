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
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        OfflinePlayer player = (Player) sender;
        if (args.length > 0) {
            ((Player)player).sendMessage(Utils.lore("<red>This feature is not available yet!."));
            return false;
            /*
            OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);
            if (Levels.INSTANCE.getExpLevel(argPlayer).getFirst() == null) {
                ((Player)player).sendMessage(Utils.lore("<red>That player can not be found."));
               return false;
            } else {
                player = argPlayer;
            }
            */
        }

        short level = Levels.INSTANCE.getExpLevel(player).getFirst();
        float reqExp = Levels.INSTANCE.calculateRequiredExperience(level);
        Integer experience = Levels.INSTANCE.getExpLevel(player).getSecond();
        double division = experience/reqExp;
        String name = player.getName();
        String levelPercent = String.valueOf(Utils.round(Utils.round(division, 3)*100,2));

        int total = 0;
        for (int i = 2; i < level; i++) {

            total = total + Levels.INSTANCE.calculateRequiredExperience((short) i);

        }
        total = total + experience;
        String totalFormat = String.format("%,d", total);
        String expLeft = String.format("%,d", (int) (reqExp-experience));


        sender.sendMessage(Utils.lore(" "));
        sender.sendMessage(Utils.lore("<dark_purple><bold>Level Statistics"));
        sender.sendMessage(Utils.lore(" "));
        sender.sendMessage(Utils.lore("<gold>" + name));
        sender.sendMessage(Utils.lore("<gray>Level         <reset><dark_purple>" + level));
        sender.sendMessage(Utils.lore("<gray>Exp %         <reset><light_purple>" + levelPercent + "%"));
        sender.sendMessage(Utils.lore("<gray>Exp            <reset><light_purple>" + experience));
        sender.sendMessage(Utils.lore("<gray>Exp to Next  <reset><light_purple>" + expLeft));
        sender.sendMessage(Utils.lore("<gray>Total Exp     <reset><light_purple>" + totalFormat));
        sender.sendMessage(Utils.lore(" "));

        return true;
    }

}

