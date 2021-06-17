package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class ExampleTool() : CustomTool(
    name = "Example Tool",
    customModelData = 1,
    description = listOf("An axe for testing"),
    levelRequirement = 0,
    material = Material.DIAMOND_AXE,
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