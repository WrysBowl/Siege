package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.cache.GlobalMultipliers;
import net.siegerpg.siege.core.webstore.categories.boosters.WebstoreBoosters;
import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.materials.*;
import net.siegerpg.siege.core.drops.materials.decor.*;
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
            this.add(Material.WHEAT);
            this.add(Material.VINE);
            this.add(Material.STONE_BUTTON);
        }
    };
    public static List<Material> dependables = new ArrayList<>() {
        {
            this.add(Material.OAK_SAPLING);
            this.add(Material.SPRUCE_SAPLING);
            this.add(Material.BIRCH_SAPLING);
            this.add(Material.JUNGLE_SAPLING);
            this.add(Material.ACACIA_SAPLING);
            this.add(Material.DARK_OAK_SAPLING);
            this.add(Material.GRASS);
            this.add(Material.FERN);
            this.add(Material.DEAD_BUSH);
            this.add(Material.SEAGRASS);
            this.add(Material.LILY_OF_THE_VALLEY);
            this.add(Material.LILY_PAD);
            this.add(Material.BLUE_ORCHID);
            this.add(Material.FERN);
            this.add(Material.ORANGE_TULIP);
            this.add(Material.WHITE_TULIP);
            this.add(Material.AZURE_BLUET);
            this.add(Material.OXEYE_DAISY);
            this.add(Material.WITHER_ROSE);
            this.add(Material.BROWN_MUSHROOM);
            this.add(Material.RED_MUSHROOM);
            this.add(Material.CRIMSON_FUNGUS);
            this.add(Material.WARPED_FUNGUS);
            this.add(Material.CRIMSON_ROOTS);
            this.add(Material.WARPED_ROOTS);
            this.add(Material.NETHER_SPROUTS);
            this.add(Material.WEEPING_VINES);
            this.add(Material.TWISTING_VINES);
            this.add(Material.KELP);
            this.add(Material.ALLIUM);
            this.add(Material.DANDELION);
            this.add(Material.RED_TULIP);
            this.add(Material.CORNFLOWER);
            this.add(Material.PINK_TULIP);
            this.add(Material.POPPY);
            this.add(Material.CACTUS);
            this.add(Material.PEONY);
            this.add(Material.SUNFLOWER);
            this.add(Material.LILAC);
            this.add(Material.ROSE_BUSH);
            this.add(Material.TALL_GRASS);
            this.add(Material.LARGE_FERN);
            this.add(Material.WHEAT);
            this.add(Material.BAMBOO);
            this.add(Material.SUGAR_CANE);
            this.add(Material.BEETROOT_SEEDS);
            this.add(Material.MELON_SEEDS);
            this.add(Material.PUMPKIN_SEEDS);
            this.add(Material.WHEAT_SEEDS);
            this.add(Material.CARROT);
            this.add(Material.NETHER_WART);
        }
    };
    public static List<Material> rewardableBlocks = new ArrayList<>() {
        {
            this.add(Material.GRASS);
            this.add(Material.DEAD_BUSH);
            this.add(Material.LILY_OF_THE_VALLEY);
            this.add(Material.LILY_PAD);
            this.add(Material.BLUE_ORCHID);
            this.add(Material.FERN);
            this.add(Material.ORANGE_TULIP);
            this.add(Material.WHITE_TULIP);
            this.add(Material.AZURE_BLUET);
            this.add(Material.OXEYE_DAISY);
            this.add(Material.WITHER_ROSE);
            this.add(Material.BROWN_MUSHROOM);
            this.add(Material.RED_MUSHROOM);
            this.add(Material.ALLIUM);
            this.add(Material.DANDELION);
            this.add(Material.RED_TULIP);
            this.add(Material.CORNFLOWER);
            this.add(Material.PINK_TULIP);
            this.add(Material.POPPY);
            this.add(Material.POTTED_WITHER_ROSE);
            this.add(Material.POTTED_ACACIA_SAPLING);
            this.add(Material.POTTED_ALLIUM);
            this.add(Material.POTTED_BAMBOO);
            this.add(Material.POTTED_AZURE_BLUET);
            this.add(Material.POTTED_BIRCH_SAPLING);
            this.add(Material.POTTED_BLUE_ORCHID);
            this.add(Material.POTTED_BROWN_MUSHROOM);
            this.add(Material.POTTED_CACTUS);
            this.add(Material.POTTED_CORNFLOWER);
            this.add(Material.POTTED_CRIMSON_FUNGUS);
            this.add(Material.POTTED_CRIMSON_ROOTS);
            this.add(Material.POTTED_DANDELION);
            this.add(Material.POTTED_DARK_OAK_SAPLING);
            this.add(Material.POTTED_DEAD_BUSH);
            this.add(Material.POTTED_FERN);
            this.add(Material.POTTED_JUNGLE_SAPLING);
            this.add(Material.POTTED_LILY_OF_THE_VALLEY);
            this.add(Material.POTTED_OAK_SAPLING);
            this.add(Material.POTTED_ORANGE_TULIP);
            this.add(Material.POTTED_OXEYE_DAISY);
            this.add(Material.POTTED_PINK_TULIP);
            this.add(Material.POTTED_POPPY);
            this.add(Material.POTTED_RED_MUSHROOM);
            this.add(Material.POTTED_RED_TULIP);
            this.add(Material.POTTED_SPRUCE_SAPLING);
            this.add(Material.POTTED_WARPED_FUNGUS);
            this.add(Material.POTTED_WARPED_ROOTS);
            this.add(Material.POTTED_WHITE_TULIP);
        }
    };
    public static HashMap<Material, BlockDropTable> blockDropTableHashMap = new HashMap<>(){
        {
            this.put(Material.ACACIA_LOG, new ACACIA_LOG());
            this.put(Material.ACACIA_WOOD, new ACACIA_WOOD());
            this.put(Material.ANDESITE, new ANDESITE());
            this.put(Material.BAMBOO, new BAMBOO());
            this.put(Material.BIRCH_LEAVES, new BIRCH_LEAVES());
            this.put(Material.BIRCH_LOG, new BIRCH_LOG());
            this.put(Material.BIRCH_WOOD, new BIRCH_WOOD());
            this.put(Material.CHAIN, new CHAIN());
            this.put(Material.COAL_ORE, new COAL_ORE());
            this.put(Material.COARSE_DIRT, new COARSE_DIRT());
            this.put(Material.DARK_OAK_LEAVES, new DARK_OAK_LEAVES());
            this.put(Material.DARK_OAK_LOG, new DARK_OAK_LOG());
            this.put(Material.DARK_OAK_WOOD, new DARK_OAK_WOOD());
            this.put(Material.DIRT, new DIRT());
            this.put(Material.GRASS_BLOCK, new GRASS_BLOCK());
            this.put(Material.GREEN_CONCRETE, new GREEN_CONCRETE());
            this.put(Material.GREEN_TERRACOTTA, new GREEN_TERRACOTTA());
            this.put(Material.HAY_BLOCK, new HAY_BLOCK());
            this.put(Material.IRON_ORE, new IRON_ORE());
            this.put(Material.JUNGLE_LEAVES, new JUNGLE_LEAVES());
            this.put(Material.JUNGLE_LOG, new JUNGLE_LOG());
            this.put(Material.JUNGLE_WOOD, new JUNGLE_WOOD());
            this.put(Material.LIGHT_GRAY_CONCRETE, new LIGHT_GRAY_CONCRETE());
            this.put(Material.LIME_TERRACOTTA, new LIME_TERRACOTTA());
            this.put(Material.OAK_LEAVES, new OAK_LEAVES());
            this.put(Material.OAK_LOG, new OAK_LOG());
            this.put(Material.OAK_WOOD, new OAK_WOOD());
            this.put(Material.PINK_CONCRETE, new PINK_CONCRETE());
            this.put(Material.PINK_CONCRETE_POWDER, new PINK_CONCRETE_POWDER());
            this.put(Material.PINK_STAINED_GLASS, new PINK_STAINED_GLASS());
            this.put(Material.SHROOMLIGHT, new SHROOMLIGHT());
            this.put(Material.SNOW, new SNOW());
            this.put(Material.SNOW_BLOCK, new SNOW_BLOCK());
            this.put(Material.SPRUCE_LEAVES, new SPRUCE_LEAVES());
            this.put(Material.SPRUCE_LOG, new SPRUCE_LOG());
            this.put(Material.SPRUCE_WOOD, new SPRUCE_WOOD());
            this.put(Material.STONE, new STONE());
            this.put(Material.STRIPPED_ACACIA_LOG, new STRIPPED_ACACIA_LOG());
            this.put(Material.STRIPPED_ACACIA_WOOD, new STRIPPED_ACACIA_WOOD());
            this.put(Material.STRIPPED_BIRCH_LOG, new STRIPPED_BIRCH_LOG());
            this.put(Material.STRIPPED_BIRCH_WOOD, new STRIPPED_BIRCH_WOOD());
            this.put(Material.STRIPPED_DARK_OAK_LOG, new STRIPPED_DARK_OAK_LOG());
            this.put(Material.STRIPPED_DARK_OAK_WOOD, new STRIPPED_DARK_OAK_WOOD());
            this.put(Material.STRIPPED_JUNGLE_LOG, new STRIPPED_JUNGLE_LOG());
            this.put(Material.STRIPPED_JUNGLE_WOOD, new STRIPPED_JUNGLE_WOOD());
            this.put(Material.STRIPPED_OAK_LOG, new STRIPPED_OAK_LOG());
            this.put(Material.STRIPPED_OAK_WOOD, new STRIPPED_OAK_WOOD());
            this.put(Material.STRIPPED_SPRUCE_LOG, new STRIPPED_SPRUCE_LOG());
            this.put(Material.STRIPPED_SPRUCE_WOOD, new STRIPPED_SPRUCE_WOOD());
            this.put(Material.STRIPPED_WARPED_HYPHAE, new STRIPPED_WARPED_HYPHAE());
            this.put(Material.SUGAR_CANE, new SUGAR_CANE());
            this.put(Material.VINE, new VINE());
            this.put(Material.WARPED_HYPHAE, new WARPED_HYPHAE());
            this.put(Material.WHEAT, new WHEAT());

            this.put(Material.ALLIUM, new ALLIUM());
            this.put(Material.AZURE_BLUET, new AZURE_BLUET());
            this.put(Material.BLUE_ORCHID, new BLUE_ORCHID());
            this.put(Material.BROWN_MUSHROOM, new BROWN_MUSHROOM());
            this.put(Material.CORNFLOWER, new CORNFLOWER());
            this.put(Material.DANDELION, new DANDELION());
            this.put(Material.DEAD_BUSH, new DEAD_BUSH());
            this.put(Material.FERN, new FERN());
            this.put(Material.GRASS, new GRASS());
            this.put(Material.LILY_OF_THE_VALLEY, new LILY_OF_THE_VALLEY());
            this.put(Material.LILY_PAD, new LILY_PAD());
            this.put(Material.ORANGE_TULIP, new ORANGE_TULIP());
            this.put(Material.PINK_TULIP, new PINK_TULIP());
            this.put(Material.POPPY, new POPPY());
            this.put(Material.RED_MUSHROOM, new RED_MUSHROOM());
            this.put(Material.RED_TULIP, new RED_TULIP());
            this.put(Material.WHITE_TULIP, new WHITE_TULIP());
            this.put(Material.WITHER_ROSE, new WITHER_ROSE());
        }
    };

    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        final Player player = e.getPlayer();

        //Stop any block drops if player isn't in survival
        if (player.getGameMode() != GameMode.SURVIVAL) {
            e.setCancelled(false);
            return;
        }
        e.setCancelled(true);
        e.setDropItems(false);
        final Material blockType = e.getBlock().getType();
        BlockState blockState = e.getBlock().getState();
        Location loc = e.getBlock().getLocation();
        final BlockDropTable blockDrop = BlockBreakListener.blockDropTableHashMap.get(blockType);

        //if block broken doesn't have a drop table
        if (BlockBreakListener.rewardableBlocks.contains(blockType)) {
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
        if (blockDrop!=null){
            int blockDropRegen = blockDrop.getBlockRegen();
            double luckVal = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());
            int goldCoinAmt = blockDrop.getGold(true);
            int exp = blockDrop.getExp(true);
            final double luck = CustomItemUtils.INSTANCE.getPlayerStat(player, StatTypes.LUCK, player.getItemInHand());
            boolean fullInv = e.getPlayer().getInventory().firstEmpty() == -1;
            boolean upFacingDependable = BlockBreakListener.dependables.contains(e.getBlock().getRelative(BlockFace.UP).getType());
            boolean downFacingDependable = BlockBreakListener.dependables.contains(e.getBlock().getRelative(BlockFace.DOWN).getType());


            if (BlockBreakListener.keepAir.contains(blockType)) {
                e.setCancelled(false);
            } else if (BlockBreakListener.dependables.contains(blockType) || upFacingDependable || downFacingDependable) {
                if (!BlockBreakListener.rewardableBlocks.contains(blockType)) {
                    e.setCancelled(true);
                }
            } else {
                e.getBlock().setType(Material.BEDROCK);
            }
            if (!BlockBreakListener.dependables.contains(blockType) && upFacingDependable || !BlockBreakListener.dependables.contains(blockType) && downFacingDependable) {
                return;
            }

            if (goldCoinAmt > 0) {
                goldCoinAmt = (int) Math.floor(goldCoinAmt * GlobalMultipliers.goldMultiplier);
                if ((Math.random() * 100) <= luck) {
                    goldCoinAmt *= 2;
                }
                GoldEXPSpawning.spawnGold(goldCoinAmt, loc);
            }

            if (exp > 0) {
                exp = (int) Math.floor(exp * GlobalMultipliers.expMultiplier);
                if ((Math.random() * 100) <= luck) {
                    exp *= 2;
                }
                GoldEXPSpawning.spawnEXP(exp, loc);
            }


            //Adds blocks to player's inventory
            for (final ItemStack drop : blockDrop.getRewards(luckVal)) {
                if (!fullInv) {
                    e.getPlayer().getInventory().addItem(drop);
                } else {
                    e.getBlock().getWorld().dropItemNaturally(loc, drop);
                }

            }

            //Sets block back from bedrock to original
            if (BlockBreakListener.rewardableBlocks.contains(blockType)) return;
            Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), new Runnable() {
                public void run() {
                    blockState.update(true, false);
                }
            }, blockDropRegen);
        }

    }
}
