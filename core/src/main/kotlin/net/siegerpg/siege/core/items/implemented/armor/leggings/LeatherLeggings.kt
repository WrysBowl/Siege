package net.siegerpg.siege.core.items.implemented.armor.leggings

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobs.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomLeggings
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LeatherLeggings() : CustomLeggings(
    name = "Hardened Leather Leggings",
    customModelData = 1,
    description = listOf("Leather but erect"),
    levelRequirement = 18,
    material = Material.LEATHER_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 20.0, toughness = 70.0, regeneration = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s2(Leather.tier(2))
            s3(Leather.tier(2))
            s4(Leather.tier(2))
            s6(Leather.tier(2))
            s7(Leather.tier(2))
            s9(Leather.tier(2))
            item { player, b ->
                val newItem = LeatherLeggings(if (b) 50 else Utils.randRarity())
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