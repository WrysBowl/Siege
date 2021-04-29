package net.siegerpg.siege.core.listeners;

import kotlin.Suppress;
import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.CustomItemUtilsKt;
import net.siegerpg.siege.core.items.recipes.CustomRecipe;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class CustomCraftingEvents implements Listener {

    private Inventory inv;
    private List<ItemStack> craftingSlots = new ArrayList<>();
    private List<Integer> numCraftingSlots = new ArrayList<>();
    private boolean resultSlotSet = false;
    ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemStack air = new ItemStack(Material.AIR);

    private Inventory getCraftingGUI() {
        inv = Bukkit.createInventory(null, 45, "Crafting Table");
        for (int i=0; i<inv.getSize(); i++) { //Set all slots to filler variable
            inv.setItem(i, filler);
        }

        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                inv.setItem(y+x, air);
                craftingSlots.add(inv.getItem(y+x));
                numCraftingSlots.add(y+x);
            }
        }
        setResult(new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE));
        return inv;
    }

    public void setMatrix(List<CustomItem> matrix) {
        int i = 0;
        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                if (matrix.get(i) != null) {
                    inv.setItem(y + x, matrix.get(i).getItem());
                }
                i++;
            }
        }
    }

    public List<CustomItem> getMatrix() {
        List<CustomItem> matrix = new ArrayList<>();;
        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                ItemStack cell = inv.getItem(y+x);
                if (cell != null) {
                    CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(cell);
                    if (item != null) {
                        matrix.add(item);
                    } else { matrix.add(null); }
                } else { matrix.add(null); }
            }
        }
        return matrix;
    }

    public void clearMatrix() {
        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                inv.setItem(y+x, air);
            }
        }
    }

    public void setResult(ItemStack item) {
        inv.setItem(24, item);
    }

    public ItemStack getResult() {
        return inv.getItem(24);
    }

    @EventHandler
    public void onCraftingTableOpen(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType() == Material.CRAFTING_TABLE) {
                e.setCancelled(true);
                e.getPlayer().openInventory(getCraftingGUI());
            }
        }
    }


    @EventHandler
    public void onCraftingTableClose(InventoryCloseEvent e) {

    }

    /**
     * Step 1. Player puts in items into the crafting table
     * Step 2. System searches for a valid recipe
     * Step 3. If system finds valid recipe, result slot is set to display resulting fake item of the recipe
     * Step 4. If player clicks the resulting item, the system will remove the crafting ingredients from the crafting table
     * Step 5. The system will convert the clicked item to the actual resulting item
     */
    @EventHandler
    public void onCraftingTableClick(InventoryClickEvent e) {
        if (e.getInventory() != inv) return; //stops if inventory is not crafting table
        if (e.getRawSlot() > e.getInventory().getSize()-1) return; //if clicked slot is in the bottom inventory
        if (!numCraftingSlots.contains(e.getSlot())) { //stops if slot is not a crafting/result slot
            e.setCancelled(true);
            return;
        }
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            List<CustomItem> matrix = getMatrix();
            ItemStack result = new ItemStack(Material.AIR);
            Player player = (Player) e.getWhoClicked();
            //if (e.getCursor().getType().isAir()) {return;}

            /*
            for (CustomShapedRecipe recipe : Core.plugin().getShapedRecipes()) {
                if (recipe.doesFit(matrix)) {
                    result = recipe.getResult();
                }
            }
            for (CustomShapelessRecipe recipe : Core.plugin().getShapelessRecipes()) {
                if (recipe.doesFit(matrix)) {
                    result = recipe.getResult();
                }
            }
             */

            //Need further information on how to get the result of a recipe, and what getRecipe does
            if (CustomRecipe.Companion.getRecipe(matrix) != null) {
                result = CustomRecipe.Companion.getRecipe(matrix).getCreateItem().invoke(player, true).getItem();
            }

            if (e.getSlot()==24 && resultSlotSet) {
                clearMatrix();
                return;
            }

            //Known bug: Grabbing the result slot will not make the items in the crafting table go away
            //Possible solutions: Save a variable to the field to check if the result slot is a proper recipe result then clear the matrix
            if(result != null) {
                setMatrix(matrix);
                setResult(result);
                player.updateInventory();
                resultSlotSet = true;
            }
        }, 1);
    }
}