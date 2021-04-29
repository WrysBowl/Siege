package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class PortalEnterListener implements Listener {

    @EventHandler
    public void portalEnter(PlayerPortalEvent e) {
        World world = e.getPlayer().getWorld();
        World siegeHub = Core.plugin().getServer().getWorld("SiegeHub");
        Player player = e.getPlayer();

        if (world == siegeHub) {
            moveToward(player, siegeHub.getSpawnLocation(), 2.0);
            Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                player.openInventory(getGUIWorldTransit());
            }, 10); //Need to recheck to make sure regen time is properly made as a delay
        }
    }

    public void moveToward(Entity entity, Location to, double speed){
        Location loc = entity.getLocation();
        double x = loc.getX() - to.getX();
        double y = loc.getY() - to.getY();
        double z = loc.getZ() - to.getZ();
        Vector velocity = new Vector(x, y, z).normalize().multiply(-speed);
        entity.setVelocity(velocity);
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {return;}
        if (e.getView().getTitle().equals("World Transit")) {
            e.setCancelled(true);
            short level = Levels.getLevel((OfflinePlayer) e.getWhoClicked());
            Player player = (Player) e.getWhoClicked();
            World hillyWoods = Core.plugin().getServer().getWorld("Hilly_Woods");

            if (e.getSlot() == 10 && level >= 1) {
                player.closeInventory();
                player.sendTitle("Teleporting to", Utils.tacc("&2Hilly Woods"),10, 20, 10);
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                    if (hillyWoods != null) {
                        player.teleport(hillyWoods.getSpawnLocation());
                    }
                }, 20L);
            } else if (e.getSlot() == 17 && level >= 25) {
                player.sendMessage(Utils.tacc("&cThis isn't open to anyone yet!"));
            } else if (level == 0) { player.sendMessage(Utils.tacc("&cError loading your profile")); }
        }
    }

    private Inventory getGUIWorldTransit() {
        Inventory gui = Bukkit.createInventory(null, 27, "World Transit");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (Integer i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        //Creating Hilly Woods
        ItemStack hillyWoods = new ItemStack (Material.OAK_SAPLING);
        ItemMeta survivalMeta = hillyWoods.getItemMeta();
        survivalMeta.displayName(Utils.parse("<reset><dark_green>Hilly Woods<reset>"));
        survivalMeta.lore(new ArrayList<>(){
            {
                add(Utils.parse("<reset><gray>Click to travel<reset>"));
                add(Utils.parse("<reset><dark_purple>Level 1<reset>"));
            }
        });
        hillyWoods.setItemMeta(survivalMeta);

        //Creating Sakura
        ItemStack sakura = new ItemStack (Material.OAK_SAPLING);
        ItemMeta sakuraMeta = sakura.getItemMeta();
        sakuraMeta.displayName(Utils.parse("<reset><light_purple>Sakura<reset>"));
        sakuraMeta.lore(new ArrayList<>(){
            {
                add(Utils.parse("<reset><gray>Click to travel<reset>"));
                add(Utils.parse("<reset><dark_purple>Level 25<reset>"));
                add(Utils.parse("<reset><red>Staff Only!<reset>"));
            }
        });
        sakura.setItemMeta(sakuraMeta);

        //This is where you decide what slot the item goes into
        gui.setItem(10, hillyWoods);
        gui.setItem(16, sakura);

        return gui;
    }

}
