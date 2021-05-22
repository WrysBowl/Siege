package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainHelmet() : CustomHelmet(
    name = "Chain Helmet",
    customModelData = 1,
    description = listOf("Dreadlocks"),
    levelRequirement = 29,
    material = Material.CHAINMAIL_HELMET,
    baseStats = CustomItemUtils.statMap(health = 60.0, toughness = 50.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Chain.tier(2))
            s2(Chain.tier(2))
            s3(Chain.tier(2))
            s4(Chain.tier(2))
            s6(Chain.tier(2))
            item { player, b ->
                val newItem = ChainHelmet(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Chain.tier(2))
            s5(Chain.tier(2))
            s6(Chain.tier(2))
            s7(Chain.tier(2))
            s9(Chain.tier(2))
            item { player, b ->
                val newItem = ChainHelmet(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
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