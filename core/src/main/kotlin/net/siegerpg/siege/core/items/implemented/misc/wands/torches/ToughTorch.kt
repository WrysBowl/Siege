package net.siegerpg.siege.core.items.implemented.misc.wands.torches

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughTorch() : CustomWand(
    name = "Tough Torch",
    customModelData = 140006,
    description = listOf("Ancient magic of the ancestors"),
    levelRequirement = 19,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 18.0, luck = 6.0, toughness = 70.0),
    recipeList = recipes {
    },
    range = 19,
    red = 255,
    green = 153,
    blue = 51,
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