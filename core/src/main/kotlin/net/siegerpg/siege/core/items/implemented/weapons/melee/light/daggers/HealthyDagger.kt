package net.siegerpg.siege.core.items.implemented.weapons.melee.light.daggers

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyDagger() : CustomMeleeWeapon(
    name = "Healthy Shank",
    customModelData = 110006,
    description = listOf("The prison shank's big brother"),
    levelRequirement = 20,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 19.0, health = 9.0),
    recipeList = recipes {

    },
    attackSpeed = 1.7
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