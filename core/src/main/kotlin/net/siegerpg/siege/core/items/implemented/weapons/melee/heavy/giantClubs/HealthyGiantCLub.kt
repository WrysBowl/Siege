package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyGiantCLub() : CustomMeleeWeapon(
    name = "Healthy Giant Club",
    customModelData = 130002,
    description = listOf("Kneecap smasher"),
    levelRequirement = 7,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 14.0, health = 6.0),
    recipeList = recipes {
    },
    attackSpeed = 0.7
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