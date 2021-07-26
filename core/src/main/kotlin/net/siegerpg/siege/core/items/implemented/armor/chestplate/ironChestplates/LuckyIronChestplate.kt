package net.siegerpg.siege.core.items.implemented.armor.chestplate.ironChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.RefinedMetal
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyIronChestplate() : CustomChestplate(
    name = "Lucky Iron Chestplate",
    customModelData = 1,
    description = listOf("Bullet proof"),
    levelRequirement = 35,
    material = Material.IRON_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 60.0, luck = 13.0),
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