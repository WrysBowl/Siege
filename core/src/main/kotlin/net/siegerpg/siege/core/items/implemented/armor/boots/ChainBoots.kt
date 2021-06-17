package net.siegerpg.siege.core.items.implemented.armor.boots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Chain
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainBoots() : CustomBoots(
    name = "Chain Boots",
    customModelData = 1,
    description = listOf("Not the best foot wear"),
    levelRequirement = 29,
    material = Material.CHAINMAIL_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 40.0, toughness = 15.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Chain.tier(2))
            s3(Chain.tier(2))
            s4(Chain.tier(2))
            s6(Chain.tier(2))
            item { player, b ->
                val newItem = ChainBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s4(Chain.tier(2))
            s6(Chain.tier(2))
            s7(Chain.tier(2))
            s9(Chain.tier(2))
            item { player, b ->
                val newItem = ChainBoots(if (b) 50 else Utils.randRarity())
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