package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.mobs.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WoolBoots() : CustomBoots(
    name = "Wool Boots",
    customModelData = 1,
    description = listOf("Moccasins?"),
    levelRequirement = 8,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 10.0, toughness = 20.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Wool.tier(2))
            s3(Wool.tier(2))
            s4(Wool.tier(2))
            s6(Wool.tier(2))
            item { player, b ->
                val newItem = WoolBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Wool.tier(2))
            s6(Wool.tier(2))
            s7(Wool.tier(2))
            s9(Wool.tier(2))
            item { player, b ->
                val newItem = WoolBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    leatherColor = Color.WHITE
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