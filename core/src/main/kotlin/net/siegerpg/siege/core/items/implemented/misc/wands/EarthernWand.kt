package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.implemented.misc.materials.mobDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class EarthernWand() : CustomWand(
    name = "Earthern Wand",
    customModelData = 140008,
    description = listOf("Life forces from earthern materials glow around this object"),
    levelRequirement = 28,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 28.0, luck = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(PlantMatter(0)) //tier 3
            s4(Coal(0)) //tier 3
            s5(Seed(0)) //tier 3
            s6(Coal(0)) //tier 3
            s8(Seed(0)) //tier 3
            item { player, b ->
                EarthernWand(Utils.randRarity())
            }
        }
    },
    range = 14,
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