package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LivingTwig() : CustomWand(
    name = "Living Twig",
    customModelData = 140001,
    description = listOf("A faint amount of energy", "still exists in this twig"),
    levelRequirement = 4,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 4.0, luck = 4.0),
    range = 12,
    red = 204,
    green = 255,
    blue = 102,
    damageRadius = 2.5
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