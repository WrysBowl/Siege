package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomKey
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class UncommonKey() : CustomKey(
    name = "Uncommon Key",
    customModelData = 630002,
    description = listOf("Get an uncommon cosmetic"),
    material = Material.TRIPWIRE_HOOK,
    baseStats = CustomItemUtils.statMap()
) {

    constructor(quality: Int): this() {
        this.quality = 50
        this.rarity = Rarity.UNCOMMON
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}