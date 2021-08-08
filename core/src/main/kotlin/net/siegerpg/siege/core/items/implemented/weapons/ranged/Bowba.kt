package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Bowba() : CustomBow(
    name = "Bowba",
    customModelData = 120010,
    description = listOf("You put bowba in your drink", "Bowba will get ruined"),
    levelRequirement = 38,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 60.0, luck = 13.0)
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