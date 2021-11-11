package net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RawToughGem() : StatGemType(
    name = "Raw Tough Gem",
    customModelData = 510004,
    description = listOf("A raw gem with untapped power"),
    levelRequirement = 4,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.TOUGHNESS,
    statAmount = 10.0
) {

    constructor(quality: Int): this() {
        this.quality = 0
        this.rarity = Rarity.COMMON
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}