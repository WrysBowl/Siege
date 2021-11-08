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
            //Food
            add(Utils.tacc("&eFood can be farmed from all kinds of mobs!"));
            add(Utils.tacc("&eFood can be collected from farming carrots, pumpkins, and melons."));
            add(Utils.tacc("&eSome foods give special effects which you can use situationally."));

            //Stats
            add(Utils.tacc("&eArmor stats do not apply if you are not the appropriate level."));
            add(Utils.tacc("&eYou can still wear armor if you are not the appropriate level."));
            add(Utils.tacc("&eWeapon stats will not apply if you are not the appropriate level."));
            add(Utils.tacc("&eWeapons will only deal 1 damage if you are not the appropriate level."));

            //Leveling
            add(Utils.tacc("&eYou can gain EXP from crates that fall from the sky."));
            add(Utils.tacc("&eKill mobs and break blocks to gain experience!"));

            //Gear Collecting
            add(Utils.tacc("&eClick on weapon/armor vendors to craft stronger weapons and armor pieces."));
            add(Utils.tacc("&eClick on material vendors to upgrade your materials."));
            add(Utils.tacc("&eMobs can sometimes drop gear."));

            //Material Collecting
            add(Utils.tacc("&eMaterials can be collected from killing mobs or breaking blocks."));

            //Dungeons
            add(Utils.tacc("&eDungeons are hidden around the map. Find them all!"));
            add(Utils.tacc("&eYour speed run time is tracked after killing a dungeon boss."));
            add(Utils.tacc("&eTo spawn a dungeon boss, you need to farm for it's key."));

            //Cosmetic Keys
            add(Utils.tacc("&eCosmetic keys are sold in the webstore."));
            add(Utils.tacc("&eCosmetic keys can be used in /hub to get a random cosmetic."));

            //Boosters
            add(Utils.tacc("&eBoosters are sold in the webstore."));
            add(Utils.tacc("&eBoosters give everyone a percent increase in gold or experience."));

            //Ranks
            add(Utils.tacc("&eWarrior rank gives you 9 more slots per player vault."));
            add(Utils.tacc("&eGladiator rank gives you 18 more slots per player vault."));
            add(Utils.tacc("&eHero rank gives you 27 more slots per player vault."));

            //Inventory Storage
            add(Utils.tacc("&eYou will gain a player vault for every 10 levels you rank up."));
            add(Utils.tacc("&eUse your ender chest for storage."));
            add(Utils.tacc("&ePurchase vault space from the Perks slime in /hub."));

            //Different types of NPCs
            add(Utils.tacc("&eYou can put your money in the bank at the village on the opposite corner of the map."));
            add(Utils.tacc("&eYou can buy food from the butcher at the village on the opposite corner of the map."));
            add(Utils.tacc("&eYou can gamble for money with Bart at the village on the opposite corner of the map."));
            add(Utils.tacc("&eHerbert the Scrapper will buy your items (but he's cheap about it)."));

            //Different types of Mobs
            add(Utils.tacc("&eGoblins and Wild Foxes can steal your money and run away with it."));
            add(Utils.tacc("&eZombified Diggers can duplicate when they hit you."));

            //Special Items (ex. stat gems)
            add(Utils.tacc("&eClick and drag stat gems onto a weapon or armor piece to apply it."));

            //Commands
            add(Utils.tacc("&eVisit our webstore using the /webstore command!"));
            add(Utils.tacc("&eJoin our discord using the /discord command!"));
            add(Utils.tacc("&eUse the /hub command to teleport to the hub."));
            add(Utils.tacc("&eUse the /spawn command to teleport to spawn."));

            //MISC Interactions
            add(Utils.tacc("&eMost plants can be broken for a chance to get gold and experience."));
            add(Utils.tacc("&eLooking to partner with us? DM Wrys#8935."));
            add(Utils.tacc("&eA sweeping effect is played every time a player damages a mob."));

        }
    };

    public void broadcastTasks() {
        tipsTask();
    }

    public void tipsTask() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Core.plugin(), () -> {
            int randNum = (int) (Math.random() * tips.size());
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (!PlayerData.broadcastTips.get(p)) continue;
                p.sendMessage(Utils.tacc("\n&6&lTIP &r" + tips.get(randNum) + "&r\n&7To disable tips type /tips disable.\n\n "));
            }
        }, 6000, 6000);
    }
}
