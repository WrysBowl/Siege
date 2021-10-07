package net.siegerpg.siege.core.items.implemented.misc.keys.hillyWoods

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomKey
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class MagmaSpiritKey() : CustomKey(
    name = "Magma Spirit Key",
    customModelData = 620003,
    description = listOf("Used to summon", "the Magma spirit"),
    material = Material.TRIPWIRE_HOOK,
    quality = 0
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