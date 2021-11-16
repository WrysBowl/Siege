package net.siegerpg.siege.core.fishing.catches.loot.webstore;

import net.siegerpg.siege.core.fishing.catches.Fish;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class UncommonKey extends Fish {

	public UncommonKey() {

		super(50, 1, 12, 20,
		      new net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.UncommonKey(
				      0).getUpdatedItem(false)
		     );
	}

	@Override
	public void accomplishment(Player player) {

		Bukkit
				.getServer()
				.sendMessage(Utils.lore(
						"<green>" + player.getName() + " has found an uncommon key from fishing!"));
	}

}
