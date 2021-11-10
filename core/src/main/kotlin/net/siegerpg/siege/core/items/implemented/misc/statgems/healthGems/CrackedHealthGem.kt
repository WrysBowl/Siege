package net.siegerpg.siege.core.items.implemented.misc.statgems.healthGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CrackedHealthGem() : StatGemType(
    name = "Cracked Health Gem",
    customModelData = 520001,
    description = listOf("Most of it's power has been leaked"),
    levelRequirement = 8,
    material = Material.POPPED_CHORUS_FRUIT,
    statType = StatTypes.HEALTH,
    statAmount = 10.0
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