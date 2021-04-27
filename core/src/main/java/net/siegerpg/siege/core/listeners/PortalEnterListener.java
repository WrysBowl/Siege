package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PortalEnterListener implements Listener {

    @EventHandler
    public void portalEnter(PlayerPortalEvent e) {
        World world = e.getPlayer().getWorld();
        World siegeHub = Core.plugin().getServer().getWorld("SiegeHub");
        Player player = e.getPlayer();
        
        if (world == siegeHub) {
            player.openInventory(getGUIWorldTransit());
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (e.getInventory() == getGUIWorldTransit()) {
            Short level = Levels.getLevel((OfflinePlayer) e.getWhoClicked());
            Player player = (Player) e.getWhoClicked();
            World hillyWoods = Core.plugin().getServer().getWorld("Hilly_Woods");

            if (e.getSlot() == 10 && level >= 1) {
                player.closeInventory();
                player.sendTitle("Teleporting to", Utils.tacc("&2Hilly Woods"),10, 20, 10);
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                    player.teleport(hillyWoods.getSpawnLocation());
                }, 20L);
            } else if (e.getSlot() == 17 && level >= 25) {
                player.sendMessage(Utils.tacc("&cThis isn't open to anyone yet!"));
            }
        }
    }

    private Inventory getGUIWorldTransit() {
        Inventory gui = Bukkit.createInventory(null, 27, "World Transit");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (Integer i = 0; i <= gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        //Creating Hilly Woods
        ItemStack hillyWoods = new ItemStack (Material.OAK_SAPLING);
        ItemMeta survivalMeta = hillyWoods.getItemMeta();
        survivalMeta.setDisplayName(Utils.tacc("&2Hilly Woods"));
        survivalMeta.setLore(new ArrayList<>(){
            {
                add(Utils.tacc("&7Click to travel"));
                add(Utils.tacc("&5Level 1"));
            }
        });
        hillyWoods.setItemMeta(survivalMeta);

        //Creating Sakura
        ItemStack sakura = new ItemStack (Material.OAK_SAPLING);
        ItemMeta sakuraMeta = sakura.getItemMeta();
        sakuraMeta.setDisplayName(Utils.tacc("&dSakura"));
        sakuraMeta.setLore(new ArrayList<>(){
            {
                add(Utils.tacc("&7Click to travel"));
                add(Utils.tacc("&5Level 25"));
                add(Utils.tacc("&cStaff Only!"));
            }
        });
        sakura.setItemMeta(sakuraMeta);

        //This is where you decide what slot the item goes into
        gui.setItem(10, hillyWoods);
        gui.setItem(17, sakura);

        return gui;
    }

}
