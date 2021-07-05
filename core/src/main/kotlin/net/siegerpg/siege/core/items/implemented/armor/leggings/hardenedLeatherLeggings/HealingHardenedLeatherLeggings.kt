package net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingHardenedLeatherLeggings() : CustomLeggings(
    name = "Healing Hardened Leather Leggings",
    customModelData = 1,
    description = listOf("Leather but erect"),
    levelRequirement = 18,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 15.0, regeneration = 9.0),
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