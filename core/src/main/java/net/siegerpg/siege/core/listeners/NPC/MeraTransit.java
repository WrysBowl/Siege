package net.siegerpg.siege.core.listeners.NPC;

import net.kyori.adventure.text.Component;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MeraTransit implements Listener {

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Mera") && e.getRightClicked().getName().contains("6")) {
            Inventory shop = getGUIWorldTransit(e.getPlayer());
            e.getPlayer().openInventory(shop);
        }
    }

    @EventHandler
    public void guiClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) {
            return;
        }
        if (e.getView().getTitle().equals("World Transit")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            World hillyWoods = Core.plugin().getServer().getWorld("Hilly_Woods");
            int slot = e.getSlot();
            int bal = (int) VaultHook.econ.getBalance(player);
            int farmCost = 200;
            int villageCost = 300;
            int caveCost = 200;
            if (player.hasPermission("siege.mera50")) {
                 farmCost *= 0.5;
                 villageCost *= 0.5;
                 caveCost *= 0.5;
            } else if (player.hasPermission("siege.mera75")) {
                farmCost *= 0.25;
                villageCost *= 0.25;
                caveCost *= 0.25;
            } else if (player.hasPermission("siege.mera100")) {
                farmCost = 0;
                villageCost = 0;
                caveCost = 0;
            }

            if (hillyWoods == null) return;
            if (slot == 10) {
                if (bal < farmCost) {
                    player.sendMessage(Utils.lore("<red>You are too poor to teleport here!"));
                    return;
                }
                VaultHook.econ.withdrawPlayer(player, farmCost);
                Scoreboard.updateScoreboard(player);
                player.closeInventory();
                player.sendTitle(Utils.tacc("&aTeleporting to"), Utils.tacc("&eThe Farm"), 10, 40, 10);
                player.getWorld().spawnParticle(
                        Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
                        player.getLocation(), 1);
                new Location(hillyWoods, 126, 58, -117).getWorld().spawnParticle(
                        Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
                        new Location(hillyWoods, 126, 58, -117), 1);
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                    player.teleport(new Location(hillyWoods, 126, 58, -117, -95, 0));
                }, 40L);
                return;
            }
            if (slot == 13) {
                if (bal < caveCost) {
                    player.sendMessage(Utils.lore("<red>You are too poor to teleport here!"));
                    return;
                }
                VaultHook.econ.withdrawPlayer(player, caveCost);
                Scoreboard.updateScoreboard(player);
                player.closeInventory();
                player.sendTitle(Utils.tacc("&aTeleporting to"), Utils.tacc("&7The Cave"), 10, 40, 10);
                player.getWorld().spawnParticle(
                        Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
                        player.getLocation(), 1);
                new Location(hillyWoods, -278, 80, 295).getWorld().spawnParticle(
                        Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
                        new Location(hillyWoods, -278, 80, 295), 1);
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                    player.teleport(new Location(hillyWoods, -278, 80, 295, -150, 0));
                }, 40L);
                return;
            }
            if (slot == 16) {
                if (bal < villageCost) {
                    player.sendMessage(Utils.lore("<red>You are too poor to teleport here!"));
                    return;
                }
                VaultHook.econ.withdrawPlayer(player, villageCost);
                Scoreboard.updateScoreboard(player);
                player.closeInventory();
                player.sendTitle(Utils.tacc("&aTeleporting to"), Utils.tacc("&aThe Village"), 10, 40, 10);
                player.getWorld().spawnParticle(
                        Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
                        player.getLocation(), 1);
                new Location(hillyWoods, 223, 92, 204).getWorld().spawnParticle(
                        Particle.DRAGON_BREATH.builder().count(50).offset(1, 1, 1).particle(),
                        new Location(hillyWoods, 223, 92, 204), 1);
                Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
                    player.teleport(new Location(hillyWoods, 223, 92, 204, 177, 0));
                }, 40L);
            }
        }
    }

    private Inventory getGUIWorldTransit(Player player) {
        Inventory gui = Bukkit.createInventory(null, 27, "World Transit");

        //Fill in the GUI
        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i = 0; i < gui.getSize(); i++) {
            gui.setItem(i, filler);
        }

        int farmCost = 200;
        int villageCost = 300;
        int caveCost = 200;
        if (player.hasPermission("siege.mera100")) {
            farmCost = 0;
            villageCost = 0;
            caveCost = 0;
        } else if (player.hasPermission("siege.mera75")) {
            farmCost *= 0.25;
            villageCost *= 0.25;
            caveCost *= 0.25;
        } else if (player.hasPermission("siege.mera50")) {
            farmCost *= 0.5;
            villageCost *= 0.5;
            caveCost *= 0.5;
        }

        //Creating Wheat Farm Icon
        ItemStack farm = new ItemStack(Material.WHEAT);
        ItemMeta farmMeta = farm.getItemMeta();
        farmMeta.displayName(Utils.lore("<yellow><bold>Farm"));
        final int finalFarmCost = farmCost;
        List<Component> farmLore = new ArrayList<>() {
            {
                add(Utils.lore("<green>Click to travel"));
                add(Utils.lore("<yellow>Cost " + finalFarmCost));
            }
        };
        farmMeta.lore(farmLore);
        farm.setItemMeta(farmMeta);

        //Creating Forest Cave
        ItemStack cave = new ItemStack(Material.COAL_ORE);
        ItemMeta caveMeta = cave.getItemMeta();
        caveMeta.displayName(Utils.lore("<gray><bold>Cave"));
        final int finalCaveCost = caveCost;
        List<Component> caveLore = new ArrayList<>() {
            {
                add(Utils.lore("<green>Click to travel"));
                add(Utils.lore("<yellow>Cost " + finalCaveCost));
            }
        };
        caveMeta.lore(caveLore);
        cave.setItemMeta(caveMeta);

        //Creating Forest Cave
        ItemStack village = new ItemStack(Material.EMERALD);
        ItemMeta villageMeta = village.getItemMeta();
        villageMeta.displayName(Utils.lore("<green><bold>Village"));
        final int finalVillageCost = villageCost;
        List<Component> villageLore = new ArrayList<>() {
            {
                add(Utils.lore("<green>Click to travel"));
                add(Utils.lore("<yellow>Cost " + finalVillageCost));
            }
        };
        villageMeta.lore(villageLore);
        village.setItemMeta(villageMeta);

        //This is where you decide what slot the item goes into
        gui.setItem(10, farm);
        gui.setItem(13, cave);
        gui.setItem(16, village);

        return gui;
    }

}
