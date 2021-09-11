package net.siegerpg.siege.core.Webstore;

import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WebstoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) return false;

        OfflinePlayer argPlayer = Bukkit.getOfflinePlayer(args[0]);
        if (args[1].equals("booster")) {
            //arg 2 = EXP or GOLD
            //arg 3 = multiplier
            //args 4 = duration in seconds
            //arg 5 = amount
            String type = args[2];
            float multi = 1;
            int duration = 3600;
            int amount = 1;
            try { multi = Float.parseFloat(args[3]); }
            catch (NumberFormatException e) {
                Bukkit.getLogger().info(Utils.tacc("&cCould not correctly parse multiplier to a float."));
            }
            try { duration = Integer.parseInt(args[4]); }
            catch (NumberFormatException e) {
                Bukkit.getLogger().info(Utils.tacc("&cCould not correctly parse duration to an integer."));
            }
            try { amount = Integer.parseInt(args[5]); }
            catch (NumberFormatException e) {
                Bukkit.getLogger().info(Utils.tacc("&cCould not correctly parse amount to an integer."));
            }

            ItemStack item = WebstoreUtils.getBooster(amount, multi, duration, type);
            WebstoreUtils.giveItemToPlayer((Player)argPlayer, item);
            Bukkit.broadcastMessage(Utils.tacc(""));
            Bukkit.broadcastMessage(Utils.tacc("  &b" + argPlayer.getName() + " has bought &e"+amount+" &a"+((multi*100)-100.0)+"% "+type+" boosters!"));
            Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
            Bukkit.broadcastMessage(Utils.tacc(""));

        }
        if (args[1].equals("WarriorRank")) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String cmd = "lp user " + argPlayer.getName() + " parent add Warrior";
            Bukkit.dispatchCommand(console, cmd);

            int highestPV = Utils.getHighestPV((Player)argPlayer);
            int diff = 54 - highestPV;
            int addPV = highestPV+2;
            if (diff < 2) addPV = diff;

            ConsoleCommandSender console2 = Bukkit.getServer().getConsoleSender();
            String cmd2 = "lp user " + argPlayer.getName() + " permission set cosmicvaults.amount."+addPV+" true global";
            Bukkit.dispatchCommand(console2, cmd2);

            Bukkit.broadcastMessage(Utils.tacc(""));
            Bukkit.broadcastMessage(Utils.tacc("  &b" + argPlayer.getName() + " has bought &2Warrior &erank!"));
            Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
            Bukkit.broadcastMessage(Utils.tacc(""));
            return true;
        }
        if (args[1].equals("GladiatorRank")) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String cmd = "lp user " + argPlayer.getName() + " parent add Gladiator";
            Bukkit.dispatchCommand(console, cmd);

            int highestPV = Utils.getHighestPV((Player)argPlayer);
            int diff = 54 - highestPV;
            int addPV = highestPV+3;

            if (VaultHook.perms.playerInGroup((Player) argPlayer, "warrior")) {
                addPV = highestPV+1;
                if (diff < 1) addPV = diff;
                ConsoleCommandSender console4 = Bukkit.getServer().getConsoleSender();
                String cmd3 = "lp user " + argPlayer.getName() + " parent remove warrior";
                Bukkit.dispatchCommand(console4, cmd3);
            } else {
                if (diff < 3) addPV = diff;
            }

            ConsoleCommandSender console2 = Bukkit.getServer().getConsoleSender();
            String cmd2 = "lp user " + argPlayer.getName() + " permission set cosmicvaults.amount."+addPV+" true global";
            Bukkit.dispatchCommand(console2, cmd2);

            Bukkit.broadcastMessage(Utils.tacc(""));
            Bukkit.broadcastMessage(Utils.tacc("  &b" + argPlayer.getName() + " has bought &2Gladiator &erank!"));
            Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
            Bukkit.broadcastMessage(Utils.tacc(""));
            return true;
        }
        if (args[1].equals("HeroRank")) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            String cmd = "lp user " + argPlayer.getName() + " parent add Hero";
            Bukkit.dispatchCommand(console, cmd);

            int highestPV = Utils.getHighestPV((Player)argPlayer);
            int diff = 54 - highestPV;
            int addPV = highestPV+5;

            if (VaultHook.perms.playerInGroup((Player) argPlayer, "gladiator")) {
                addPV = highestPV+2;
                if (diff < 2) addPV = diff;
                ConsoleCommandSender console4 = Bukkit.getServer().getConsoleSender();
                String cmd3 = "lp user " + argPlayer.getName() + " parent remove gladiator";
                Bukkit.dispatchCommand(console4, cmd3);
            } else {
                if (diff < 5) addPV = diff;
            }

            ConsoleCommandSender console2 = Bukkit.getServer().getConsoleSender();
            String cmd2 = "lp user " + argPlayer.getName() + " permission set cosmicvaults.amount."+addPV+" true global";
            Bukkit.dispatchCommand(console2, cmd2);

            Bukkit.broadcastMessage(Utils.tacc(""));
            Bukkit.broadcastMessage(Utils.tacc("  &b" + argPlayer.getName() + " has bought &bHero &erank!"));
            Bukkit.broadcastMessage(Utils.tacc("  &bhttps://store.siegerpg.net/"));
            Bukkit.broadcastMessage(Utils.tacc(""));
            return true;
        }


        return false;
    }
}