package net.siegerpg.siege.core.items.implemented.misc.statgems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PolishedToughGem() : StatGemType(
    name = "Polished Tough Gem",
    customModelData = 550004,
    description = listOf("Energy primed for use!"),
    levelRequirement = 36,
    material = Material.POPPED_CHORUS_FRUIT,
    recipeList = recipes {

    },
    statType = StatTypes.TOUGHNESS,
    statAmount = 70.0
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