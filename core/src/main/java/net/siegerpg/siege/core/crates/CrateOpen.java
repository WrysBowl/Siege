package net.siegerpg.siege.core.crates;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

public class CrateOpen implements Listener {

    @EventHandler
    public void onCrateOpen(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block targetedBlock = e.getClickedBlock();
        if (targetedBlock == null) return;
        if (targetedBlock.getType() != Material.CHEST) return;
        //command should take player's key and determine which drop table to choose from
        //pick random item from drop table
        //take as input the player
        //negate all interaction with this chest location if item has not yet been given to player
        //play animation of items cycling through and land on the cosmetic item chosen
        //if player leaves the server
    }
}
