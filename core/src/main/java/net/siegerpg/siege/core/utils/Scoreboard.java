package net.siegerpg.siege.core.utils;

import net.siegerpg.siege.core.Webstore.WebstoreUtils;
import net.siegerpg.siege.core.utils.cache.LevelEXPStorage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {
    public static void updateScoreboard(Player p) {
        org.bukkit.scoreboard.Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = b.registerNewObjective("Title", "", Utils.tacc("&6SiegeRPG &7(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")"));
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        int level;
        if (LevelEXPStorage.playerLevel.get(p) != null) { level = LevelEXPStorage.playerLevel.get(p); }
        else { level = Levels.INSTANCE.getExpLevel(p).getFirst(); }

        if (level < 1) { level = 1; }
        float exp;
        if (LevelEXPStorage.playerExperience.get(p) != null) { exp = LevelEXPStorage.playerExperience.get(p); }
        else { exp = Levels.INSTANCE.getExpLevel(p).getSecond(); }

        float reqExp = Levels.INSTANCE.calculateRequiredExperience((short) level);
        double division = exp/reqExp;
        double levelPercent = Utils.round(division, 3);
        String gold = String.format("%,d", (int) VaultHook.econ.getBalance(p));
        o.getScore(" ").setScore(15);

        o.getScore(Utils.tacc("&6&lWorld &r&7") + p.getWorld().getName()).setScore(14);

        o.getScore(Utils.tacc("&6Profile " + VaultHook.perms.getPrimaryGroup(p) + " &7" + p.getName())).setScore(13);
        o.getScore(Utils.tacc("&7\u2560 Level &5" + level + " &d(" + Utils.round(levelPercent*100,2) + "%)")).setScore(12);
        o.getScore(Utils.tacc("&7\u2560 Gold &e" + gold)).setScore(11);
        if (WebstoreUtils.expMultiplier > 1.0 || WebstoreUtils.goldMultiplier > 1.0) {
            o.getScore("  ").setScore(10);
            o.getScore(Utils.tacc("&6Global")).setScore(9);
            if (WebstoreUtils.expMultiplier > 1.0) {
                o.getScore(Utils.tacc("&7\u2560 &7EXP &d" + WebstoreUtils.expMultiplier) + "x").setScore(8);
            }
            if (WebstoreUtils.goldMultiplier > 1.0) {
                o.getScore(Utils.tacc("&7\u2560 &7Gold &e" + WebstoreUtils.goldMultiplier) + "x").setScore(7);
            }
        }
        o.getScore("   ").setScore(6);
        o.getScore(Utils.tacc("&7play.SiegeRPG.net")).setScore(5);
        p.setScoreboard(b);

    }
}
