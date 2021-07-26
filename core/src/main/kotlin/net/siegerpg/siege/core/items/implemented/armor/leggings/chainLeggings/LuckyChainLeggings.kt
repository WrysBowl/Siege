package net.siegerpg.siege.core.items.implemented.armor.leggings.chainLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyChainLeggings() : CustomLeggings(
    name = "Lucky Chain Leggings",
    customModelData = 1,
    description = listOf("Flimsy legs"),
    levelRequirement = 30,
    material = Material.CHAINMAIL_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 50.0, luck = 12.0, regeneration = 5.0),
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