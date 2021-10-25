package net.siegerpg.siege.core.crates;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dungeons.Dungeon;
import net.siegerpg.siege.core.dungeons.DungeonCommand;
import net.siegerpg.siege.core.events.BossFight;
import net.siegerpg.siege.core.events.BossLeaderboard;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.Rarity;
import net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic.NormalKey;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Map;

public class CrateOpen implements Listener {

    public static ArrayList<Location> currentlyUsedChests = new ArrayList<>();

    @EventHandler
    public void onCrateOpen(final PlayerInteractEvent e) {

        //Make sure clicked block is trapped chest in the Hub
        if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        final Block targetedBlock = e.getClickedBlock();
        if (targetedBlock == null) return;
        if (targetedBlock.getType() != Material.ENDER_CHEST) return;
        if (!targetedBlock.getLocation().getWorld().getName().equals("Hub")) return;
        if (CrateOpen.currentlyUsedChests.contains(targetedBlock.getLocation())) return;

        //Make sure item is a cosmetic key
        final Player player = e.getPlayer();
        final CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
        if (item == null) return;
        if (!(item instanceof CustomKey)) return;
        if (!this.keyCheck(item)) return;

        //Add chest location to arraylist to prevent further use
	    CrateOpen.currentlyUsedChests.add(targetedBlock.getLocation());

        //Pick item reward to give to player
        final CosmeticDropTable dropTable = this.getItem(item);
        if (dropTable == null) return;
        final CustomCosmetic reward = dropTable.pickItem();
        e.setCancelled(true);

        //Play item getting animation
        //Plays item win effect
        //Gives item to player
        new Animation().openCrate(
                targetedBlock.getLocation(),
                dropTable.dropTable.keySet(),
                reward, player);
        player.getInventory().removeItem(item.getItem().asOne());

    }
    private boolean keyCheck(final CustomItem item) {
        for (final Map.Entry<CustomKey, CosmeticDropTable> entry : CosmeticCrate.crates.entrySet()) {
            final CustomKey key = entry.getKey();
            if (item.getClass() == key.getClass()) return true;
        }
        return false;
    }
    private CosmeticDropTable getItem(final CustomItem item) {
        for (final Map.Entry<CustomKey, CosmeticDropTable> entry : CosmeticCrate.crates.entrySet()) {
            final CustomKey key = entry.getKey();
            if (item.getClass() == key.getClass()) return entry.getValue();
        }
        return null;
    }
}
