package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Coal
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Malice() : CustomWand(
    name = "Malice",
    customModelData = 140011,
    description = listOf("Cast your anger","as a spell"),
    levelRequirement = 42,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 60.0, health = -20.0),
    range = 32,
    red = 0,
    green = 0,
    blue = 0,
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