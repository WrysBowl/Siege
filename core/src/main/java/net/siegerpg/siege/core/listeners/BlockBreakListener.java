package net.siegerpg.siege.core.listeners;

import io.lumine.xikage.mythicmobs.MythicMobs;
import io.lumine.xikage.mythicmobs.drops.Drop;
import kotlin.Triple;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.Webstore.WebstoreUtils;
import net.siegerpg.siege.core.cache.PreviousBrokenBlock;
import net.siegerpg.siege.core.drops.BlockDrops;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class BlockBreakListener implements Listener {

    List<Material> keepAir = new ArrayList<>() {
        {
            add(Material.WHEAT);
            add(Material.VINE);
        }
    };
    List<Material> alwaysCancel = new ArrayList<>() {
        {
            add(Material.CHAIN);
            add(Material.GRASS_BLOCK);
            add(Material.WHEAT);
            add(Material.BAMBOO);
            add(Material.SUGAR_CANE);
        }
    };

    @EventHandler
    public void breakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (player.getGameMode() != GameMode.SURVIVAL) {
            e.setCancelled(false);
            return;
        }

        e.setCancelled(true);
        e.setDropItems(false);

        Material blockType = e.getBlock().getType();
        BlockDrops blockDrop = null;
        for(Triple<Player, Material, BlockDrops> triple : PreviousBrokenBlock.previousBlock) {
            if (!triple.component1().equals(player)) continue;
            if (triple.component2().equals(blockType)) {
                blockDrop = triple.component3();
            } else {
                blockDrop = BlockDrops.matchCaseBlockDrops(blockType.toString());
                if (blockDrop != null) {
                    PreviousBrokenBlock.previousBlock.remove(triple);
                    PreviousBrokenBlock.previousBlock.add(new Triple<>(player, blockType, blockDrop));
                    break;
                }
                return;
            }
            break;
        }


        if (blockDrop == null) {
            blockDrop = BlockDrops.matchCaseBlockDrops(blockType.toString());
            if (blockDrop == null) {
                return;
            }
            PreviousBrokenBlock.previousBlock.add(new Triple<>(player, blockType, blockDrop));
        }

        final BlockState blockState = e.getBlock().getState();
        final Location loc = e.getBlock().getLocation();
        final int blockDropRegen = blockDrop.getRegenTime();
        final double luckVal = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());
        int goldCoinAmt = blockDrop.getGold(true);
        int exp = blockDrop.getExp(true);
        final boolean fullInv = e.getPlayer().getInventory().firstEmpty() == -1;

        if (keepAir.contains(blockType)) {
            e.setCancelled(false);
        } else if (alwaysCancel.contains(blockType)) {
            e.setCancelled(true);
        } else {
            e.getBlock().setType(Material.BEDROCK);
        }

        if (goldCoinAmt > 0) {
            goldCoinAmt = (int) (goldCoinAmt * WebstoreUtils.goldMultiplier);
            if ((Math.random() * 100) <= luckVal) {
                goldCoinAmt *= 2;
            }
            ItemStack goldCoin = Utils.getGoldCoin(goldCoinAmt);
            Item gold = loc.getWorld().dropItemNaturally(loc, goldCoin);
            gold.setCustomName(Utils.tacc("&e+" + goldCoinAmt + " Gold"));
            gold.setCustomNameVisible(true);
        }

        if (blockDrop.getExp(true) > 0) {
            exp = (int) (exp * WebstoreUtils.expMultiplier);
            if ((Math.random() * 100) <= luckVal) {
                exp *= 2;
            }
            ExperienceOrb orb = loc.getWorld().spawn(loc, ExperienceOrb.class);
            orb.setCustomName(Utils.tacc("&5+" + exp + " EXP"));
            orb.setExperience(exp);
            orb.setCustomNameVisible(true);
        }


        for (ItemStack drop : blockDrop.getRewards(luckVal)) {
            if (!fullInv) {
                e.getPlayer().getInventory().addItem(drop);
            } else {
                e.getBlock().getWorld().dropItemNaturally(loc, drop);
            }

        }

        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
            public void run() {
                blockState.update(true, false);
            }
        }, blockDropRegen);
    }

}
