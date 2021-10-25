package net.siegerpg.siege.core.listeners.tasks;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.cache.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class HelpfulTips implements Listener {

    /**
     * TIPS ARE SUBJECT TO CHANGE WITH NEW UPDATES
     */

    public static ArrayList<String> tips = new ArrayList<>() {
        {
            this.add(Utils.tacc("&eKill chickens, pigs, birds, sheep, and cows for food."));
            this.add(Utils.tacc("&eClick on weapon/armor vendors to craft stronger weapons and armor pieces."));
            this.add(Utils.tacc("&eClick on material vendors and then either block drops or mob drops to upgrade your materials."));
            this.add(Utils.tacc("&eClick and drag stat gems onto a weapon or armor piece to apply it."));
            this.add(Utils.tacc("&eMobs are often found hiding in corners and along walls."));
            this.add(Utils.tacc("&eArmor stats do not apply if you are not the appropriate level."));
            this.add(Utils.tacc("&eYou can still wear armor if you are not the appropriate level."));
            this.add(Utils.tacc("&eWeapon stats will not apply if you are not the appropriate level."));
            this.add(Utils.tacc("&eWeapons will only deal 1 damage if you are not the appropriate level."));
            this.add(Utils.tacc("&eBuy armor/weapons from Smoky at spawn."));
            this.add(Utils.tacc("&eUse Mera to teleport to different locations around Hilly Woods."));
            this.add(Utils.tacc("&eVisit our webstore using the /webstore command!"));
            this.add(Utils.tacc("&eJoin our discord using the /discord command!"));
            this.add(Utils.tacc("&eHerbert the Scrapper will buy your items (but he's cheap about it)."));
            this.add(Utils.tacc("&eHerbert does not like tier 1 materials, so you need to convert them to at least tier 2 for him to buy them."));
            this.add(Utils.tacc("&eUse the /hub command to teleport to the hub."));
            this.add(Utils.tacc("&eUse the /spawn command to teleport to spawn 3 seconds after sending it."));
            this.add(Utils.tacc("&eLooking to partner with us? DM Wrys#8935 to speak with the owner."));
            this.add(Utils.tacc("&eMost plants can be broken for a chance to get gold or experience."));
            this.add(Utils.tacc("&eWarrior rank gives you 9 more slots per player vault."));
            this.add(Utils.tacc("&eGladiator rank gives you 18 more slots per player vault."));
            this.add(Utils.tacc("&eHero rank gives you 27 more slots per player vault."));
            this.add(Utils.tacc("&eRank gives you extra daily rewards!."));

            this.add(Utils.tacc("&eYou will gain a player vault for every 10 levels you rank up."));
            this.add(Utils.tacc("&eAn Ogre can spawn at night, he's terrifying."));
            this.add(Utils.tacc("&eGoblins and Wild Foxes can steal your money and run away with it."));
            this.add(Utils.tacc("&eZombified Diggers can duplicate when they hit you."));
            this.add(Utils.tacc("&eA sweeping effect is played every time a player damages a mob."));
            this.add(Utils.tacc("&eYou can put your money in the bank at the village on the opposite corner of the map."));
            this.add(Utils.tacc("&eYou can buy food from the butcher at the village on the opposite corner of the map."));
            this.add(Utils.tacc("&eYou can gamble for money with Bart at the village on the opposite corner of the map."));
        }
    };

    public void broadcastTasks() {
        this.tipsTask();
        this.webstoreDiscordTask();
    }

    public void tipsTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            final int randNum = (int) (Math.random() * HelpfulTips.tips.size());
            for (final Player p : Bukkit.getOnlinePlayers()) {
                if (!PlayerData.broadcastTips.get(p)) continue;
                p.sendMessage(Utils.tacc("\n&6&lTIP &r" + HelpfulTips.tips.get(randNum) + "&r\n&7To disable tips type /tips disable.\n\n "));
            }
        }, 6000, 6000);
    }

    public void webstoreDiscordTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            if (Bukkit.getOnlinePlayers().isEmpty()) return;
            Levels.INSTANCE.getExpLevel(new ArrayList<Player>(Bukkit.getOnlinePlayers()),
                    uuidPairHashMap -> {
                        uuidPairHashMap.forEach((uuid, shortIntegerPair) ->
                        {
                            if (shortIntegerPair.getFirst() > 10) return;
                            final Player p = Bukkit.getPlayer(uuid);
                            if (p == null) return;
                            p.sendMessage(Utils.parse(""));
                            p.sendMessage(Utils.parse("  <aqua><bold>Join our <light_purple>discord<aqua> here!<reset>"));
                            p.sendMessage(Utils.tacc("  https://discord.siegerpg.net"));
                            p.sendMessage(Utils.parse(""));
                            p.sendMessage(Utils.parse("  <aqua><bold>Visit our <green>webstore<aqua> here!<reset>"));
                            p.sendMessage(Utils.tacc("  https://store.siegerpg.net/"));
                            p.sendMessage(Utils.parse(""));
                        });
                        return null;
                    });

        }, 12000, 6000);
    }
}
