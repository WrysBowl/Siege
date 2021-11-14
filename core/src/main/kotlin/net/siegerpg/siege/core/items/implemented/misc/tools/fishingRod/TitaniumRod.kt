package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.fishing.droptables.OldFishTable
import net.siegerpg.siege.core.fishing.droptables.TitaniumFishTable
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomRod
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class TitaniumRod() : CustomRod(
    name = "Titanium Rod",
    customModelData = 440006,
    description = listOf("The strongest alloy known to man"),
    levelRequirement = 28,
    material = Material.FISHING_ROD,
    baseStats = CustomItemUtils.statMap(),
    enchantments = hashMapOf(
        Enchantment.LURE to 3,
        ),
    fishDropTable = TitaniumFishTable()
) {

    constructor(quality: Int): this() {
        this.quality = 70
        this.rarity = Rarity.RARE
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}