package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class EarthernStaff() : CustomWand(
    name = "Earthern Staff",
    customModelData = 140010,
    description = listOf("More powerful than it's", "puny wand counterpart"),
    levelRequirement = 37,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 35.0, luck = 12.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(PlantMatter.tier(4))
            s4(Coal.tier(4))
            s5(Seed.tier(4))
            s6(Coal.tier(4))
            s8(Seed.tier(4))
            item { player, b ->
                val newItem = EarthernStaff(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    range = 17,
    red = 0,
    green = 204,
    blue = 0,
    damageRadius = 2.0
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