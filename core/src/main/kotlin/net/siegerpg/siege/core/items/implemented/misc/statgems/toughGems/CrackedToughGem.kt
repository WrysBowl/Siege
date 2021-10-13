package net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CrackedToughGem() : StatGemType(
    name = "Cracked Tough Gem",
    customModelData = 520004,
    description = listOf("Most of it's power has been leaked"),
    levelRequirement = 12,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.TOUGHNESS,
    statAmount = 15.0
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