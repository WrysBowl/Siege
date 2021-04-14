package net.siegerpg.siege.core.recipes;

import net.siegerpg.siege.core.items.implemented.*;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Recipes {

    public List<CustomShapelessRecipe> shapelessRecipes = new ArrayList();
    public List<CustomShapedRecipe> shapedRecipes = new ArrayList();

    public List<CustomShapelessRecipe> getShapelessRecipes() {
        return shapelessRecipes;
    }
    public List<CustomShapedRecipe> getShapedRecipes() {
        return shapedRecipes;
    }

    public Recipes() {
        // Load all Reagent Recipes
        for (String str : Items.ReagentsToMaterials.keySet()) {
            loadMaterialRecipes(str);
        }
        //new Swords();


    }

    // Automate both Upgrade and Dismantle loading for Reagents
    public void loadMaterialRecipes(String reagent) {
        List<ItemStack> craftingGrid = new ArrayList();
        ItemStack result = null;

        // Load all upgrade recipes for the reagent
        // i in addition to being used as the loop iterator is also used as the tier
        for (Integer i = 1; i < 5; i++) {
            craftingGrid.add(Items.searchMaterialLibrary(reagent, i, 8));
            result = Items.searchMaterialLibrary(reagent, (i + 1), 1);
            shapelessRecipes.add(new CustomShapelessRecipe(new ArrayList(craftingGrid), result));
            craftingGrid.clear();
        }
        // Load all dismantle recipes for the reagent
        for (Integer i = 2; i < 6; i++) {
            craftingGrid.add(Items.searchMaterialLibrary(reagent, i, 1));
            result = Items.searchMaterialLibrary(reagent, i - 1, 4);
            shapelessRecipes.add(new CustomShapelessRecipe(new ArrayList(craftingGrid), result));
            craftingGrid.clear();
        }
    }
}
