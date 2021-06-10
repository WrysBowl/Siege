package net.siegerpg.siege.core.items.implemented.misc.statgems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FlawedToughGem() : StatGemType(
    name = "Flawed Tough Gem",
    customModelData = 520004,
    description = listOf("Defects over time has made this gem weak"),
    levelRequirement = 12,
    material = Material.POPPED_CHORUS_FRUIT,
    recipeList = recipes {

    },
    statType = StatTypes.TOUGHNESS,
    statAmount = 40.0
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