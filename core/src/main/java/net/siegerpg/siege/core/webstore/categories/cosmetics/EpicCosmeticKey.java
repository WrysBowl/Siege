package net.siegerpg.siege.core.webstore.categories.cosmetics;

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.EpicKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey;

public class EpicCosmeticKey extends WebstoreKeys{
    public EpicCosmeticKey() {
        super("cosmetic", "epic", 1, new EpicKey(0));
    }
}
