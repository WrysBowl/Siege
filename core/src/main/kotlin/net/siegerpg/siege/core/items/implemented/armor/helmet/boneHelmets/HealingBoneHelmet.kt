package net.siegerpg.siege.core.items.implemented.armor.helmet.boneHelmets

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Wheat
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingBoneHelmet() : CustomHelmet(
    name = "Healing Bone Helmet",
    customModelData = 1,
    description = listOf("A second skull"),
    levelRequirement = 23,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 16.0, toughness = 20.0, regeneration = 3.0),
    leatherColor = Color.GRAY
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