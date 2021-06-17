package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class GlowingTwig() : CustomWand(
    name = "Glowing Twig",
    customModelData = 140003,
    description = listOf("A twig from the spirit world"),
    levelRequirement = 8,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 10.0, luck = 8.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(PlantMatter.tier(3))
            s4(PlantMatter.tier(3))
            s7(PlantMatter.tier(3))
            item { player, b ->
                val newItem = GlowingTwig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(PlantMatter.tier(3))
            s5(PlantMatter.tier(3))
            s8(PlantMatter.tier(3))
            item { player, b ->
                val newItem = GlowingTwig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(PlantMatter.tier(3))
            s6(PlantMatter.tier(3))
            s9(PlantMatter.tier(3))
            item { player, b ->
                val newItem = GlowingTwig(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    range = 12,
    red = 255,
    green = 255,
    blue = 153,
    damageRadius = 2.5
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