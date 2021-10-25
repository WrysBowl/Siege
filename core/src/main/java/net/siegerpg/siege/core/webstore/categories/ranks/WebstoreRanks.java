package net.siegerpg.siege.core.webstore.categories.ranks;

import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import net.siegerpg.siege.core.webstore.categories.WebstorePackage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class WebstoreRanks extends WebstorePackage {

    String arg2 = "rank"; //rank
    String arg3 = "warrior"; //rank type

    public WebstoreRanks(final String arg2, final String arg3){
        this.arg2=arg2;
        this.arg3=arg3;
    }
    public WebstoreRanks(final String[] args) {
        super(args);
        try {
            arg2 = this.getArgs()[1];
            arg3 = this.getArgs()[2];
        } catch (final Exception ignored) {}
    }

    @Override
    public void completePurchase(final UUID uuid) { //called when a player joins the server and their name is found in the yml webstore file
        final Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        VaultHook.perms.playerAddGroup(player, this.arg3);

        //send a message that they purchased a rank
        Bukkit.broadcast(Utils.lore(""));
        Bukkit.broadcast(Utils.lore("  <aqua>" + player.getName() + " has bought <yellow>"+ this.arg3 +" rank!"));
        Bukkit.broadcast(Utils.lore("  <aqua>https://store.siegerpg.net/"));
        Bukkit.broadcast(Utils.lore(""));
    }
}
