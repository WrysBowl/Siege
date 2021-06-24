package net.siegerpg.siege.core.items.implemented.misc.wands.rockWands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyRockWand() : CustomWand(
    name = "Healthy Rock Wand",
    customModelData = 140005,
    description = listOf("Nature made rocks to be weaponized"),
    levelRequirement = 15,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 17.0, luck = 3.0, health = 7.0),
    recipeList = recipes {
    },
    range = 19,
    red = 140,
    green = 140,
    blue = 140,
    damageRadius = 3.0
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