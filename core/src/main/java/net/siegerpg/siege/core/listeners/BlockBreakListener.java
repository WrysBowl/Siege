package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.dropTable.dropTable;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.types.subtypes.CustomEquipment;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


public class BlockBreakListener implements Listener {

    @EventHandler
    public void breakEvent(BlockBreakEvent e) {Player player = e.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE) { return; }

        Material block = e.getBlock().getType();
        dropTable.blockDrops blockDrop = dropTable.blockDrops.matchCaseBlockDrops(block.toString());

        e.setDropItems(false);
        if (blockDrop == null) {
            e.setCancelled(true);
            return;
        }

        BlockData blockData = e.getBlock().getBlockData();
        Location loc = e.getBlock().getLocation();
        ItemStack goldCoins = Utils.getGoldCoin();
        goldCoins.setAmount(blockDrop.getGold());

        if (blockDrop.getExp() > 0) { Levels.addExp(player, blockDrop.getExp()); } //Give exp reward

        e.getBlock().getWorld().dropItemNaturally(loc, goldCoins); //Give gold reward

        for (ItemStack drop : blockDrop.getRewards(CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK))) { //Loop through all drops
            e.getBlock().getWorld().dropItemNaturally(loc, drop);
        }

        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            e.getBlock().setType(Material.BEDROCK);
        }, 1L);

        //Will need to create a method of adding the blocks to a config file to prevent block loss in server crashes
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            loc.getBlock().setBlockData(blockData);
        }, blockDrop.getRegenTime()); //Need to recheck to make sure regen time is properly made as a delay
    }
}
