package net.siegerpg.siege.core.items.implemented.misc.cosmetics.common

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MotorcycleHelmet() : Cosmetic(
    name = "Motorcycle Helmet",
    customModelData = 710003,
    description = listOf(""),
    material = Material.KNOWLEDGE_BOOK,
    quality = 0
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