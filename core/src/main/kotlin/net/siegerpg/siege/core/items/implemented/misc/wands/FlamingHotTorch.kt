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

class FlamingHotTorch() : CustomWand(
    name = "Flaming Hot Torch",
    customModelData = 140007,
    description = listOf("This weapon was said to have the ability to generate mass amounts of electricity"),
    levelRequirement = 24,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 24.0, luck = 16.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma(0)) //tier 4
            s4(Seed(0)) //tier 4
            s7(Stick(0)) //tier 3
            item { player, b ->
                FlamingHotTorch(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Magma(0)) //tier 4
            s5(Seed(0)) //tier 4
            s8(Stick(0)) //tier 3
            item { player, b ->
                FlamingHotTorch(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Magma(0)) //tier 4
            s6(Seed(0)) //tier 4
            s9(Stick(0)) //tier 3
            item { player, b ->
                FlamingHotTorch(Utils.randRarity())
            }
        }
    },
    range = 16,
    red = 255,
    green = 0,
    blue = 0,
    damageRadius = 3.0
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