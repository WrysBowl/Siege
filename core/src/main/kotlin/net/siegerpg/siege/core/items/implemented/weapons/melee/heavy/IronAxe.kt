package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronAxe() : CustomMeleeWeapon(
    name = "Iron Axe",
    customModelData = 130008,
    description = listOf("A fast tree cutter"),
    levelRequirement = 31,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 40.0),
    attackSpeed = 1.0
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