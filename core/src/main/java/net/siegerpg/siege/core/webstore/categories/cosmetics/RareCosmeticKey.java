package net.siegerpg.siege.core.webstore.categories.cosmetics;

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.RareKey;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.UncommonKey;

public class RareCosmeticKey extends WebstoreKeys{
    public RareCosmeticKey() {
        super("cosmetic", "rare", 1, new RareKey());
    }
}
