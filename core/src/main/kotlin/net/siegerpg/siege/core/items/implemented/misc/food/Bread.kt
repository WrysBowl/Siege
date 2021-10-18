package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect

class Bread() : CustomFood(
    name = "Bread",
    customModelData = 330009,
    description = listOf("Doughy"),
    levelRequirement = 0,
    material = Material.BREAD,
    health = 40.0,
) {

    constructor(quality: Int): this() {
        this.quality = 0
        this.rarity = Rarity.COMMON
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        this.deserialize()
    }

}