package net.siegerpg.siege.core.items.implemented.misc.cosmetics

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.Cosmetic
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestingCosmetic2() : Cosmetic(
    name = "Wool Helmet",
    customModelData = 1,
    description = listOf("TESTING"),
    material = Material.LEATHER_HELMET,
    leatherColor = Color.WHITE,
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