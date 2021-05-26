package net.siegerpg.siege.core.listeners.NPC.GamblingGames;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.informants.Scoreboard;
import net.siegerpg.siege.core.utils.Levels;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class TreasureHunter {
    /**
     * PSEUDOCODE
     *
     * First page: 5 rows
     * 20. START description Costs 500 gold, NO REFUNDS -> second page
     * 24. HELP description dig to your heart's content
     * and hope you don't dig up a hidden bomb.
     * If you close the gui, you keep all your rewards!
     *
     * Second page: 6 rows
     * Generate list of random values from 0 to 4
     * 0's are bombs
     * 1's are 100 coins
     * 2's are 100 exp
     * 3's are nothing
     * 4's are nothing
     *
     * Initialize goldReward and expReward var to store player rewards
     *
     * onGuiClick ->
     *
     *  if slot is a '0', then set all gui slots to
     *  red glass pane named "<bold>YOU LOST" after 2 seconds
     *  clear list
     *  close inventory
     *
     *  if slot is a '1', add 100 to the goldReward and
     *  set the slot to a gold coin named &e+100
     *  send entity_experience_orb sound
     *  if slot is a '2', add 100 to the expReward
     *  set the slot to an exp bottle named &d+100
     *  send block_stone_button_push sound
     *
     * onGuiClose ->
     *  check if list is empty -> return
     *  give player rewards from list
     *  make NPC send player message "&6Bart: &7Rematch?!"
     */
    public ArrayList<ItemStack> itemRewards = new ArrayList<>();
    public int goldRewards = 0;
    public int expRewards = 0;
    public ArrayList<Integer> dugValues = new ArrayList<>();

    private final ChestGui game = new ChestGui(6, "Bart's MineSweeper");
    private final HashMap<Integer, Integer> rewardTable = new HashMap<>();
    private final StaticPane background = new StaticPane(0, 0, 9, 6, Pane.Priority.LOWEST);
    private final ItemStack filler = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
    private final ItemStack bomb = new ItemStack(Material.TNT);
    private final ItemStack gold = new ItemStack(Material.SUNFLOWER);
    private final ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);

    public TreasureHunter(Player player) {
        this.game.setOnGlobalClick(event -> {
            event.setCancelled(true);
            uncoverSlot(event);
        });
        this.game.setOnClose(this::gameClose);

        ItemMeta fillerMeta = filler.getItemMeta();
        fillerMeta.displayName(Utils.lore("<yellow><bold>Click to Dig!"));
        filler.setItemMeta(fillerMeta);
        background.fillWith(filler);

        this.game.addPane(background);
        startGame();
        this.game.show(player);
    }
    private void startGame() {
        for(int i = 0; i<(game.getRows()*9)-1; i++) {
            this.rewardTable.put(i, (int) (Math.random() * 5));
        }

        ItemMeta bombMeta = this.bomb.getItemMeta();
        bombMeta.displayName(Utils.lore("<red><bold>BOOM"));
        bombMeta.lore(new ArrayList<>(){
            {
                add(Utils.lore("<gray>You lost everything"));
            }
        });
        this.bomb.setItemMeta(bombMeta);

        ItemMeta goldMeta = this.gold.getItemMeta();
        goldMeta.displayName(Utils.lore("<yellow>+100 Gold"));
        this.gold.setItemMeta(goldMeta);

        ItemMeta expMeta = this.exp.getItemMeta();
        expMeta.displayName(Utils.lore("<light_purple>+100 EXP"));
        this.exp.setItemMeta(expMeta);
    }
    private void uncoverSlot(InventoryClickEvent e) {
        int slot = e.getSlot();
        int getValue = rewardTable.get(slot);
        Player player = (Player) e.getWhoClicked();
        if (this.dugValues.contains(slot)) return;
        this.dugValues.add(slot);
        int y = (int) Math.floor(slot-1/9.0);
        int x = slot - (y*9);

        if (getValue == 0) {
            e.getInventory().setItem(slot, this.bomb);
            //this.background.addItem(new GuiItem(this.bomb), x, y);
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.closeInventory();
                }
            }.runTaskLater(Core.plugin(), 80);
        } else if (getValue == 1) {
            e.getInventory().setItem(slot, this.gold);
            //this.background.addItem(new GuiItem(this.gold), x, y);
            this.goldRewards += 100;
            this.game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + this.goldRewards + " Gold &d+" + this.expRewards + " EXP"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else if (getValue == 2) {
            e.getInventory().setItem(slot, this.exp);
            //this.background.addItem(new GuiItem(this.exp), x, y);
            this.expRewards += 100;
            this.game.setTitle(Utils.tacc("&a&lREWARDS&r &e+" + this.goldRewards + " Gold &d+" + this.expRewards + " EXP"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
        } else {
            e.getInventory().setItem(slot, new ItemStack(Material.AIR));
            //this.background.addItem(new GuiItem(new ItemStack(Material.AIR)), x, y);
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
        }
        //this.game.update();
        player.updateInventory();
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
