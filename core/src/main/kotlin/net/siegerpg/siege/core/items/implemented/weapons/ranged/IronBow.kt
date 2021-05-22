package net.siegerpg.siege.core.items.implemented.weapons.ranged

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.RefinedMetal
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.Vine
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomBow
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronBow() : CustomBow(
    name = "Iron Bow",
    customModelData = 0,
    description = listOf("Heavy and durable"),
    levelRequirement = 34,
    material = Material.BOW,
    baseStats = CustomItemUtils.statMap(strength = 24.0, luck = 16.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(RefinedMetal.tier(3))
            s3(Vine.tier(3))
            s4(RefinedMetal.tier(3))
            s6(Vine.tier(3))
            s8(RefinedMetal.tier(3))
            s9(Vine.tier(3))
            item { player, b ->
                val newItem = IronBow(if (b) 50 else Utils.randRarity())
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