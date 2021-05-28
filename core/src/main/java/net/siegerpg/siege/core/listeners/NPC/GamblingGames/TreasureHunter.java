package net.siegerpg.siege.core.listeners.NPC.GamblingGames;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
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
    public int goldRewards = 0;
    public int expRewards = 0;
    public ArrayList<Integer> dugValues = new ArrayList<>();

    private final ChestGui game = new ChestGui(6, "Bart's MineSweeper");
    private final HashMap<Integer, Integer> rewardTable = new HashMap<>();
    private final StaticPane background = new StaticPane(0, 0, 9, 6, Pane.Priority.LOWEST);
    private final ItemStack filler = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
    private final ItemStack bomb = new ItemStack(Material.TNT);
    private final ItemStack gold1000 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold500 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold100 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold75 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack gold50 = new ItemStack(Material.SUNFLOWER);
    private final ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);

    public TreasureHunter(Player player) {
        this.game.setOnGlobalClick(event -> {
            event.setCancelled(true);
            uncoverSlot(event);
        });
        this.game.setOnClose(this::gameClose);

        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.displayName(Utils.lore("<yellow><bold>Click to Dig!"));
        fillerMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<gray>You can leave the"));
                add(Utils.lore("<gray>game to collect all"));
                add(Utils.lore("<gray>of your rewards!"));
            }
        });
        filler.setItemMeta(fillerMeta);
        background.fillWith(filler);

        this.game.addPane(background);
        startGame();
        this.game.show(player);
    }
    private void startGame() {

        ItemMeta bombMeta = this.bomb.getItemMeta();
        bombMeta.displayName(Utils.lore("<red><bold>BOOM"));
        bombMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<gray>You lost everything"));
            }
        });
        this.bomb.setItemMeta(bombMeta);

        ItemMeta gold1000Meta = this.gold1000.getItemMeta();
        gold1000Meta.displayName(Utils.lore("<yellow>+1000 Gold"));
        this.gold1000.setItemMeta(gold1000Meta);

        ItemMeta gold500Meta = this.gold500.getItemMeta();
        gold500Meta.displayName(Utils.lore("<yellow>+500 Gold"));
        this.gold500.setItemMeta(gold500Meta);

        ItemMeta gold100Meta = this.gold100.getItemMeta();
        gold100Meta.displayName(Utils.lore("<yellow>+100 Gold"));
        this.gold100.setItemMeta(gold100Meta);

        ItemMeta gold75Meta = this.gold75.getItemMeta();
        gold75Meta.displayName(Utils.lore("<yellow>+75 Gold"));
        this.gold75.setItemMeta(gold75Meta);

        ItemMeta gold50Meta = this.gold50.getItemMeta();
        gold50Meta.displayName(Utils.lore("<yellow>+50 Gold"));
        this.gold50.setItemMeta(gold50Meta);

        ItemMeta expMeta = this.exp.getItemMeta();
        expMeta.displayName(Utils.lore("<light_purple>+100 EXP"));
        this.exp.setItemMeta(expMeta);

        for(int i = 0; i<(game.getRows()*9); i++) {
            this.rewardTable.put(i, (int) (Math.random() * 7));
        }
        this.rewardTable.replace((int) (Math.random() * 54), 7);
        this.rewardTable.replace((int) (Math.random() * 54), 7);
        this.rewardTable.replace((int) (Math.random() * 54), 8);
    }
    private void uncoverSlot(InventoryClickEvent e) {
        int slot = e.getSlot();
        int getValue = rewardTable.get(slot);
        Player player = (Player) e.getWhoClicked();
        if (this.dugValues.contains(slot)) return;
        this.dugValues.add(slot);
        int y = (int) Math.floor(slot/9.0);
        int x = slot - (y*9);

        if (getValue == 0) {
            this.background.addItem(new GuiItem(this.bomb), x, y);
            this.game.setTitle(Utils.tacc("&c&lEXPLODED"));
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.closeInventory();
                }
            }.runTaskLater(Core.plugin(), 60);
        } else if (getValue == 1) {
            this.background.addItem(new GuiItem(this.gold100), x, y);
            this.goldRewards += 100;
            this.game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + this.goldRewards + " Gold &d+"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 2) {
            this.background.addItem(new GuiItem(this.gold75), x, y);
            this.goldRewards += 75;
            this.game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + this.goldRewards + " Gold &d+"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 3) {
            this.background.addItem(new GuiItem(this.gold50), x, y);
            this.goldRewards += 50;
            this.game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + this.goldRewards + " Gold &d+"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 7) {
            this.background.addItem(new GuiItem(this.gold500), x, y);
            this.goldRewards += 500;
            this.game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + this.goldRewards + " Gold &d+"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 8) {
            this.background.addItem(new GuiItem(this.gold1000), x, y);
            this.goldRewards += 1000;
            this.game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + this.goldRewards + " Gold &d+"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else {
            this.background.addItem(new GuiItem(new ItemStack(Material.AIR)), x, y);
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
        }
        this.game.addPane(this.background);
        this.game.update();
    }
    private void gameClose(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        for (int slot : this.dugValues) {
            if (rewardTable.get(slot) == 0) {
                player.sendTitle(Utils.tacc("&c&lYOU LOST"), "", 10, 80, 10);
                player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, (float) 0.5, (float) 0.8);
                return;
            }
        }
        if (this.goldRewards > 0) {
            VaultHook.econ.depositPlayer(player, this.goldRewards);
        }
        if (this.expRewards > 0) {
            Levels.INSTANCE.addExp(player, this.expRewards);
        }
        if (this.itemRewards.size() > 0) {
            final boolean fullInv = e.getPlayer().getInventory().firstEmpty() == -1;
            for (ItemStack reward : this.itemRewards) {
                if (!fullInv) {
                    e.getPlayer().getInventory().addItem(reward);
                } else {
                    player.getWorld().dropItemNaturally(player.getLocation(), reward);
                }
            }
        }
        player.sendTitle(Utils.tacc("&a&lYOU WIN"), Utils.tacc("&e+" + this.goldRewards + " Gold     &d+" + this.expRewards + " EXP"), 10, 80, 10);
        Scoreboard.updateScoreboard(player);
    }
}
