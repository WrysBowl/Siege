package net.siegerpg.siege.core.items.implemented.misc.cosmetics.epic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CarrotOnAStick() : Cosmetic(
    name = "Carrot on a Stick",
    customModelData = 740001,
    description = listOf(""),
    material = Material.KNOWLEDGE_BOOK,
) {
    constructor(quality: Int): this() {
        this.quality = 90
        this.rarity = Rarity.EPIC
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}