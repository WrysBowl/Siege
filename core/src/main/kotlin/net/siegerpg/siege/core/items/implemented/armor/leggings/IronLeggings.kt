package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronLeggings() : CustomLeggings(
    name = "Iron Leggings",
    customModelData = 1,
    description = listOf("Iron jenkins"),
    levelRequirement = 35,
    material = Material.IRON_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 100.0, regeneration = 10.0, strength = -8.0, luck = -7.0),
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