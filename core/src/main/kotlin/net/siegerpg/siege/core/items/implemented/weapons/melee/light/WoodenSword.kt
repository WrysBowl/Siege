package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WoodenSword() : CustomMeleeWeapon(
    name = "Wooden Sword",
    customModelData = 110007,
    description = listOf("A classic weapon in recruits"),
    levelRequirement = 15,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 28.0),
    recipeList = recipes {

    },
    attackSpeed = 1.6
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