package net.siegerpg.siege.core.listeners.NPC;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

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
            short level = Levels.INSTANCE.getExpLevel(player).getFirst();
            World hillyWoods = Core.plugin().getServer().getWorld("Hilly_Woods");
            int slot = e.getSlot();
            int bal = (int) VaultHook.econ.getBalance(player);
            int farmCost = 200;
            int villageCost = 300;
            int caveCost = 200;
            if (player.hasPermission("siegecore.merafree")) {
                 farmCost /= 2;
                 villageCost /= 2;
                 caveCost /= 2;
            }

            if (hillyWoods == null) return;
            if (level < 5) {
                player.sendMessage(Utils.lore("<red>You are not experienced enough to use fast travel!"));
                return;
            }
            if (slot == 10) {
                if (bal < farmCost) {
                    player.sendMessage(Utils.lore("<red>You are too poor to teleport here!"));
                    return;
                }
                VaultHook.econ.withdrawPlayer(player, farmCost);
                Scoreboard.updateScoreboard(player);
                player.closeInventory();
                player.sendTitle(Utils.tacc("&aTeleporting to"), Utils.tacc("&eThe Farm"), 10, 40, 10);
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
        if (player.hasPermission("siegecore.merafree")) {
            farmCost /= 2;
            villageCost /= 2;
            caveCost /= 2;
        }

        //Creating Wheat Farm Icon
        ItemStack farm = new ItemStack(Material.WHEAT);
        ItemMeta farmMeta = farm.getItemMeta();
        farmMeta.displayName(Utils.lore("<yellow>Farm"));
        int finalFarmCost = farmCost;
        farmMeta.lore(new ArrayList<>() {
            {
                add(Utils.lore("<gray>Click to travel"));
                add(Utils.lore("<yellow>Cost " + finalFarmCost));
                add(Utils.lore("<dark_purple>Level 5"));
            }
        });
        farm.setItemMeta(farmMeta);

        //Creating Forest Cave
        ItemStack cave = new ItemStack(Material.COAL_ORE);
        ItemMeta caveMeta = cave.getItemMeta();
        caveMeta.displayName(Utils.lore("<gray>Cave"));
        int finalCaveCost = caveCost;
        caveMeta.lore(new ArrayList<>() {
            {
                add(Utils.lore("<gray>Click to travel"));
                add(Utils.lore("<yellow>Cost " + finalCaveCost));
                add(Utils.lore("<dark_purple>Level 5"));
            }
        });
        cave.setItemMeta(caveMeta);

        //Creating Forest Cave
        ItemStack village = new ItemStack(Material.EMERALD);
        ItemMeta villageMeta = village.getItemMeta();
        villageMeta.displayName(Utils.lore("<green>Village"));
        int finalVillageCost = villageCost;
        villageMeta.lore(new ArrayList<>() {
            {
                add(Utils.lore("<gray>Click to travel"));
                add(Utils.lore("<yellow>Cost " + finalVillageCost));
                add(Utils.lore("<dark_purple>Level 5"));
            }
        });
        village.setItemMeta(villageMeta);

        //This is where you decide what slot the item goes into
        gui.setItem(10, farm);
        gui.setItem(13, cave);
        gui.setItem(16, village);

        return gui;
    }

}
