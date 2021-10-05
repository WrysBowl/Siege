package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomKey
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class SpiritKey() : CustomKey(
    name = "Spirit Key",
    customModelData = 630008,
    description = listOf("High chance of a","legendary cosmetic"),
    material = Material.TRIPWIRE_HOOK,
    baseStats = CustomItemUtils.statMap()
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