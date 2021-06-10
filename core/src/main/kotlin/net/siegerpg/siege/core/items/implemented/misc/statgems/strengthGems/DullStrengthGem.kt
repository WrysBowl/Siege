package net.siegerpg.siege.core.items.implemented.misc.statgems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class DullStrengthGem() : StatGemType(
    name = "Dull Strength Gem",
    customModelData = 530002,
    description = listOf("Years of wear has smothered it's energy"),
    levelRequirement = 20,
    material = Material.POPPED_CHORUS_FRUIT,
    recipeList = recipes {

    },
    statType = StatTypes.STRENGTH,
    statAmount = 5.0
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