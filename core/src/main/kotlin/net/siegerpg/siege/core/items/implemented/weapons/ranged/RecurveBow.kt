package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RecurveBow() : CustomBow(
    name = "Recurve Bow",
    customModelData = 0,
    description = listOf("Slight curves at the ends", "give the bow a bit more power"),
    levelRequirement = 30,
    material = Material.BOW, //This needs to be changed to a crossbow
    baseStats = CustomItemUtils.statMap(strength = 24.0, luck = 13.0),
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