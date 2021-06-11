package net.siegerpg.siege.core.listeners;

import kotlin.Triple;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.Webstore.WebstoreUtils;
import net.siegerpg.siege.core.cache.PreviousBrokenBlock;
import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.BlockDrops;
import net.siegerpg.siege.core.drops.blocks.Stone;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.enums.StatTypes;
import net.siegerpg.siege.core.utils.GoldEXPSpawning;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BlockBreakListener implements Listener {

    public static List<Material> keepAir = new ArrayList<>() {
        {
            add(Material.WHEAT);
            add(Material.VINE);
            add(Material.STONE_BUTTON);
        }
    };
    public static List<Material> dependables = new ArrayList<>() {
        {
            add(Material.OAK_SAPLING);
            add(Material.SPRUCE_SAPLING);
            add(Material.BIRCH_SAPLING);
            add(Material.JUNGLE_SAPLING);
            add(Material.ACACIA_SAPLING);
            add(Material.DARK_OAK_SAPLING);
            add(Material.GRASS);
            add(Material.FERN);
            add(Material.DEAD_BUSH);
            add(Material.SEAGRASS);
            add(Material.LILY_OF_THE_VALLEY);
            add(Material.LILY_PAD);
            add(Material.BLUE_ORCHID);
            add(Material.FERN);
            add(Material.ORANGE_TULIP);
            add(Material.WHITE_TULIP);
            add(Material.AZURE_BLUET);
            add(Material.OXEYE_DAISY);
            add(Material.WITHER_ROSE);
            add(Material.BROWN_MUSHROOM);
            add(Material.RED_MUSHROOM);
            add(Material.CRIMSON_FUNGUS);
            add(Material.WARPED_FUNGUS);
            add(Material.CRIMSON_ROOTS);
            add(Material.WARPED_ROOTS);
            add(Material.NETHER_SPROUTS);
            add(Material.WEEPING_VINES);
            add(Material.TWISTING_VINES);
            add(Material.KELP);
            add(Material.ALLIUM);
            add(Material.DANDELION);
            add(Material.RED_TULIP);
            add(Material.CORNFLOWER);
            add(Material.PINK_TULIP);
            add(Material.POPPY);
            add(Material.CACTUS);
            add(Material.PEONY);
            add(Material.SUNFLOWER);
            add(Material.LILAC);
            add(Material.ROSE_BUSH);
            add(Material.TALL_GRASS);
            add(Material.LARGE_FERN);
            add(Material.WHEAT);
            add(Material.BAMBOO);
            add(Material.SUGAR_CANE);
            add(Material.BEETROOT_SEEDS);
            add(Material.MELON_SEEDS);
            add(Material.PUMPKIN_SEEDS);
            add(Material.WHEAT_SEEDS);
            add(Material.CARROT);
            add(Material.NETHER_WART);
        }
    };
    public static List<Material> rewardableBlocks = new ArrayList<>() {
        {
            add(Material.GRASS);
            add(Material.DEAD_BUSH);
            add(Material.LILY_OF_THE_VALLEY);
            add(Material.LILY_PAD);
            add(Material.BLUE_ORCHID);
            add(Material.FERN);
            add(Material.ORANGE_TULIP);
            add(Material.WHITE_TULIP);
            add(Material.AZURE_BLUET);
            add(Material.OXEYE_DAISY);
            add(Material.WITHER_ROSE);
            add(Material.BROWN_MUSHROOM);
            add(Material.RED_MUSHROOM);
            add(Material.ALLIUM);
            add(Material.DANDELION);
            add(Material.RED_TULIP);
            add(Material.CORNFLOWER);
            add(Material.PINK_TULIP);
            add(Material.POPPY);
            add(Material.POTTED_WITHER_ROSE);
            add(Material.POTTED_ACACIA_SAPLING);
            add(Material.POTTED_ALLIUM);
            add(Material.POTTED_BAMBOO);
            add(Material.POTTED_AZURE_BLUET);
            add(Material.POTTED_BIRCH_SAPLING);
            add(Material.POTTED_BLUE_ORCHID);
            add(Material.POTTED_BROWN_MUSHROOM);
            add(Material.POTTED_CACTUS);
            add(Material.POTTED_CORNFLOWER);
            add(Material.POTTED_CRIMSON_FUNGUS);
            add(Material.POTTED_CRIMSON_ROOTS);
            add(Material.POTTED_DANDELION);
            add(Material.POTTED_DARK_OAK_SAPLING);
            add(Material.POTTED_DEAD_BUSH);
            add(Material.POTTED_FERN);
            add(Material.POTTED_JUNGLE_SAPLING);
            add(Material.POTTED_LILY_OF_THE_VALLEY);
            add(Material.POTTED_OAK_SAPLING);
            add(Material.POTTED_ORANGE_TULIP);
            add(Material.POTTED_OXEYE_DAISY);
            add(Material.POTTED_PINK_TULIP);
            add(Material.POTTED_POPPY);
            add(Material.POTTED_RED_MUSHROOM);
            add(Material.POTTED_RED_TULIP);
            add(Material.POTTED_SPRUCE_SAPLING);
            add(Material.POTTED_WARPED_FUNGUS);
            add(Material.POTTED_WARPED_ROOTS);
            add(Material.POTTED_WHITE_TULIP);
        }
    };
    public static HashMap<Material, BlockDropTable> blockDropTableHashMap = new HashMap<>(){
        {
            put(Material.STONE, new Stone());

        }
    };
/*
    @EventHandler
    public void newBreakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();

        //Stop any block drops if player isn't in survival
        if (player.getGameMode() != GameMode.SURVIVAL) {
            e.setCancelled(false);
            return;
        }
        e.setCancelled(true);
        e.setDropItems(false);
        Material blockType = e.getBlock().getType();
        final BlockState blockState = e.getBlock().getState();
        final Location loc = e.getBlock().getLocation();
        BlockDropTable blockDrop = blockDropTableHashMap.get(blockType);

        //if block broken doesn't have a drop table
        if (blockDrop == null) {
            if (rewardableBlocks.contains(blockType)) {
                e.setCancelled(false);
                if (Utils.randTest(20.0)) {
                    GoldEXPSpawning.spawnEXP(1, loc);
                }
                if (Utils.randTest(20.0)) {
                    GoldEXPSpawning.spawnGold(1, loc);
                }
                //after 30 seconds, block respawns back
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
                    public void run() {
                        blockState.update(true, false);
                    }
                }, 600);
            }
            return;
        }
        final int blockDropRegen = blockDrop.getBlockRegen();
        final double luckVal = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());
        int goldCoinAmt = blockDrop.getGold(true);
        int exp = blockDrop.getExp(true);
        final boolean fullInv = e.getPlayer().getInventory().firstEmpty() == -1;
        final boolean upFacingDependable = dependables.contains(e.getBlock().getRelative(BlockFace.UP).getType());
        final boolean downFacingDependable = dependables.contains(e.getBlock().getRelative(BlockFace.UP).getType());


        if (keepAir.contains(blockType)) {
            e.setCancelled(false);
        } else if (dependables.contains(blockType) || upFacingDependable || downFacingDependable) {
            e.setCancelled(true);
        } else {
            e.getBlock().setType(Material.BEDROCK);
        }
        if (!dependables.contains(blockType) && upFacingDependable || downFacingDependable) {
            return;
        }

        if (goldCoinAmt > 0) {
            goldCoinAmt = (int) Math.floor(goldCoinAmt * WebstoreUtils.goldMultiplier);
            GoldEXPSpawning.spawnGold(goldCoinAmt, loc);
        }

        if (blockDrop.getExp(true) > 0) {
            exp = (int) Math.floor(exp * WebstoreUtils.expMultiplier);
            GoldEXPSpawning.spawnEXP(exp, loc);
        }


        //Adds blocks to player's inventory
        for (ItemStack drop : blockDrop.getRewards(luckVal)) {
            if (!fullInv) {
                e.getPlayer().getInventory().addItem(drop);
            } else {
                e.getBlock().getWorld().dropItemNaturally(loc, drop);
            }

        }

        //Sets block back from bedrock to original
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
            public void run() {
                blockState.update(true, false);
            }
        }, blockDropRegen);
    }*/


    @EventHandler
    public void breakEvent(BlockBreakEvent e) {
        Player player = e.getPlayer();

        //Stop any block drops if player isn't in survival
        if (player.getGameMode() != GameMode.SURVIVAL) {
            e.setCancelled(false);
            return;
        }

        e.setCancelled(true);
        e.setDropItems(false);
        Material blockType = e.getBlock().getType();
        final BlockState blockState = e.getBlock().getState();
        final Location loc = e.getBlock().getLocation();
        BlockDrops blockDrop = null;

        //Search for already stored block drop table
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
            }
            break;
        }


        if (blockDrop == null) {
            blockDrop = BlockDrops.matchCaseBlockDrops(blockType.toString());
            if (blockDrop == null) {
                if (rewardableBlocks.contains(blockType)) {
                    e.setCancelled(false);
                    if (Utils.randTest(20.0)) {
                        GoldEXPSpawning.spawnEXP(1, loc);
                    }
                    if (Utils.randTest(20.0)) {
                        GoldEXPSpawning.spawnGold(1, loc);
                    }
                    //after 30 seconds, block respawns back
                    Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
                        public void run() {
                            blockState.update(true, false);
                        }
                    }, 600);
                }
                return;
            }
            PreviousBrokenBlock.previousBlock.add(new Triple<>(player, blockType, blockDrop));
        }


        final int blockDropRegen = blockDrop.getRegenTime();
        final double luckVal = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());
        int goldCoinAmt = blockDrop.getGold(true);
        int exp = blockDrop.getExp(true);
        final boolean fullInv = e.getPlayer().getInventory().firstEmpty() == -1;
        final boolean upFacingDependable = dependables.contains(e.getBlock().getRelative(BlockFace.UP).getType());
        final boolean downFacingDependable = dependables.contains(e.getBlock().getRelative(BlockFace.UP).getType());


        if (keepAir.contains(blockType)) {
            e.setCancelled(false);
        } else if (dependables.contains(blockType) || upFacingDependable || downFacingDependable) {
            e.setCancelled(true);
        } else {
            e.getBlock().setType(Material.BEDROCK);
        }
        if (!dependables.contains(blockType) && upFacingDependable || downFacingDependable) {
            return;
        }

        if (goldCoinAmt > 0) {
            goldCoinAmt = (int) Math.floor(goldCoinAmt * WebstoreUtils.goldMultiplier);
            GoldEXPSpawning.spawnGold(goldCoinAmt, loc);
        }

        if (blockDrop.getExp(true) > 0) {
            exp = (int) Math.floor(exp * WebstoreUtils.expMultiplier);
            GoldEXPSpawning.spawnEXP(exp, loc);
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
