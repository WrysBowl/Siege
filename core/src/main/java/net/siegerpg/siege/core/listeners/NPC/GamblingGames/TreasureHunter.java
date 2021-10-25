package net.siegerpg.siege.core.listeners.NPC.GamblingGames;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class TreasureHunter {

    public ArrayList<ItemStack> itemRewards = new ArrayList<>();
    public int goldRewards;
    public int expRewards;
    public ArrayList<Integer> dugValues = new ArrayList<>();

    private final ChestGui game = new ChestGui(6, "Bart's Sandbox");
    private final HashMap<Integer, Integer> rewardTable = new HashMap<>();
    private final StaticPane background = new StaticPane(0, 0, 9, 6, Pane.Priority.LOWEST);
    private final ItemStack filler = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
    private final ItemStack bomb = new ItemStack(Material.TNT);
    private final ItemStack gold2000 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold1000 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold500 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold100 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold75 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold50 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);

    public TreasureHunter(final Player player) {
        game.setOnGlobalClick(event -> {
            event.setCancelled(true);
            this.uncoverSlot(event);
        });
        game.setOnClose(this::gameClose);

        final ItemMeta fillerMeta = this.filler.getItemMeta();
        fillerMeta.displayName(Utils.lore("<yellow><bold>Click to Dig!"));
        fillerMeta.lore(new ArrayList<>(){
            {
                this.add(Utils.lore("<gray>You can leave the"));
                this.add(Utils.lore("<gray>game to collect all"));
                this.add(Utils.lore("<gray>of your rewards!"));
            }
        });
        this.filler.setItemMeta(fillerMeta);
        this.background.fillWith(this.filler);

        game.addPane(this.background);
        this.startGame();
        game.show(player);
    }
    private void startGame() {

        final ItemMeta bombMeta = bomb.getItemMeta();
        bombMeta.displayName(Utils.lore("<red><bold>BOOM"));
        bombMeta.lore(new ArrayList<>(){
            {
                this.add(Utils.lore("<gray>You lost everything"));
            }
        });
        bomb.setItemMeta(bombMeta);

        final ItemMeta gold2000Meta = gold2000.getItemMeta();
        gold2000Meta.displayName(Utils.lore("<yellow>+2,000 Gold"));
        gold2000.setItemMeta(gold2000Meta);

        final ItemMeta gold1000Meta = gold1000.getItemMeta();
        gold1000Meta.displayName(Utils.lore("<yellow>+1,000 Gold"));
        gold1000.setItemMeta(gold1000Meta);

        final ItemMeta gold500Meta = gold500.getItemMeta();
        gold500Meta.displayName(Utils.lore("<yellow>+500 Gold"));
        gold500.setItemMeta(gold500Meta);

        final ItemMeta gold100Meta = gold100.getItemMeta();
        gold100Meta.displayName(Utils.lore("<yellow>+100 Gold"));
        gold100.setItemMeta(gold100Meta);

        final ItemMeta gold75Meta = gold75.getItemMeta();
        gold75Meta.displayName(Utils.lore("<yellow>+75 Gold"));
        gold75.setItemMeta(gold75Meta);

        final ItemMeta gold50Meta = gold50.getItemMeta();
        gold50Meta.displayName(Utils.lore("<yellow>+50 Gold"));
        gold50.setItemMeta(gold50Meta);

        final ItemMeta expMeta = exp.getItemMeta();
        expMeta.displayName(Utils.lore("<light_purple>+100 EXP"));
        exp.setItemMeta(expMeta);

        for(int i = 0; i<(this.game.getRows()*9); i++) {
            rewardTable.put(i, (int) (Math.random() * 7));
        }
        rewardTable.replace((int) (Math.random() * 54), 7);
        rewardTable.replace((int) (Math.random() * 54), 7);
        rewardTable.replace((int) (Math.random() * 54), 7);
        rewardTable.replace((int) (Math.random() * 54), 8);
        rewardTable.replace((int) (Math.random() * 54), 8);
        rewardTable.replace((int) (Math.random() * 54), 9);
    }
    private void uncoverSlot(final InventoryClickEvent e) {
        final int slot = e.getSlot();
        final int getValue = this.rewardTable.get(slot);
        final Player player = (Player) e.getWhoClicked();
        if (dugValues.contains(slot)) return;
        dugValues.add(slot);
        final int y = (int) Math.floor(slot/9.0);
        final int x = slot - (y*9);

        if (getValue == 0) {
            background.addItem(new GuiItem(bomb), x, y);
            game.setTitle(Utils.tacc("&c&lEXPLODED"));
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.closeInventory();
                }
            }.runTaskLater(Core.plugin(), 20);
        } else if (getValue == 1) {
            background.addItem(new GuiItem(gold100), x, y);
            goldRewards += 100;
            game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + goldRewards + " Gold"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 2) {
            background.addItem(new GuiItem(gold75), x, y);
            goldRewards += 75;
            game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + goldRewards + " Gold"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 3) {
            background.addItem(new GuiItem(gold50), x, y);
            goldRewards += 50;
            game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + goldRewards + " Gold"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 7) {
            background.addItem(new GuiItem(gold500), x, y);
            goldRewards += 500;
            game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + goldRewards + " Gold"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 8) {
            background.addItem(new GuiItem(gold1000), x, y);
            goldRewards += 1000;
            game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + goldRewards + " Gold"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 9) {
            background.addItem(new GuiItem(gold2000), x, y);
            goldRewards += 2000;
            game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + goldRewards + " Gold"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else {
            background.addItem(new GuiItem(new ItemStack(Material.AIR)), x, y);
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
        }
        game.addPane(background);
        game.update();
    }
    private void gameClose(final InventoryCloseEvent e) {
        final Player player = (Player) e.getPlayer();
        for (final int slot : dugValues) {
            if (this.rewardTable.get(slot) == 0) {
                player.sendTitle(Utils.tacc("&c&lYOU LOST"), "", 10, 80, 10);
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, (float) 0.5, (float) 0.8);
                return;
            }
        }
        if (goldRewards > 0) {
            VaultHook.econ.depositPlayer(player, goldRewards);
        }
        if (expRewards > 0) {
            Levels.INSTANCE.addExpShared(player, expRewards);
        }
        if (itemRewards.size() > 0) {
            boolean fullInv = e.getPlayer().getInventory().firstEmpty() == -1;
            for (final ItemStack reward : itemRewards) {
                if (!fullInv) {
                    e.getPlayer().getInventory().addItem(reward);
                } else {
                    player.getWorld().dropItemNaturally(player.getLocation(), reward);
                }
            }
        }
        player.sendTitle(Utils.tacc("&a&lYOU WIN"), Utils.tacc("&e+" + goldRewards + " Gold"), 10, 80, 10);
        Scoreboard.updateScoreboard(player);
    }
}
