package net.siegerpg.siege.core.items.implemented.misc.food

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomFood
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

class GoldenCarrot() : CustomFood(
    name = "Golden Carrot",
    customModelData = 330005,
    description = listOf("Mercy on your soul"),
    levelRequirement = 0,
    material = Material.GOLDEN_CARROT, //change this to cooked chicken later
    recipeList = recipes {
    },
    health = 80
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        this.deserialize()
    }

}