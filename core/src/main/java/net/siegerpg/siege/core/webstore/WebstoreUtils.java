package net.siegerpg.siege.core.webstore;

import net.siegerpg.siege.core.miscellaneous.Utils;
import net.siegerpg.siege.core.webstore.categories.WebstorePackage;
import net.siegerpg.siege.core.webstore.categories.boosters.*;
import net.siegerpg.siege.core.webstore.categories.cosmetics.*;
import net.siegerpg.siege.core.webstore.categories.ranks.*;
import org.bukkit.Bukkit;

import java.util.*;

public class WebstoreUtils {
    public static HashMap<String[], WebstorePackage> packages = new HashMap<>(){
        {
            //includes arg1+
            put(new String[]{"rank", "warrior"}, new WarriorRank());
            put(new String[]{"rank", "gladiator"}, new GladiatorRank());
            put(new String[]{"rank", "hero"}, new HeroRank());
            put(new String[]{"cosmetic", "normal"}, new NormalCosmeticKey());
            put(new String[]{"cosmetic", "superior"}, new SuperiorCosmeticKey());
            put(new String[]{"cosmetic", "spirit"}, new SpiritCosmeticKey());
            put(new String[]{"cosmetic", "common"}, new CommonCosmeticKey());
            put(new String[]{"cosmetic", "uncommon"}, new UncommonCosmeticKey());
            put(new String[]{"cosmetic", "rare"}, new RareCosmeticKey());
            put(new String[]{"cosmetic", "epic"}, new EpicCosmeticKey());
            put(new String[]{"cosmetic", "legendary"}, new LegendaryCosmeticKey());
            put(new String[]{"booster", "GOLD", "1.2"}, new GOLDBooster_20());
            put(new String[]{"booster", "GOLD", "1.5"}, new GOLDBooster_50());
            put(new String[]{"booster", "GOLD", "2.0"}, new GOLDBooster_100());
            put(new String[]{"booster", "EXP", "1.2"}, new EXPBooster_20());
            put(new String[]{"booster", "EXP", "1.5"}, new EXPBooster_50());
            put(new String[]{"booster", "EXP", "2.0"}, new EXPBooster_100());

        }
    };

    public static void packageDelivery(String[] info, UUID uuid) {
        WebstorePackage webPackage;
        Bukkit.getLogger().info("Purchase is being delivered");

        try {
            //Iterate through each pair in the hashmap
            outerLoop: for (Map.Entry<String[], WebstorePackage> entry : packages.entrySet()) {
                String[] packageArgs = entry.getKey();

                //Compare the first index of the hashmap string[] to the args parameter
                for (int index = 0; index < packageArgs.length; index++) {

                    //Check if the index from hashmap is equal to the index of the arguments from command
                    if (!packageArgs[index].equals(info[index])) {
                        //If the index does not match the index of the args
                        //Then we go to the next set in the hashmap
                        continue outerLoop;
                    }
                }
                //gets the current iteration of the loop
                //because it is the one that matches our arguments
                webPackage = entry.getValue();
                webPackage.setArgs(info);
                webPackage.completePurchase(uuid);
                Bukkit.getLogger().info("Purchase Completed");
                break;
            }
            //Gets the package using the hashmap from WebstoreUtils using the new String[]
        } catch (Exception x) {
            x.printStackTrace();
            Bukkit.getLogger().info(Utils.tacc("&cError processing purchase"));
        }
    }
    public static String stringify(String[] list) {
        return String.join(" ", list);
    }
}
