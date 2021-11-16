package net.siegerpg.siege.core.fishing.catches.loot.webstore;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class CommonKey extends Fish {

    public CommonKey(){
        super(40, 0.8, 15, 15,
                new net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.CommonKey(0).getUpdatedItem(false));
    }

    @Override
    public void accomplishment(Player player) {
        Bukkit.getServer().sendMessage(Utils.lore("<green>"+player.getName()+" has found a common key from fishing!"));
    }
}
