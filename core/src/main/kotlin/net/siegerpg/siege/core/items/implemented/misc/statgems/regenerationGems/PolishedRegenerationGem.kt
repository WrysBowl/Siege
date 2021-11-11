package net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PolishedRegenerationGem() : StatGemType(
    name = "Polished Regeneration Gem",
    customModelData = 550005,
    description = listOf("Energy primed for use!"),
    levelRequirement = 26,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.REGENERATION,
    statAmount = 14.0
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