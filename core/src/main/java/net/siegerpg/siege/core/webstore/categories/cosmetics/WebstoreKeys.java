package net.siegerpg.siege.core.webstore.categories.cosmetics;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.webstore.categories.WebstorePackage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WebstoreKeys extends WebstorePackage {

    String arg2 = "cosmetic";
    String arg3 = "normal"; //key type
    Integer arg4 = 1; //amount
    CustomKey key = new NormalKey(0);

    public WebstoreKeys(String arg2, String arg3, Integer arg4, CustomKey key){
        this.arg2=arg2;
        this.arg3=arg3;
        this.arg4=arg4;
        this.key=key;
    }

    @Override
    public void completePurchase(UUID uuid) { //called when a player joins the server and their name is found in the yml webstore file
        Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        if (!Utils.giveItem(player, key.getItem().asQuantity(arg4))) {
            //when giveItem is run it will give the player the booster if the condition is not met
            player.sendMessage(Utils.lore(
                    "<red>An item has been purchased for this account, but your inventory and ender chest was too full. Please rejoin the server with space for the item(s) in your inventory."));

        }

        //send a message that they purchased a booster
        Bukkit.broadcast(Utils.lore(""));
        Bukkit.broadcast(Utils.lore("  <aqua>" + player.getName() + " has bought <yellow>cosmetic keys!"));
        Bukkit.broadcast(Utils.lore("  <aqua>https://store.siegerpg.net/"));
        Bukkit.broadcast(Utils.lore(""));
    }
    public void setAmount(int amount) {
        this.arg4 = amount;
    }
}
