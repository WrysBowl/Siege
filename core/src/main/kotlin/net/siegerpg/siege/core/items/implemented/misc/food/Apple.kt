package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Apple() : CustomFood(
    name = "Apple",
    customModelData = 330003,
    description = listOf("Food to tame teachers"),
    levelRequirement = 0,
    material = Material.APPLE, //change this to cooked chicken later
    recipeList = recipes {
    },
    health = 10
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        this.deserialize()
    }

}