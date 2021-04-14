package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegemc.core.utils.Levels;
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.DirtClump;
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.Seed;
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

import java.util.ArrayList;
import java.util.HashMap;


public class BlockBreakListener implements Listener {

    @EventHandler
    public void breakEvent(BlockBreakEvent e) {
        Material block = e.getBlock().getType();
        BlockData blockData = e.getBlock().getBlockData();
        Location loc = e.getBlock().getLocation();
        Player player = e.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE) { return; }

        if (blockDrops.get(block) == null) { //if block doesn't have a drop table, cancel the event            e.setCancelled(true);
            return;
        }

        e.setDropItems(false);

        giveBlockDrops(block, player);
        Short expReward = dropTable.getExpReward();

        if (expReward > 0) { Levels.addExp(player, expReward); } //Give exp reward

        for (ItemStack drop : dropTable.getItemRewards()) { //Loop through all drops
            e.getBlock().getWorld().dropItemNaturally(loc, drop);
        }

        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            e.getBlock().setType(Material.BEDROCK);
        }, 1);

        //Will need to create a method of adding the blocks to a config file to prevent block loss in server crashes
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            loc.getBlock().setBlockData(blockData);
        }, 20L); //Need to recheck to make sure regen time is properly made as a delay
    }
    short expReward = 0; //Won't give exp
    ArrayList<ItemStack> itemRewards = new ArrayList<>(); //List of items that will be dropped
    short blockRegenDelay = 20; //1 second block regeneration
    double luckChance = 0.0;
    double extraDropChance = 0.0;


    public static HashMap<String, Object[]> grassBlock = new HashMap<String, Object[]>() {{
        put("Dirt Clump", new Object[]{ new DirtClump().getItem(), 30.0 });
        put("Seed", new Object[]{ new Seed().getItem(), 10.0 });
        put("Turf", new Number[]{ 1, 1, 5 });
        put("Moss", new Number[]{ 1, 1, 1 });
        put("Mossy Dirt", new Number[]{ 1, 1, 0.5 });
    }};

    public static HashMap<String, Object[]> dirt = new HashMap<String, Object[]>() {{
        put("Dirt Clump", new Object[]{ new DirtClump().getItem(), 30.0 });
        put("Pebble", new Number[]{ 1, 1, 25 });
    }};

    public static HashMap<String, Object[]> podzol = new HashMap<String, Object[]>() {{
        put("Dirt Clump", new Object[]{ new DirtClump().getItem(), 80.0 });
    }};

    public static HashMap<String, Object[]> stone = new HashMap<String, Object[]>() {{
        put("Pebble", new Number[]{ 1, 1, 75 });
        put("Stone", new Number[]{ 1, 1, 1 });
    }};

    public static HashMap<String, Object[]> vine = new HashMap<String, Object[]>() {{
        put("Vine", new Number[]{ 1, 1, 100 });
    }};

    public static HashMap<String, Object[]> wood = new HashMap<String, Object[]>() {{
        put("Wood", new Number[]{ 1, 1, 100 });
    }};

    public static HashMap<String, Object[]> ironOre = new HashMap<String, Object[]>() {{
        put("Metal Scrap", new Number[]{ 1, 1, 100 });
    }};

    public static HashMap<Material, HashMap<String, Object[]>> blockDrops = new HashMap<Material, HashMap<String, Object[]>>() {{
        put(Material.GRASS_BLOCK, grassBlock);
        put(Material.DIRT, dirt);
        put(Material.COARSE_DIRT, dirt);
        put(Material.PODZOL, podzol);
        put(Material.STONE, stone);
        put(Material.LIGHT_GRAY_CONCRETE, stone);
        put(Material.ANDESITE, stone);
        put(Material.VINE, vine);
        put(Material.SPRUCE_WOOD, wood);
        put(Material.SPRUCE_LOG, wood);
        put(Material.OAK_WOOD, wood);
        put(Material.OAK_PLANKS, wood);
        put(Material.IRON_ORE, ironOre);
    }};



    public void giveBlockDrops(Material blockType, Player player) {
        HashMap<String, Object[]> drops = blockDrops.get(blockType);          //Get the drop table for the block mined
        for (String mapElem : blockDrops.get(blockType).keySet()) {           //Loop through all drops that the block can drop
            Object[] blockDropInfo = drops.get(mapElem);                      //Get the item stack and the drop chance of the item in an array of objects
            calcDrop((ItemStack) blockDropInfo[0], (Double) blockDropInfo[1]);//Use drop chance to see if block will be added to rewards array
        }
    }
    private void calcDrop(ItemStack item, double dropChance) {

        if (((Math.random() * 100) + 1) <= (dropChance + extraDropChance)) { //Default chance to get a grass block
            if (((Math.random() * 100) + 1) <= (luckChance/2)) { //Adds another item if player is lucky
                itemRewards.add(item);
            }
            itemRewards.add(item);
        }
    }
}
