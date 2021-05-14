package net.siegerpg.siege.core.listeners;

import net.siegerpg.siege.core.Core;
import net.siegerpg.siege.core.items.CustomItem;
import net.siegerpg.siege.core.items.CustomItemUtils;
import net.siegerpg.siege.core.items.implemented.weapons.melee.TestSword;
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shank;
import net.siegerpg.siege.core.items.recipes.CustomRecipe;
import net.siegerpg.siege.core.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CustomCraftingEvents implements Listener {

    private Inventory inv;
    private List<ItemStack> craftingSlots = new ArrayList<>();
    private List<Integer> numCraftingSlots = new ArrayList<>();
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
        List<CustomItem> matrix = new ArrayList<>();
        for (int y=10; y<29; y+=9) { //Sets crafting grid slots
            for (int x=0; x<3; x++) {
                ItemStack cell = inv.getItem(y+x);
                if (cell != null) {
                    CustomItem item = CustomItemUtils.INSTANCE.getCustomItem(cell);
                    matrix.add(item);
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
                e.getPlayer().sendMessage(Utils.parse("<red>The crafting system has been disabled for now."));
                e.getPlayer().sendMessage(Utils.parse("<red>Please click on Symone to craft your items!"));
                //e.getPlayer().openInventory(getCraftingGUI());
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
            if (e.getSlot() != 24) {
                return;
            }
        }
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            //if (e.getCursor().getType().isAir()) { return; }

            List<CustomItem> matrix = getMatrix();
            ItemStack result = new ItemStack(Material.AIR);
            Player player = (Player) e.getWhoClicked();

            CustomRecipe matchedRecipe = CustomRecipe.Companion.getRecipe(matrix);

            if (matchedRecipe != null) {
                Bukkit.getLogger().info("Not null");
                CustomItem item = matchedRecipe.getCreateItem().invoke(player, true);
                result = item.getUpdatedItem(true);
            }


            if (e.getSlot()==24) { //if player clicks on the result slot
                if (!Objects.requireNonNull(e.getCurrentItem()).getType().equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE)) {
                    //Loop through the matrix and subtract the recipe matrix of the same index from the iteration
                    List<CustomItem> recipe = CustomRecipe.Companion.getRecipe(matrix).getItems();
                    for (int i = 0; i < matrix.size()-1; i++) {
                        if (matrix.get(i) != null) { // if cell is not air
                            Integer amtRecipeIndex = recipe.get(i).getItem().getAmount();
                            Integer amtMatrixIndex = matrix.get(i).getItem().getAmount();
                            int diff = amtMatrixIndex-amtRecipeIndex;
                            if (diff > 0) {
                                ItemStack itemIndex = matrix.get(i).getUpdatedItem(false);
                                itemIndex.setAmount(diff);
                                matrix.set(i, CustomItemUtils.INSTANCE.getCustomItem(itemIndex));
                            }
                            matrix.set(i, recipe.get(i));
                        }

                    }
                    setMatrix(matrix);
                }
                return;
            }

            if(!result.getType().equals(Material.AIR)) {
                setMatrix(matrix);
                setResult(result);
                player.updateInventory();
            }
        }, 1);
    }
    @EventHandler
    public void onDragClick(InventoryDragEvent e) {
        if (e.getInventory() != inv) return; //stops if inventory is not crafting table
        List<Integer> slots = new ArrayList<>(e.getRawSlots());
        if (!numCraftingSlots.containsAll(slots)) return; //if all integers in slots are not contained in numcraftingslots
        Bukkit.getServer().getScheduler().runTaskLater(Core.plugin(), () -> {
            //if (e.getCursor().getType().isAir()) { return; }

            List<CustomItem> matrix = getMatrix();
            ItemStack result = new ItemStack(Material.AIR);
            Player player = (Player) e.getWhoClicked();

            //Need further information on how to get the result of a recipe, and what getRecipe does
            if (CustomRecipe.Companion.getRecipe(matrix) != null) { //TEMP FIX (SEE DEV CHAT)
                result = CustomRecipe.Companion.getRecipe(matrix).getCreateItem().invoke(player, true).getUpdatedItem(false);
            }


            if(!result.getType().equals(Material.AIR)) {
                setMatrix(matrix);
                setResult(result);
                player.updateInventory();
            }
        }, 1);
    }
}