package net.siegerpg.siege.core.items.implemented.misc.statgems.toughGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class PristineToughGem() : StatGemType(
    name = "Pristine Tough Gem",
    customModelData = 560004,
    description = listOf("Power radiates from the core of this gem"),
    levelRequirement = 35,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.TOUGHNESS,
    statAmount = 50.0
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