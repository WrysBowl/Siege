package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class EarthernWand() : CustomWand(
    name = "Earthern Wand",
    customModelData = 140008,
    description = listOf("Life forces from earthern materials", "glow around this object"),
    levelRequirement = 28,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 28.0, luck = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s2(PlantMatter.tier(3))
            s4(Coal.tier(3))
            s5(Seed.tier(3))
            s6(Coal.tier(3))
            s8(Seed.tier(3))
            item { player, b ->
                val newItem = EarthernWand(if (b) 50 else Utils.randRarity())
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