package net.siegerpg.siege.core.items.implemented.misc.tools.fishingRod

import net.siegerpg.siege.core.fishing.droptables.BoneFishTable
import net.siegerpg.siege.core.fishing.droptables.OldFishTable
import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomRod
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class BoneRod() : CustomRod(
    name = "Bone Rod",
    customModelData = 440003,
    description = listOf("Survival of the fittest"),
    levelRequirement = 15,
    material = Material.FISHING_ROD,
    baseStats = CustomItemUtils.statMap(),
    enchantments = hashMapOf(
        Enchantment.LURE to 1
    ),
    fishDropTable = BoneFishTable()
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