package net.siegerpg.siege.core.items.implemented.weapons.melee.light.woodenSwords

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class StrongWoodenSword() : CustomMeleeWeapon(
    name = "Strong Wooden Sword",
    customModelData = 110007,
    description = listOf("A classic weapon in recruits"),
    levelRequirement = 25,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 32.0),
    
    attackSpeed = 1.6
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