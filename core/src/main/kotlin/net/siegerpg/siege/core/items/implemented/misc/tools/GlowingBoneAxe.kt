package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class GlowingBoneAxe() : CustomTool(
    name = "Glowing Bone Axe",
    customModelData = 430004,
    description = listOf("Special caveman tools"),
    levelRequirement = 12,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(luck = 10.0),
    recipeList = recipes {

    },
    enchantments = hashMapOf(
        Enchantment.DIG_SPEED to 1
    )
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