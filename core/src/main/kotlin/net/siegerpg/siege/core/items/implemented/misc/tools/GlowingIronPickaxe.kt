package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class GlowingIronPickaxe() : CustomTool(
    name = "Glowing Iron Pickaxe",
    customModelData = 410008,
    description = listOf("Enchanted industrial tools"),
    levelRequirement = 27,
    material = Material.IRON_PICKAXE,
    baseStats = CustomItemUtils.statMap(),
    
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