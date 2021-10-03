package net.siegerpg.siege.core.items.implemented.weapons.melee.light.spades

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughSpade() : CustomMeleeWeapon(
    name = "Tough Spade",
    customModelData = 110003,
    description = listOf("Not a shovel"),
    levelRequirement = 9,
    material = Material.WOODEN_SWORD,
    baseStats = CustomItemUtils.statMap(strength = 9.0, toughness = 40.0),
    attackSpeed = 1.5
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