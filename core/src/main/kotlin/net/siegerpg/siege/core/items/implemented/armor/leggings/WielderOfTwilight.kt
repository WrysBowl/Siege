package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WielderOfTwilight() : CustomLeggings(
    name = "Wielder Of Twilight",
    customModelData = 1,
    description = listOf("Harness the","world's power"),
    levelRequirement = 60,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(strength = 70.0, regeneration = 40.0, luck = 30.0, health = -80.0, toughness = -100.0),
    leatherColor = Color.SILVER
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