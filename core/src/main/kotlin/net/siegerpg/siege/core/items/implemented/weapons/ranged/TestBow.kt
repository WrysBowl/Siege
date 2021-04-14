package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestBow() : CustomBow(
    name = "Test Bow",
    customModelData = 1,
    description = listOf("A bow for testing"),
    levelRequirement = 0,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 20.0),
    recipeList = recipes {

    }
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