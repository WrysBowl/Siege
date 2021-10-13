package net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PristineRegenerationGem() : StatGemType(
    name = "Pristine Regeneration Gem",
    customModelData = 560005,
    description = listOf("Power radiates from the core of this gem"),
    levelRequirement = 44,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.REGENERATION,
    statAmount = 18.0
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