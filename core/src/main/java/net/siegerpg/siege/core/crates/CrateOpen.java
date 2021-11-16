package net.siegerpg.siege.core.crates;

import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import net.siegerpg.siege.core.miscellaneous.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.Map;

public class CrateOpen implements Listener {

    public static ArrayList<Location> currentlyUsedChests = new ArrayList<>();

    @EventHandler
    public void onCrateOpen(PlayerInteractEvent e) {

        //Make sure clicked block is trapped chest in the Hub
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        Block targetedBlock = e.getClickedBlock();
        if (targetedBlock == null) return;
        if (targetedBlock.getType() != Material.ENDER_CHEST) return;
        if (!targetedBlock.getLocation().getWorld().getName().equals("Hub")) return;
        if (currentlyUsedChests.contains(targetedBlock.getLocation())) return;

        //Make sure item is a cosmetic key
        Player player = e.getPlayer();
        CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
        if (item == null) return;
        if (!(item instanceof CustomKey)) return;
        if (!keyCheck(item)) return;

        //Add chest location to arraylist to prevent further use
        currentlyUsedChests.add(targetedBlock.getLocation());

        //Pick item reward to give to player
        CosmeticDropTable dropTable = getItem(item);
        if (dropTable == null) return;
        CustomCosmetic reward = dropTable.pickItem();
        e.setCancelled(true);

        //Play item getting animation
        //Plays item win effect
        //Gives item to player
        Bukkit.broadcast(Utils.parse("<green>"+player.getName()+" is opening a crate!"));

        new Animation().openCrate(
                targetedBlock.getLocation().toCenterLocation(),
                dropTable.dropTable.keySet(),
                reward, player);
        player.getInventory().removeItem(item.getItem().asOne());

    }
    private boolean keyCheck(CustomItem item) {
        for (Map.Entry<CustomKey, CosmeticDropTable> entry : CosmeticCrate.crates.entrySet()) {
            CustomKey key = entry.getKey();
            if (item.getClass() == key.getClass()) return true;
        }
        return false;
    }
    private CosmeticDropTable getItem(CustomItem item) {
        for (Map.Entry<CustomKey, CosmeticDropTable> entry : CosmeticCrate.crates.entrySet()) {
            CustomKey key = entry.getKey();
            if (item.getClass() == key.getClass()) return entry.getValue();
        }
        return null;
    }
}
