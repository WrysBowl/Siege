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
	        this.put(new String[]{"rank", "warrior"}, new WarriorRank());
	        this.put(new String[]{"rank", "gladiator"}, new GladiatorRank());
	        this.put(new String[]{"rank", "hero"}, new HeroRank());
	        this.put(new String[]{"cosmetic", "normal"}, new NormalCosmeticKey());
	        this.put(new String[]{"cosmetic", "superior"}, new SuperiorCosmeticKey());
	        this.put(new String[]{"cosmetic", "spirit"}, new SpiritCosmeticKey());
	        this.put(new String[]{"cosmetic", "common"}, new CommonCosmeticKey());
	        this.put(new String[]{"cosmetic", "uncommon"}, new UncommonCosmeticKey());
	        this.put(new String[]{"cosmetic", "rare"}, new RareCosmeticKey());
	        this.put(new String[]{"cosmetic", "epic"}, new EpicCosmeticKey());
	        this.put(new String[]{"cosmetic", "legendary"}, new LegendaryCosmeticKey());
	        this.put(new String[]{"booster", "GOLD", "1.2"}, new GOLDBooster_20());
	        this.put(new String[]{"booster", "GOLD", "1.5"}, new GOLDBooster_50());
	        this.put(new String[]{"booster", "GOLD", "2.0"}, new GOLDBooster_100());
	        this.put(new String[]{"booster", "EXP", "1.2"}, new EXPBooster_20());
	        this.put(new String[]{"booster", "EXP", "1.5"}, new EXPBooster_50());
	        this.put(new String[]{"booster", "EXP", "2.0"}, new EXPBooster_100());

        }
    };

    public static void packageDelivery(final String[] args, final UUID uuid) {
        final String[] info;
        final WebstorePackage webPackage;

        try {
            //Create new String[] of arg 1 and up
            info = Arrays.copyOfRange(args, 1, args.length);

            //Gets the package using the hashmap from WebstoreUtils using the new String[]
            webPackage = WebstoreUtils.packages.get(info);
        } catch (final Exception x) {
            return;
        }

        //Call the complete purchase method
        webPackage.completePurchase(uuid);
    }

    public static String[] fetchPackageArguments(final UUID uuid) { //called to fetch command arguments from database
        //command arguments are stored in database when player is not online
        //at the time of their purchase

        //Return arguments from the webstore database based on the UUID
        return null;
    }
}
