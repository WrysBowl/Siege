package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Crossbow() : CustomBow(
    name = "Crossbow",
    customModelData = 0,
    description = listOf("The OG pistol"),
    levelRequirement = 26,
    material = Material.CROSSBOW, //This needs to be changed to a crossbow
    baseStats = CustomItemUtils.statMap(strength = 25.0, luck = 11.0),
    recipeList = recipes {
    },
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