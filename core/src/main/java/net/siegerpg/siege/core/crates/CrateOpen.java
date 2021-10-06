package net.siegerpg.siege.core.crates;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.api.exceptions.InvalidMobTypeException;
import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.events.BossFight;
import net.siegerpg.siege.core.events.BossLeaderboard;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.Rarity;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.items.types.subtypes.CustomCosmetic;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.time.Instant;
import java.util.ArrayList;

public class CrateOpen implements Listener {

    public static ArrayList<Location> currentlyUsedChests;

    @EventHandler
    public void onCrateOpen(PlayerInteractEvent e) {

        //Make sure clicked block is trapped chest in the Hub
        Block targetedBlock = e.getClickedBlock();
        if (targetedBlock == null) return;
        if (targetedBlock.getType() != Material.TRAPPED_CHEST) return;
        if (currentlyUsedChests.contains(targetedBlock.getLocation())) return;
        if (!targetedBlock.getLocation().getWorld().getName().equals("Hub")) return;

        //Make sure item is a cosmetic key
        Player player = e.getPlayer();
        CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(player.getInventory().getItemInMainHand());
        if (item == null) return;
        if (!(item instanceof CustomKey)) return;
        if (CosmeticCrate.crates.get(item) == null) return; //ensure item used is a cosmetic key

        //Add chest location to arraylist to prevent further use
        currentlyUsedChests.add(targetedBlock.getLocation());

        //Pick item reward to give to player
        CosmeticDropTable dropTable = CosmeticCrate.crates.get(item);
        CustomCosmetic reward = dropTable.pickItem();

        //Play item getting animation
        //Plays item win effect
        //Gives item to player
        new Animation().openCrate(
                targetedBlock.getLocation(),
                dropTable.dropTable.keySet(),
                reward, player);
    }
}
