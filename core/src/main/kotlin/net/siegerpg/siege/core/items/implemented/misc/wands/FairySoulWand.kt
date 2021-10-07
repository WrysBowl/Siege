package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomWand
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FairySoulWand() : CustomWand(
    name = "Fairy Soul Wand",
    customModelData = 140013,
    description = listOf("Use the power","of fairy souls"),
    levelRequirement = 52,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 50.0, toughness = -300.0, luck = 60.0),
    range = 22,
    red = 190,
    green = 242,
    blue = 85,
    damageRadius = 2.0
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