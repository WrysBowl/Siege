package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.listeners.NPC.GamblingGames.TreasureHunter;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Herbert implements Listener {

    private final ItemStack skullHead = new ItemStack(Material.PLAYER_HEAD, 1, (byte) 3);
    private final ItemStack sellIcon = new ItemStack (Material.SUNFLOWER);
    private ChestGui menu = new ChestGui(5, "Herbert's Scrapper");
    private final OutlinePane background = new OutlinePane(0, 0, 3, 5, Pane.Priority.LOWEST);
    private final StaticPane playerPane = new StaticPane(3, 4, 6, 5, Pane.Priority.HIGHEST);
    private int sellAmount = 0;

    @EventHandler
    public void onRightClickOnEntity(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Herbert") && e.getRightClicked().getName().contains("6")) {
            getMenu().show(e.getPlayer());
        }
    }
    private ChestGui getMenu() {

        menu.setOnClose(this::guiClose);

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.displayName(Utils.lore(""));
        filler.setItemMeta(fillerMeta);
        background.addItem(new GuiItem(filler, event -> event.setCancelled(true)));
        background.setRepeat(true);

        menu.addPane(background);

        OutlinePane refreshIcon = new OutlinePane(1, 1, 1, 1);
        OutlinePane sellAllIcon = new OutlinePane(1, 3, 1, 1);

        //Creating Skull Icon
        SkullMeta meta = (SkullMeta) skullHead.getItemMeta();
        meta.setOwner("7bones");
        skullHead.setItemMeta(meta);

        ItemMeta skullHeadMeta = skullHead.getItemMeta();
        skullHeadMeta.displayName(Utils.lore("<gold>Herbert"));
        skullHeadMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<gray>CLICK TO REFRESH"));
                add(Utils.lore("<gray>I need to see how"));
                add(Utils.lore("<gray>much your stuff is"));
                add(Utils.lore("<gray>so, <bold>CLICK MY HEAD."));
                add(Utils.lore(""));
                add(Utils.lore("<yellow><bold>Look at the sunflower"));
                add(Utils.lore("<yellow><bold>after clicking me!"));
            }
        });
        this.skullHead.setItemMeta(skullHeadMeta);

        //Creating Sell Icon
        ItemMeta sellIconMeta = sellIcon.getItemMeta();
        sellIconMeta.displayName(Utils.lore("<yellow><bold>CASH IN"));
        sellIconMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<yellow>" + sellAmount + " <gray>Gold"));
                add(Utils.lore(""));
                add(Utils.lore("<gray><bold>CLICK TO SELL ALL"));
            }
        });
        this.sellIcon.setItemMeta(sellIconMeta);

        refreshIcon.addItem(new GuiItem(skullHead, event -> {
            event.setCancelled(true);
            calculateTotal(event);
        }));
        sellAllIcon.addItem(new GuiItem(sellIcon, event -> {
            event.setCancelled(true);
            sellAll(event);
        }));

        menu.addPane(playerPane);
        menu.addPane(refreshIcon);
        menu.addPane(sellAllIcon);
        return menu;
    }
    private void calculateTotal(InventoryClickEvent e) {
        Inventory inv = menu.getInventory();
        this.sellAmount = 0;
        this.playerPane.clear();
        for (int i=0; i<inv.getSize(); i++) {
            CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(inv.getItem(i));
            ItemStack rawItem = inv.getItem(i);
            if (rawItem == null) continue;
            if (item == null) continue;

            int gold = 0;

            if (item instanceof CustomMaterial) {
                break;
            } else {
                if (item.getLevelRequirement() == null) continue;
                int levelReq = item.getLevelRequirement();
                int quality = item.getQuality();
                gold = (int) ((levelReq * quality) / 5);
            }
            int y = (int) Math.floor(i/9.0);
            int x = i - (y*9);
            this.sellAmount += gold;
            this.playerPane.addItem(new GuiItem(rawItem), x, y);
        }
        if (this.sellAmount > 0) {
            this.menu = getMenu();
            this.menu.update();
        }
    }

    private void sellAll(InventoryClickEvent e) {
        calculateTotal(e);
        playerPane.clear();
        VaultHook.econ.depositPlayer((Player) e.getWhoClicked(), this.sellAmount);
        Scoreboard.updateScoreboard((Player) e.getWhoClicked());
        e.getWhoClicked().closeInventory();
    }

    private void guiClose(InventoryCloseEvent e) {
        Inventory inv = e.getInventory();
        final boolean fullInv = e.getPlayer().getInventory().firstEmpty() == -1;
        for (int i = 0; i<inv.getSize(); i++) {
            ItemStack item = inv.getItem(i);
            if (item == null) continue;
            if (i < 3) continue;
            if (i < 12 && i > 8) continue;
            if (i < 21 && i > 17) continue;
            if (i < 30 && i > 26) continue;
            if (i < 39 && i > 35) continue;
            if (!fullInv) {
                e.getPlayer().getInventory().addItem(item);
            } else {
                e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), item);
            }
        }
    }
}
