package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class SteelAxe() : CustomTool(
    name = "Steel Axe",
    customModelData = 430011,
    description = listOf("The better iron"),
    levelRequirement = 37,
    material = Material.IRON_AXE,
    baseStats = CustomItemUtils.statMap(),
    
    enchantments = hashMapOf(
        Enchantment.DIG_SPEED to 2
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