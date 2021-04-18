package net.siegerpg.siege.core.informants;

import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.*;
import net.siegemc.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

public class Scoreboard {
    public void updateScoreboard(Player p) {
        org.bukkit.scoreboard.Scoreboard b = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = b.registerNewObjective("Title", "", Utils.tacc("&6SiegeRPG &7(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")"));
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        double levelPercent = (Levels.getExp(p)/ Levels.getExpCeiling(p)); //for score #13
        o.getScore(" ").setScore(15);
        o.getScore(Utils.tacc("&6Profile &7" + p.getName())).setScore(14);
        o.getScore(Utils.tacc("&7╠ Level &5" + Levels.getLevel(p) + "&7(&d" + levelPercent + "%" + "&7)")).setScore(13);
        o.getScore(Utils.tacc("&7╠ &7Gold &e" + (int) VaultHook.econ.getBalance(p))).setScore(12);
        o.getScore("  ").setScore(11);
        CustomItemUtils r = CustomItemUtils.INSTANCE;
        o.getScore(Utils.tacc("&7╠ &7Stats &e"
                + r.getPlayerStat(p, StatTypes.STRENGTH)
                + r.getPlayerStat(p, StatTypes.REGENERATION)
                + r.getPlayerStat(p, StatTypes.LUCK)
                + r.getPlayerStat(p, StatTypes.TOUGHNESS)
                + r.getPlayerStat(p, StatTypes.HEALTH)
        )).setScore(10);
        p.setScoreboard(b);

        /*if (Core.getParty(p.getUniqueId()) == null) { // if player is not in dungeon or party
            o.getScore(Utils.tacc("&7╠ &4Strength " + Stats.getStrength(p))).setScore(10);
            o.getScore(Utils.tacc("&7╠ &cHealth " + Stats.getHealth(p))).setScore(9);
            o.getScore(Utils.tacc("&7╠ &6Regen " + Stats.getRegeneration(p))).setScore(8);
            o.getScore(Utils.tacc("&7╠ &aLuck " + Stats.getLuck(p))).setScore(7);
            o.getScore(Utils.tacc("&7╠ &dWisdom " + Stats.getWisdom(p))).setScore(6);
            o.getScore(Utils.tacc("&7╠ &9Tough " + Stats.getToughness(p))).setScore(5);
            p.setScoreboard(b);
        } else if (Core.getParty(p.getUniqueId()) != null) {
            Party party = Core.getParty(p.getUniqueId());
            List<UUID> UUIDMembers = party.getMembersRaw();

            for (UUID uuid : UUIDMembers) {
                Bukkit.getPlayer(UUID.fromString(String.valueOf(uuid))).getDisplayName();
                o.getScore(Utils.tacc("&7╠ &6" + +Stats.getStrength(p))).setScore(10);
            }
        }*/

    }
}
