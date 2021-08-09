package net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CursedBone() : CustomMaterial(
    name = "Cursed Bone",
    customModelData = 310014,
    description = listOf("A bone that produces","dark magic"),
    levelRequirement = 0,
    material = Material.FLINT,
    recipeList = recipes {
    }
) {

    constructor(quality: Int) : this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    constructor(item: ItemStack) : this() {
        this.item = item
        deserialize()
    }

    companion object {
        fun tier(tier: Int): Bone {
            val newItem = Bone(0)
            newItem.tier = tier
            return newItem
        }
    }

}