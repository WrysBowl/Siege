package net.siegerpg.siege.core.informants;

import kotlin.Pair;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {
    public static void updateScoreboard(Player p) {
        org.bukkit.scoreboard.Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = b.registerNewObjective("Title", "", Utils.tacc("&6SiegeRPG &7(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")"));
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        Pair<Short, Integer> levelExp = Levels.INSTANCE.getExpLevel(p);
        float exp = levelExp.getSecond().floatValue();
        int reqExp = Levels.INSTANCE.calculateRequiredExperience(levelExp.getFirst());
        double levelPercent = Utils.round((double) (exp / reqExp), 3);
        o.getScore(" ").setScore(15);

        o.getScore(Utils.tacc("&6&lWorld &r&7") + p.getWorld().getName()).setScore(14);

        o.getScore(Utils.tacc("&6Profile " + VaultHook.perms.getPrimaryGroup(p) + " &7" + p.getName())).setScore(13);
        o.getScore(Utils.tacc("&7\u2560 Level &5" + levelExp.getFirst() + "&d(" + levelPercent * 100 + "%)")).setScore(12);
        o.getScore(Utils.tacc("&7\u2560 Gold &e" + (int) VaultHook.econ.getBalance(p))).setScore(11);
        o.getScore("  ").setScore(10);
        o.getScore(Utils.tacc("&7play.SiegeRPG.net")).setScore(4);
        p.setScoreboard(b);

    }
}
