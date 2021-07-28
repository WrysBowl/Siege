package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class MetalRod() : CustomTool(
    name = "Metal Rod",
    customModelData = 440004,
    description = listOf("Made of scrap metal"),
    levelRequirement = 18,
    material = Material.FISHING_ROD,
    baseStats = CustomItemUtils.statMap(),
    enchantments = hashMapOf(
        Enchantment.LURE to 2,
        Enchantment.LUCK to 1
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