package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegemc.core.olditems.recipes.CustomShapedRecipe;
import net.siegemc.core.olditems.recipes.CustomShapelessRecipe;
import net.siegerpg.siege.core.utils.*;
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
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;
import java.util.List;

public class CustomCraftingEvents implements Listener {

    private Inventory inv;
    private List<ItemStack> craftingSlots = new ArrayList<>();
    private List<Integer> numCraftingSlots = new ArrayList<>();
    private boolean resultSlotSet = false;
    ItemStack filler = Utils.createItem(Material.GRAY_STAINED_GLASS_PANE, ChatColor.GREEN + "", false, 1);
    ItemStack craftingSlot = new ItemStack(Material.AIR);

    public void createNewGUI() {
        inv = Bukkit.createInventory(null, 45, "Crafting Table");
        for (int i=0; i<inv.getSize(); i++) { //Set all slots to filler variable
            inv.setItem(i, filler);
        }

        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                inv.setItem(y+x, craftingSlot);
                craftingSlots.add(inv.getItem(y+x));
                numCraftingSlots.add(y+x);
            }
        }
        numCraftingSlots.add(24);
        setResult(new ItemStack(Material.AIR));
    }

    public void setMatrix(List<ItemStack> matrix) {
        int i = 0;
        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                inv.setItem(y+x, matrix.get(i++));
            }
        }
    }

    public List<ItemStack> getMatrix() {
        List<ItemStack> matrix = new ArrayList<>();;
        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                matrix.add(inv.getItem(y+x));
            }
        }
        return matrix;
    }

    public void clearMatrix() {
        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                inv.setItem(y+x, craftingSlot);
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
    public void onCraftingTableClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getType() == Material.CRAFTING_TABLE) {
                e.setCancelled(true);
                createNewGUI();
                e.getPlayer().openInventory(craftingGrid(e.getPlayer()));
            }
        }
    }

    @EventHandler
    public void onCraftingInventoryClick(InventoryClickEvent e) {
        if (e.getInventory() != inv) return; //stops if inventory is not crafting table
        if (e.getClickedInventory() instanceof PlayerInventory) return;
        else if (!numCraftingSlots.contains(e.getSlot())) { //stops if slot is not a crafting/result slot
            e.setCancelled(true);
            return;
        }
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            List<ItemStack> matrix = new ArrayList();
            ItemStack result = new ItemStack(Material.AIR);
            Player player = (Player) e.getWhoClicked();

            //if (e.getCursor().getType().isAir()) {return;}

            for (ItemStack i : getMatrix()) {
                matrix.add(i);
            }
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

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getInventory() != inv) return;

    }

    public Inventory craftingGrid(Player player) {
        player.setMetadata("invOpened", new FixedMetadataValue(Core.plugin(), true));
        return inv;
    }

}
