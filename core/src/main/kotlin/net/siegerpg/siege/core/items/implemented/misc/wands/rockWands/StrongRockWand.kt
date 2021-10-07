package net.siegerpg.siege.core.items.implemented.misc.wands.rockWands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongRockWand() : CustomWand(
    name = "Strong Rock Wand",
    customModelData = 140005,
    description = listOf("Nature made rocks to be weaponized"),
    levelRequirement = 15,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 24.0),
    
    range = 19,
    red = 140,
    green = 140,
    blue = 140,
    damageRadius = 2.0
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