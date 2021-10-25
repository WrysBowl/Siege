package net.siegerpg.siege.core.utils;

import kotlin.Pair;
import net.siegerpg.siege.core.utils.cache.GlobalMultipliers;
import net.siegerpg.siege.core.webstore.categories.boosters.WebstoreBoosters;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {
    public static void updateScoreboard(final Player p) {
        if(p.getScoreboard().equals(Bukkit.getServer().getScoreboardManager().getMainScoreboard())) p.setScoreboard(Bukkit.getServer().getScoreboardManager().getNewScoreboard()); //Per-player scoreboard, not necessary if all the same data, but we're personalizing the displayname and all
        final org.bukkit.scoreboard.Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective o = b.getObjective(p.getName()) == null
                ? b.registerNewObjective(p.getName(), "Title",
                Utils.lore("<gold>SiegeRPG <gray>(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")")
        ) : b.getObjective(p.getName()); //Per-player objectives, even though it doesn't matter what it's called since we're using per-player scoreboards.
        assert o != null;
        
        Pair<Short, Integer> expLevel = Levels.INSTANCE.blockingGetExpLevel(p);
        if (expLevel == null) expLevel = new Pair<>((short) 1, 0);

        final float reqExp = Levels.INSTANCE.calculateRequiredExperience(expLevel.getFirst());
        final double division = expLevel.getSecond() / reqExp;
        final double levelPercent = Utils.round(division, 3);
        final String gold = String.format("%,d", (int) VaultHook.econ.getBalance(p));

        Scoreboard.replaceScore(o, 15, " ");
        Scoreboard.replaceScore(o, 14, Utils.tacc("&6&lWorld &r&7") + p.getWorld().getName());
        Scoreboard.replaceScore(o, 13, Utils.tacc("&6Profile " + VaultHook.perms.getPrimaryGroup(p) + " &7" + p.getName()));
        Scoreboard.replaceScore(o, 12, Utils.tacc("&7\u2560 Level &5" + expLevel.getFirst() + " &d(" + Utils.round(levelPercent * 100, 2) + "%)"));
        Scoreboard.replaceScore(o, 11, Utils.tacc("&7\u2560 Gold &e" + gold));
        if (GlobalMultipliers.expMultiplier > 1.0 || GlobalMultipliers.goldMultiplier > 1.0) {
            Scoreboard.replaceScore(o, 10, "  ");
            Scoreboard.replaceScore(o, 9, Utils.tacc("&6Global"));
            if (GlobalMultipliers.expMultiplier > 1.0) {
                Scoreboard.replaceScore(o, 8, Utils.tacc("&7\u2560 &7EXP &d" + GlobalMultipliers.expMultiplier) + "x");
            }
            if (GlobalMultipliers.goldMultiplier > 1.0) {
                Scoreboard.replaceScore(o, 7, Utils.tacc("&7\u2560 &7Gold &e" + GlobalMultipliers.goldMultiplier) + "x");
            }
        }
        Scoreboard.replaceScore(o, 6, "   ");
        Scoreboard.replaceScore(o, 5, Utils.tacc("&7play.SiegeRPG.net"));
        if(o.getDisplaySlot() != DisplaySlot.SIDEBAR) o.setDisplaySlot(DisplaySlot.SIDEBAR); //Vital functionality
        p.setScoreboard(b); //Vital functionality
    }

    public static String getEntryFromScore(final Objective o, final int score) {
        if(o == null) return null;
        if(!Scoreboard.hasScoreTaken(o, score)) return null;
        for (final String s : o.getScoreboard().getEntries()) {
            if(o.getScore(s).getScore() == score) return o.getScore(s).getEntry();
        }
        return null;
    }

    public static boolean hasScoreTaken(final Objective o, final int score) {
        for (final String s : o.getScoreboard().getEntries()) {
            if(o.getScore(s).getScore() == score) return true;
        }
        return false;
    }

    public static void replaceScore(final Objective o, final int score, final String name) {
        if(Scoreboard.hasScoreTaken(o, score)) {
            if(Scoreboard.getEntryFromScore(o, score).equalsIgnoreCase(name)) return;
            if(!(Scoreboard.getEntryFromScore(o, score).equalsIgnoreCase(name))) o.getScoreboard().resetScores(Scoreboard.getEntryFromScore(o, score));
        }
        o.getScore(name).setScore(score);
    }
}
