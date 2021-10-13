package net.siegerpg.siege.core.items.implemented.misc.tools

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class GlowingTitaniumPickaxe() : CustomTool(
    name = "Glowing Titanium Pickaxe",
    customModelData = 410014,
    description = listOf("Enchanted titanium"),
    levelRequirement = 49,
    material = Material.IRON_PICKAXE,
    baseStats = CustomItemUtils.statMap(luck = 10.0),
    
    enchantments = hashMapOf(
        Enchantment.DIG_SPEED to 3
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