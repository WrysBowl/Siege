package net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PolishedHealthGem() : StatGemType(
    name = "Polished Health Gem",
    customModelData = 550001,
    description = listOf("Energy primed for use!"),
    levelRequirement = 26,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.HEALTH,
    statAmount = 18.0
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