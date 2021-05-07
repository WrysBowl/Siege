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

class FlamingHotTorch() : CustomWand(
    name = "Flaming Hot Torch",
    customModelData = 140007,
    description = listOf("This weapon was said to have the ability", "to generate mass amounts of electricity"),
    levelRequirement = 24,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 24.0, luck = 16.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma.tier(4))
            s4(Seed.tier(4))
            s7(Stick.tier(3))
            item { player, b ->
                val newItem = FlamingHotTorch(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s2(Magma.tier(4))
            s5(Seed.tier(4))
            s8(Stick.tier(3))
            item { player, b ->
                val newItem = FlamingHotTorch(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
        recipe {
            shaped = true
            s3(Magma.tier(4))
            s6(Seed.tier(4))
            s9(Stick.tier(3))
            item { player, b ->
                val newItem = FlamingHotTorch(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
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