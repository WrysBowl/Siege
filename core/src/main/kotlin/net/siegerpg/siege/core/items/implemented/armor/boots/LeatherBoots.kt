package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LeatherBoots() : CustomBoots(
    name = "Hardened Leather Boots",
    customModelData = 1,
    description = listOf("Bootleg spurs!"),
    levelRequirement = 17,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 15.0, toughness = 20.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s3(Leather.tier(2))
            s4(Leather.tier(2))
            s6(Leather.tier(2))
            item { player, b ->
                val newItem = LeatherBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Leather.tier(2))
            s6(Leather.tier(2))
            s7(Leather.tier(2))
            s9(Leather.tier(2))
            item { player, b ->
                val newItem = LeatherBoots(if (b) 50 else Utils.randRarity())
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