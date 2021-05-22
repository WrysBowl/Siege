package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ChainChestplate() : CustomChestplate(
    name = "Chain Chestplate",
    customModelData = 1,
    description = listOf("Cut resistant"),
    levelRequirement = 30,
    material = Material.CHAINMAIL_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 80.0, toughness = 100.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Chain.tier(2))
            s3(Chain.tier(2))
            s4(Chain.tier(2))
            s5(Chain.tier(2))
            s6(Chain.tier(2))
            s7(Chain.tier(2))
            s8(Chain.tier(2))
            s9(Chain.tier(2))
            item { player, b ->
                val newItem = ChainChestplate(if (b) 50 else Utils.randRarity())
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