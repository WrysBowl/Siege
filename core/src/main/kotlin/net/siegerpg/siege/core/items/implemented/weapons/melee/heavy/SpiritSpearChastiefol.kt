package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SpiritSpearChastiefol() : CustomMeleeWeapon(
    name = "Spirit Spear Chastiefol",
    customModelData = 130013,
    description = listOf("Do ya get","the reference?"),
    levelRequirement = 54,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 90.0, health = 20.0, toughness = -80.0, luck = -15.0),
    attackSpeed = 0.9
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