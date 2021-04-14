package net.siegerpg.siege.core.items.recipes

import net.siegerpg.siege.core.items.CustomItem
import net.siegerpg.siege.core.items.implemented.weapons.melee.TestSword
import org.bukkit.entity.Player

class CustomRecipe(var items: MutableList<CustomItem?>, var shaped: Boolean = true, var createItem: (Player, Boolean) -> CustomItem) {

    fun matches(matrix: List<CustomItem?>): Boolean {
        return if (shaped) {
            matrix == items
        } else {
            matrix.containsAll(items)
        }
    }

    constructor() : this(arrayOfNulls<CustomItem?>(9).toMutableList(), true, { p: Player, shaped: Boolean ->
        TestSword(5)
    })

    fun item(createItem: (Player, Boolean) -> CustomItem) {
        this.createItem = createItem
    }

    fun s1(item: CustomItem?) {
        items[0] = item
    }

    fun s2(item: CustomItem?) {
        items[1] = item
    }

    fun s3(item: CustomItem?) {
        items[2] = item
    }

    fun s4(item: CustomItem?) {
        items[3] = item
    }

    fun s5(item: CustomItem?) {
        items[4] = item
    }

    fun s6(item: CustomItem?) {
        items[5] = item
    }

    fun s7(item: CustomItem?) {
        items[6] = item
    }

    fun s8(item: CustomItem?) {
        items[7] = item
    }

    fun s9(item: CustomItem?) {
        items[8] = item
    }

    companion object {
        // This string is the qualified class name of the custom item, so that it can be easily initialized.
        var recipes: MutableList<CustomRecipe> = mutableListOf()

        fun registerRecipe(recipe: CustomRecipe) {
            recipes.add(recipe)
        }

        fun getRecipe(matrix: List<CustomItem?>): CustomRecipe? {
            return recipes.firstOrNull {
                it.matches(matrix)
            }
        }
    }

}
