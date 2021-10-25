package net.siegerpg.siege.core.listeners.NPC;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.*;
import com.github.stefvanschie.inventoryframework.pane.*;
import net.siegerpg.siege.core.items.statgems.StatGem;
import net.siegerpg.siege.core.items.types.misc.CustomKey;
import net.siegerpg.siege.core.items.types.misc.StatGemType;
import net.siegerpg.siege.core.utils.Scoreboard;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.types.misc.CustomMaterial;
import net.siegerpg.siege.core.utils.Utils;
import net.siegerpg.siege.core.utils.VaultHook;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Herbert implements Listener {

    private Player person; // Interacting player
    private ChestGui menu;
    private int total; // Total scrap cash
    boolean inUse; // One player at a time
    static boolean passed; // Avoid double msg????
    private final ItemStack cashInSymbol = new ItemStack(Material.SUNFLOWER);
    private final ItemMeta cashMeta = this.cashInSymbol.getItemMeta();
    private final ItemStack scanSymbol = new ItemStack(Material.ARROW);
    private final ItemMeta scanMeta = this.scanSymbol.getItemMeta();
    private final OutlinePane infoPane = new OutlinePane(1, 1, 1, 2);

    @EventHandler
    public void onRightClickEntity(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getName().contains("Herbert") && e.getRightClicked().getName().contains("6")) {
            if (Herbert.passed) {
                if (!this.inUse) {
                    this.inUse = true;
                    this.person = e.getPlayer();
                    this.menu = this.initMenu();
                    this.menu.show(this.person);
                    return;
                } else {
                    e.getPlayer().sendMessage(Utils.tacc("Herbert is currently in use!"));
                }
                Herbert.passed = false;
            }
            else {
                Herbert.passed = true;
            }

        }
    }

    @EventHandler
    public void onLeave(final PlayerQuitEvent e) {
        final Player player = e.getPlayer();
        if (player.equals(this.person)) {
            final ArrayList<ItemStack> Items = new ArrayList<ItemStack>(this.pullItems());
            for (final ItemStack item : Items) {
                if (this.person.getInventory().firstEmpty() == -1) {
                    this.person.getWorld().dropItemNaturally(this.person.getLocation(), item);
                }
                else {
                    this.person.getInventory().addItem(item);
                }
            }
            this.clearItems();
            this.refresh();
            this.inUse = false;
        }
    }

    // Initialize menu
    private ChestGui initMenu() {
        final ChestGui menu = new ChestGui(5, "Scrapper");

        menu.setOnClose(this::onInvClose);

        final ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

        // Setup background pane
        final OutlinePane background = new OutlinePane(0, 0, 3, 5, Pane.Priority.LOWEST);
        background.addItem(new GuiItem(filler, event -> event.setCancelled(true)));
        background.setRepeat(true);
        menu.addPane(background);

        // Setup cash in sunflower
        this.cashMeta.displayName(Utils.lore("<gold><bold>CASH IN"));
        this.cashMeta.lore(new ArrayList<>() {
            {
                this.add(Utils.lore("<gray>Total: <gold>0"));
                this.add(Utils.lore("<red><bold>THIS ACTION CANNOT BE UNDONE!"));
                this.add(Utils.lore("<gray>Click \"Calculate\" to update total!"));
            }
        });
        this.cashInSymbol.setItemMeta(this.cashMeta);

        // Setup scan arrow
        this.scanMeta.displayName(Utils.lore("<green>Calculate"));
        this.scanMeta.lore(new ArrayList<>() {
            {
                this.add(Utils.lore("<grey>Compute your gains!"));
            }
        });
        this.scanSymbol.setItemMeta(this.scanMeta);
        this.infoPane.addItem(new GuiItem(this.scanSymbol, this::scanner));
        this.infoPane.addItem(new GuiItem(this.cashInSymbol, this::clickCash));
        menu.addPane(this.infoPane);

        return menu;
    }

    // Cash in all items in the scrapper
    private void clickCash(final InventoryClickEvent e) {
        this.scanner(e); // Update values
        this.clearItems(); // Trash items
        this.refresh(); // Update Gui
        VaultHook.econ.depositPlayer(this.person, this.total); // Award gold
        Scoreboard.updateScoreboard(this.person); // Update scoreboard
        this.scanner(e); // Scan again to display zero gold
    }



    // Calculate item values in the scrapper
    private void scanner(final InventoryClickEvent e) {
        final ArrayList<ItemStack> scraps = new ArrayList<ItemStack>(this.pullItems()); // Get scrapper items
        this.total = 0;
        int quality = 0;
        int levelReq = 0;
        int quantity = 1;
        CustomItem cItem;
        for (final ItemStack scrap : scraps) {
            cItem = CustomItemUtils.INSTANCE.getCustomItem(scrap);

            // Award value to qualifying items
            if (cItem != null) {
                quantity = cItem.getItem().getAmount();
                if (cItem instanceof CustomMaterial) {
                    quality = ((CustomMaterial)(cItem)).getTier();
                    this.total += quantity * Math.pow(3, quality-1);
                } else if (cItem instanceof StatGemType) {
                    if (cItem.getLevelRequirement() == null) {
                        this.total += 1;
                        continue;
                    }
                    levelReq = cItem.getLevelRequirement();
                    this.total += quantity*35*levelReq;
                } else if (cItem instanceof CustomKey) {
                    if (cItem.getLevelRequirement() == null) {
                        this.total += 1;
                        continue;
                    }
                    levelReq = cItem.getLevelRequirement();
                    this.total += quantity* 100 * levelReq;
                } else {
                    quality = cItem.getQuality();
                    if (cItem.getLevelRequirement() == null) {
                        this.total += 1;
                        continue;
                    }
                    levelReq = cItem.getLevelRequirement();
                    this.total += quantity * ((levelReq * quality) / 5);
                }
            }
        }

        // Refresh cash in sunflower
        this.infoPane.clear();
        int cash = this.total;
        this.cashMeta.displayName(Utils.lore("<gold><bold>CASH IN"));
        this.cashMeta.lore(new ArrayList<>() {
            {
                this.add(Utils.lore("<gray>Total: <gold>" + cash));
                this.add(Utils.lore("<red><bold>THIS ACTION CANNOT BE UNDONE!"));
                this.add(Utils.lore("<gray>Click \"Calculate\" to update total!"));
            }
        });
        this.cashInSymbol.setItemMeta(this.cashMeta);

        this.infoPane.addItem(new GuiItem(this.scanSymbol, this::scanner));
        this.infoPane.addItem(new GuiItem(this.cashInSymbol, this::clickCash));
        this.refresh(); // Update Gui
    }

    // Return player items still in the scrapper on close
    public void onInvClose(final InventoryCloseEvent e) {
        final ArrayList<ItemStack> Items = new ArrayList<ItemStack>(this.pullItems());
        for (final ItemStack item : Items) {
            if (this.person.getInventory().firstEmpty() == -1) {
                this.person.getWorld().dropItemNaturally(this.person.getLocation(), item);
            }
            else {
                this.person.getInventory().addItem(item);
            }
        }
        this.clearItems();
        this.refresh();
        this.inUse = false;
    }

    // Get the coordinates of all items in the scrapper from top left to bottom right
    private ArrayList<Integer> pullItemCoords() {
        final Inventory inv = this.menu.getInventory();
        final ArrayList<Integer> scraps = new ArrayList<Integer>();
        int y = 0;
        while (y < 5) {
            int x = 3;
            while (x < 9) {
                if (inv.getItem(x + (y * 9)) != null) {
                    scraps.add(x + (y * 9));
                }
                x++;
            }
            y++;
        }
        return scraps;
    }

    // Get an ArrayList of all ItemStacks in the scrapper from top left to bottom right
    private ArrayList<ItemStack> pullItems() {
        final Inventory inv = this.menu.getInventory();
        final ArrayList<ItemStack> scraps = new ArrayList<ItemStack>();
        int y = 0;
        while (y < 5) {
            int x = 3;
            while (x < 9) {
                if (inv.getItem(x + (y * 9)) != null) {
                    scraps.add(inv.getItem(x + (y * 9)));
                }
                x++;
            }
            y++;
        }
        return scraps;
    }

    // Clear items in the scrapper
    private void clearItems() {
        final Inventory inv = this.menu.getInventory();
        final ArrayList<Integer> coords = new ArrayList<Integer>(this.pullItemCoords());
        for (final Integer coord : coords) {
            inv.setItem(coord, null);
        }
    }

    // Updates the gui and reseats items
    private void refresh() {
        final ArrayList<ItemStack> raws =  new ArrayList<ItemStack>(this.pullItems());
        final ArrayList<Integer> coords = new ArrayList<Integer>(this.pullItemCoords());

        this.menu.update();

        final Inventory inv = this.menu.getInventory();
        for (int i = 0; i < coords.size(); i++) {
            inv.setItem(coords.get(i), raws.get(i));
        }
    }

    // Function for testing sends msgs to the interacting player
    private void log(final String phrase) {
        this.person.sendMessage(Utils.tacc(phrase));
    }
}
