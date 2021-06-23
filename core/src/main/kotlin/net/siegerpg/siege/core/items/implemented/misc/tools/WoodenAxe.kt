package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class WoodenAxe() : CustomTool(
    name = "Wooden Axe",
    customModelData = 420001,
    description = listOf("Your basic axe"),
    levelRequirement = 0,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(),
    recipeList = recipes {

    },
    enchantments = hashMapOf(
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