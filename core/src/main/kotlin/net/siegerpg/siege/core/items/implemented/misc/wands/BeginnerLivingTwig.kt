package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class BeginnerLivingTwig() : CustomWand(
    name = "Beginner Living Twig",
    customModelData = 140001,
    description = listOf("Try out this wand!"),
    levelRequirement = 0,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 2.0, luck = 2.0),
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