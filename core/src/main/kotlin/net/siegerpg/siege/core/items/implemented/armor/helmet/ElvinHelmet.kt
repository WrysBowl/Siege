package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ElvinHelmet() : CustomHelmet(
    name = "Elvin Helmet",
    customModelData = 1,
    description = listOf("Donned by elvin warriors"),
    levelRequirement = 44,
    material = Material.IRON_HELMET,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 50.0, luck = 15.0, regeneration = -10.0, strength = -10.0)
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