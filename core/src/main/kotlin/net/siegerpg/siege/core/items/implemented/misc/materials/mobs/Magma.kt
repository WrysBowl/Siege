package net.siegerpg.siege.core.items.implemented.misc.materials.mobs

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Magma() : CustomMaterial(
    name = "Magma",
    customModelData = 310002,
    description = listOf("Melted slime"),
    levelRequirement = 0,
    material = Material.FLINT,
    recipeList = recipes {
    }
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

    companion object {
        fun tier(tier: Int): Magma {
            val newItem = Magma(0)
            newItem.tier = tier
            return newItem
        }
    }
}