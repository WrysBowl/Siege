package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class GlowingTitaniumShovel() : CustomTool(
    name = "Glowing Titanium Shovel",
    customModelData = 420014,
    description = listOf("Enchanted titanium"),
    levelRequirement = 49,
    material = Material.IRON_SHOVEL,
    recipeList = recipes {

    },
    enchantments = hashMapOf(
        Enchantment.DIG_SPEED to 3
    )
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