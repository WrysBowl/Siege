package net.siegerpg.siege.core.items.implemented.misc.statgems.regenerationGems

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.enums.StatTypes
import net.siegerpg.siege.core.items.types.misc.StatGemType
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class FlawedRegenerationGem() : StatGemType(
    name = "Flawed Regeneration Gem",
    customModelData = 530005,
    description = listOf("Defects over time has made this gem weak"),
    levelRequirement = 15,
    material = Material.POPPED_CHORUS_FRUIT,
    
    statType = StatTypes.REGENERATION,
    statAmount = 8.0
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