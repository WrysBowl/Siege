package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class DoubleBladedAxe() : CustomMeleeWeapon(
    name = "Double Bladed Axe",
    customModelData = 130005,
    description = listOf("You're really only going to use one side"),
    levelRequirement = 19,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 40.0),
    recipeList = recipes {
    },
    attackSpeed = 0.7
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