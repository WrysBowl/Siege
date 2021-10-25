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

    public WebstoreRanks(String arg2, String arg3){
        this.arg2=arg2;
        this.arg3=arg3;
    }
    public WebstoreRanks(String[] args) {
        super(args);
        try {
            this.arg2 = getArgs()[1];
            this.arg3 = getArgs()[2];
        } catch (Exception ignored) {}
    }

    @Override
    public void completePurchase(UUID uuid) { //called when a player joins the server and their name is found in the yml webstore file
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;

        VaultHook.perms.playerAddGroup(player, arg3);

        //send a message that they purchased a rank
        Bukkit.broadcast(Utils.lore(""));
        Bukkit.broadcast(Utils.lore("  <aqua>" + player.getName() + " has bought <yellow>"+arg3+" rank!"));
        Bukkit.broadcast(Utils.lore("  <aqua>https://store.siegerpg.net/"));
        Bukkit.broadcast(Utils.lore(""));
    }
}
