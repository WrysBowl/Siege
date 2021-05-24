package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class WoolHelmet() : CustomHelmet(
    name = "Wool Helmet",
    customModelData = 1,
    description = listOf("Keep your ears warm"),
    levelRequirement = 8,
    material = Material.LEATHER_HELMET,
    baseStats = CustomItemUtils.statMap(health = 12.0, toughness = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Wool.tier(2))
            s2(Wool.tier(2))
            s3(Wool.tier(2))
            s4(Wool.tier(2))
            s6(Wool.tier(2))
            item { player, b ->
                val newItem = WoolHelmet(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Wool.tier(2))
            s5(Wool.tier(2))
            s6(Wool.tier(2))
            s7(Wool.tier(2))
            s9(Wool.tier(2))
            item { player, b ->
                val newItem = WoolHelmet(if (b) 50 else Utils.randRarity())
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