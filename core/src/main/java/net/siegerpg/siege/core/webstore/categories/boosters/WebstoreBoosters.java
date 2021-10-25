package net.siegerpg.siege.core.webstore.categories.boosters;

import de.tr7zw.nbtapi.NBTItem;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.webstore.categories.WebstorePackage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class WebstoreBoosters extends WebstorePackage {

    String arg2 = "booster"; //booster
    String arg3 = "GOLD"; //booster type
    Double arg4 = 1.2; //multiplier
    Integer arg5 = 3600; //duration
    Integer arg6 = 1; //amount


    public WebstoreBoosters(final String arg2, final String arg3, final Double arg4, final Integer arg5, final Integer arg6){
        this.arg2=arg2;
        this.arg3=arg3;
        this.arg4=arg4;
        this.arg5=arg5;
        this.arg6=arg6;
    }
    public WebstoreBoosters(final String[] args) {
        super(args);
        try {
            arg2 = this.getArgs()[1];
            arg3 = this.getArgs()[2];
            arg4 = Double.parseDouble(this.getArgs()[3]);
            arg5 = Integer.parseInt(this.getArgs()[4]);
            arg6 = Integer.parseInt(this.getArgs()[5]);
        } catch (final Exception ignored) {}
    }

    public void setMultiplier(final double multi) {
        arg4 = multi;
    }
    public void setDuration(final int duration) {
        arg5 = duration;
    }
    public void setAmount(final int amount) {
        arg6 = amount;
    }

    @Override
    public void completePurchase(final UUID uuid) { //called when a player joins the server and their name is found in the yml webstore file
        //give player the booster item
        final Player player = Bukkit.getPlayer(uuid);
        if (player == null) return;
        if (!Utils.giveItem(player, this.getBoosterItem())) {
            //when giveItem is run it will give the player the booster if the condition is not met
            player.sendMessage(Utils.lore(
                    "<red>An item has been purchased for this account, but your inventory and ender chest was too full. Please rejoin the server with space for the item(s) in your inventory."));

        }

        //send a message that they purchased a booster
        Bukkit.broadcast(Utils.lore(""));
        Bukkit.broadcast(Utils.lore("  <aqua>" + player.getName() + " has bought <yellow>"+ this.arg6 +" "+ this.arg3 +" <green>booster(s)!"));
        Bukkit.broadcast(Utils.lore("  <aqua>https://store.siegerpg.net/"));
        Bukkit.broadcast(Utils.lore(""));
    }

    public ItemStack getBoosterItem() {
        final ItemStack item = new ItemStack(Material.PAPER, this.arg6);
        final ItemMeta itemMeta = item.getItemMeta();
        if (arg3.equals("EXP")) itemMeta.displayName(Utils.lore("<light_purple>EXP Booster"));
        else if (arg3.equals("GOLD")) itemMeta.displayName(Utils.lore("<yellow>Gold Booster"));
        else return null;
        itemMeta.lore(new ArrayList<>(){
            {
	            this.add(Utils.lore("  <gray>Duration: <white>" + Utils.convertSecondsToTime(WebstoreBoosters.this.arg5)));
	            this.add(Utils.lore("  <yellow>Multiplier: +" + ((WebstoreBoosters.this.arg4 *100)-100.0) + "% "+ WebstoreBoosters.this.arg3));
	            this.add(Utils.lore(""));
	            this.add(Utils.lore("<green><bold>CLICK TO REDEEM"));
            }
        });

        item.setItemMeta(itemMeta);
        final NBTItem nbtItem = new NBTItem(item);
        nbtItem.setInteger("seconds", this.arg5);
        nbtItem.setDouble("multiplier", this.arg4);
        return nbtItem.getItem();
    }
}
