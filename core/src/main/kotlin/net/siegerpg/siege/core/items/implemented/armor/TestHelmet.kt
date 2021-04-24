package net.siegerpg.siege.core.items.implemented.armor

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestHelmet() : CustomHelmet(
    name = "Test Helmet",
    customModelData = 1,
    description = listOf("A helmet for testing"),
    levelRequirement = 0,
    material = Material.DIAMOND_HELMET,
    recipeList = recipes {

    },
    baseStats = CustomItemUtils.statMap(strength = 10.0)
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}