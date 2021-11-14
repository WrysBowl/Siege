package net.siegerpg.siege.core.fishing.catches.loot.webstore;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class NormalKey extends Fish {

    public NormalKey(){
        super(50, 0.9, 12, 17,
                new net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey(0).getUpdatedItem(false));
    }

    @Override
    public void accomplishment(Player player) {
        Bukkit.getServer().sendMessage(Utils.lore("<green>"+player.getName()+" has found a normal key from fishing!"));
    }
}
