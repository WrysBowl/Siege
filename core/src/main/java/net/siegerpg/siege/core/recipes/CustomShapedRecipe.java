package net.siegerpg.siege.core.recipes;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CustomShapedRecipe {

    private List<ItemStack> matrix;
    private ItemStack result;

    public CustomShapedRecipe(List<ItemStack> matrix, ItemStack result) {
        this.matrix = matrix;
        this.result = result;
    }

    public boolean doesFit(List<ItemStack> newMatrix) {
        for(int i = 0; i<matrix.size(); i++) {

            if (!matrix.get(i).equals(newMatrix.get(i))) {
                return false;
            }

        }
        return true;
    }

    public List<ItemStack> getMatrix() {
        return matrix;
    }

    public ItemStack getResult() {
        return result;
    }
}