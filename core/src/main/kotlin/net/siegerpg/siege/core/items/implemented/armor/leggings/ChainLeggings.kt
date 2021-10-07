package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainLeggings() : CustomLeggings(
    name = "Chain Leggings",
    customModelData = 1,
    description = listOf("Flimsy legs"),
    levelRequirement = 30,
    material = Material.CHAINMAIL_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 60.0, toughness = 25.0, regeneration = 25.0),
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