package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.warHammers

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyWarHammer() : CustomMeleeWeapon(
    name = "Healthy War Hammer",
    customModelData = 130007,
    description = listOf("Both ends have proven to be deadly"),
    levelRequirement = 27,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 45.0, health = 10.0),
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