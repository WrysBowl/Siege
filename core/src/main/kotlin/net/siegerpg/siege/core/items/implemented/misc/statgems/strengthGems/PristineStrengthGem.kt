package net.siegerpg.siege.core.items.implemented.misc.statgems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PristineStrengthGem() : StatGemType(
    name = "Pristine Strength Gem",
    customModelData = 560002,
    description = listOf("Power radiates from the core of this gem"),
    levelRequirement = 44,
    material = Material.POPPED_CHORUS_FRUIT,
    recipeList = recipes {

    },
    statType = StatTypes.STRENGTH,
    statAmount = 8.0
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

}