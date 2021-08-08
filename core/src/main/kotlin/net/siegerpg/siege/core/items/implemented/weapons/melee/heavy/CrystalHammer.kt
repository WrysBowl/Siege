package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CrystalHammer() : CustomMeleeWeapon(
    name = "Crystal Hammer",
    customModelData = 130012,
    description = listOf("Smash with gems"),
    levelRequirement = 49,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 150.0, toughness = 50.0, regeneration = -30.0, luck = -25.0),
    attackSpeed = 0.5
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