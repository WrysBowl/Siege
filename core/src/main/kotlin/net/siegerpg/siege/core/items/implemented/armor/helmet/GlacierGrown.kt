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

class GlacierGrown() : CustomHelmet(
    name = "Glacier Crown",
    customModelData = 1,
    description = listOf("Ice Queen"),
    levelRequirement = 54,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 110.0, regeneration = 20.0, strength = 15.0, luck = -15.0, toughness = -80.0),
    leatherColor = Color.AQUA
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