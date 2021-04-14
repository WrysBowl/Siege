package net.siegerpg.siege.core.listeners;

import net.siegemc.core.utils.NBT;
import net.siegemc.core.utils.Utils;
import net.siegemc.core.utils.VaultHook;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataHolder;

import java.util.List;

public class StatGemListener implements Listener {

    @EventHandler
    public void onGemMerge(InventoryClickEvent e) {
        ItemStack gem = e.getCursor();
        ItemStack tool = e.getInventory().getItem(e.getSlot());

        if (gem.getType() == Material.POPPED_CHORUS_FRUIT) {
            // TODO(MAKE WORK)
            //Twig twig = new Twig(50);
            //Bukkit.broadcastMessage(String.valueOf(twig.getQuality()));
            //Bukkit.broadcastMessage(String.valueOf(twig.getItem()));
            //e.getWhoClicked().getInventory().addItem(new Twig(50).getItem());
        }

    }

    //creates the stat gem
    public ItemStack createStatGem(String statType, double statValue) {
        ItemStack statGem = Utils.createItem(Material.POPPED_CHORUS_FRUIT,
                ChatColor.DARK_PURPLE + statType + " Gem", true, 1,
                "&7+ " + statValue + " &d" + statType);

        NBT.addDouble((PersistentDataHolder) statGem, statType, statValue);
        return statGem;
    }

    //add stats of the gem to clicked item
    public void addStatGem(ItemStack gem, ItemStack tool, Player player) {
        /*
        statGem = new ItemStack(Material.LEGACY_SKULL_ITEM, 1 , (short) SkullType.PLAYER.ordinal());
        SkullMeta meta = (SkullMeta) statGem.getItemMeta();
        meta.setOwner();
        meta.setDisplayName(ChatColor.GREEN + "Strength");
        statGem.setItemMeta(meta);
        */
        if (!gem.hasItemMeta()) return;
        if (!tool.hasItemMeta()) return;
        if (gem.getLore() == null) return;
        if (tool.getLore() == null) return;
        Integer weaponCheck = NBT.getInt((PersistentDataHolder) tool, "weapon");
        Integer armorCheck = NBT.getInt((PersistentDataHolder) tool, "armor");
        if ((weaponCheck + armorCheck) == 0) return; //If it isn't an armor piece, return it

        String[] stats = {"Strength", "Regeneration", "Luck", "Wisdom", "Health", "Toughness"};
        String statName = null;
        for (String stat : stats) { //Search for the stat in the item's lore
            if (gem.getLore().contains(stat)) {
                statName = stat;
                break;
            }
        }
        if (statName == null) return;

        double gemStatVal = NBT.getDouble((PersistentDataHolder) gem, statName); //By default returns 0
        double toolStatVal = NBT.getDouble((PersistentDataHolder) tool, statName); //By default returns 0
        if ((gemStatVal * toolStatVal) == 0) return;
        if (NBT.getInt((PersistentDataHolder) tool, "GemsAdded") == 1) return;
        if (VaultHook.econ.getBalance(player) >= Math.pow(gemStatVal, 3)) {
            Double d = gemStatVal;
            int gemStatValInt = d.intValue(); //Makes the gemStatVal an integer to be removed from the balance
            VaultHook.econ.withdrawPlayer(player, Math.pow(gemStatValInt, 3));
        }

        NBT.addDouble((PersistentDataHolder) tool, statName, gemStatVal); //adds the registered stat of the gem to the tool
        NBT.addDouble((PersistentDataHolder) tool, statName + "Gem", gemStatVal); //stores gem value in item nbt
        NBT.addInt((PersistentDataHolder) tool, "GemsAdded", 1); //adds the registered stat of the gem to the tool

        List<String> loreLines = tool.getLore();
        loreLines.add(ChatColor.DARK_PURPLE + statName + " Gem " + ChatColor.LIGHT_PURPLE + "+ " + gemStatVal);
        tool.setLore(loreLines); //add the gem display to the last line of the item lore

        player.setItemOnCursor(null);
        player.sendMessage(ChatColor.RED + "You can not apply this gem to this item.");
    }
}
