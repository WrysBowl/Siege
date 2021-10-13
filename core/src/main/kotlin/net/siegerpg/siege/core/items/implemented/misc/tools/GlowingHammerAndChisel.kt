package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class GlowingHammerAndChisel() : CustomTool(
    name = "Glowing Hammer and Chisel",
    customModelData = 410010,
    description = listOf("Breaks stones faster with higher luck"),
    levelRequirement = 33,
    material = Material.STONE_PICKAXE,
    baseStats = CustomItemUtils.statMap(luck = 30.0),
    
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