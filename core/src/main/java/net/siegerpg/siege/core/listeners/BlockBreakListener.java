package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.drops.BlockDrops;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
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

public class BlockBreakListener implements Listener {

    @EventHandler
    public void breakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (player.getGameMode() != GameMode.SURVIVAL) {
            e.setCancelled(false);
            return;
        }

        Material block = e.getBlock().getType();
        BlockDrops blockDrop = BlockDrops.matchCaseBlockDrops(block.toString());

        e.setDropItems(false);
        e.setCancelled(true);
        if (blockDrop == null) {return;}

        BlockData blockData = e.getBlock().getBlockData();
        Location loc = e.getBlock().getLocation();
        ItemStack goldCoins = Utils.getGoldCoin();
        goldCoins.setAmount(blockDrop.getGold(true));

        if ((Math.random() * 100) <= CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand())) {
            goldCoins.setAmount(goldCoins.getAmount() * 2);
        }

        e.getBlock().setType(Material.BEDROCK);

        if (blockDrop.getExp(true) > 0) {
            int exp = blockDrop.getExp(true);
            if ((Math.random() * 100) <= CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand())) {
                exp *= 2;
            }
            Levels.INSTANCE.addExp(player, exp);
            player.sendActionBar(Utils.parse("<dark_purple>+ " + exp + " <dark_purple>EXP"));
        } //Give exp reward

        if (goldCoins.getAmount() > 0) { e.getBlock().getWorld().dropItemNaturally(loc, goldCoins); } //Give gold reward

        for (ItemStack drop : blockDrop.getRewards(CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK))) { //Loop through all drops
            e.getBlock().getWorld().dropItemNaturally(loc, drop);
        }

        //Will need to create a method of adding the blocks to a config file to prevent block loss in server crashes
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> loc.getBlock().setBlockData(blockData), blockDrop.getRegenTime()); //Need to recheck to make sure regen time is properly made as a delay
    }

}
