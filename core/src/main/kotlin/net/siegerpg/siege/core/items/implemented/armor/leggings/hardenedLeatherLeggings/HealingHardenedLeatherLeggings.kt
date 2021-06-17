package net.siegerpg.siege.core.items.implemented.armor.leggings.hardenedLeatherLeggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingHardenedLeatherLeggings() : CustomLeggings(
    name = "Healing Hardened Leather Leggings",
    customModelData = 1,
    description = listOf("Leather but erect"),
    levelRequirement = 18,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 15.0, regeneration = 9.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s2(Leather.tier(2))
            s3(Leather.tier(2))
            s4(Wheat.tier(2))
            s6(Wheat.tier(2))
            s7(Wheat.tier(2))
            s9(Wheat.tier(2))
            item { player, b ->
                val newItem = HealingHardenedLeatherLeggings(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    }
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