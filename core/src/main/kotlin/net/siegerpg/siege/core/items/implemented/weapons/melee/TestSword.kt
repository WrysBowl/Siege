package net.siegerpg.siege.core.items.implemented.weapons.melee

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class TestSword() : CustomMeleeWeapon(
    name = "Test Sword",
    customModelData = 1,
    description = listOf("A sword for testing"),
    levelRequirement = 0,
    material = Material.DIAMOND_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 1000.0, health = -50.0),
    attackSpeed = 1.7
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    @Suppress("unused")
    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}