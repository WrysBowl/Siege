package net.siegerpg.siege.core.fishing.catches.loot.webstore;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.webstore.categories.boosters.GOLDBooster_20;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GOLD20 extends Fish {

    public GOLD20(){
        super(40, 0.8, 15, 15,
                new GOLDBooster_20().getBoosterItem());
    }

    @Override
    public void accomplishment(Player player) {
        Bukkit.getServer().sendMessage(Utils.lore("<green>"+player.getName()+" has found a <yellow>20% GOLD Booster<green> from fishing!"));
    }
}
