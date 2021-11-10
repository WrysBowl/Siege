package net.siegerpg.siege.core.items.implemented.misc.statgems.luckGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PolishedLuckGem() : StatGemType(
    name = "Polished Luck Gem",
    customModelData = 550003,
    description = listOf("Energy primed for use!"),
    levelRequirement = 26,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.LUCK,
    statAmount = 14.0
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