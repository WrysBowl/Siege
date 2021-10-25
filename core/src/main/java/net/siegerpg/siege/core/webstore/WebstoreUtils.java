package net.siegerpg.siege.core.webstore;

import net.siegerpg.siege.core.webstore.categories.WebstorePackage;
import net.siegerpg.siege.core.webstore.categories.boosters.*;
import net.siegerpg.siege.core.webstore.categories.cosmetics.*;
import net.siegerpg.siege.core.webstore.categories.ranks.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

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

    public static void packageDelivery(String[] args, UUID uuid) {
        String[] info;
        WebstorePackage webPackage;

        try {
            //Create new String[] of arg 1 and up
            info = Arrays.copyOfRange(args, 1, args.length);

            //Gets the package using the hashmap from WebstoreUtils using the new String[]
            webPackage = packages.get(info);
        } catch (Exception x) {
            return;
        }

        //Call the complete purchase method
        webPackage.completePurchase(uuid);
    }

    public static String[] fetchPackageArguments(UUID uuid) { //called to fetch command arguments from database
        //command arguments are stored in database when player is not online
        //at the time of their purchase

        //Return arguments from the webstore database based on the UUID
        return null;
    }
}
