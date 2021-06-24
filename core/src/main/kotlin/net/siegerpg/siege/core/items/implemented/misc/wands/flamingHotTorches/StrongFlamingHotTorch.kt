package net.siegerpg.siege.core.items.implemented.misc.wands.flamingHotTorches

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Seed
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongFlamingHotTorch() : CustomWand(
    name = "Strong Flaming Hot Torch",
    customModelData = 140007,
    description = listOf("This weapon was said to have the ability", "to generate mass amounts of electricity"),
    levelRequirement = 24,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 26.0, luck = 12.0),
    recipeList = recipes {
    },
    range = 19,
    red = 255,
    green = 0,
    blue = 0,
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