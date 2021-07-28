package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class TitaniumRod() : CustomTool(
    name = "Titanium Rod",
    customModelData = 440006,
    description = listOf("The strongest alloy known to man"),
    levelRequirement = 28,
    material = Material.FISHING_ROD,
    baseStats = CustomItemUtils.statMap(),
    enchantments = hashMapOf(
        Enchantment.LURE to 3,
        Enchantment.LUCK to 2,
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