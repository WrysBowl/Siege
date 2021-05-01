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

class Torch() : CustomWand(
    name = "Torch",
    customModelData = 140006,
    description = listOf("Ancient magic of the ancestors"),
    levelRequirement = 19,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 22.0, luck = 10.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma.tier(3))
            s4(Stick.tier(3))
            s7(Stick.tier(3))
            item { player, b ->
                Torch(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Magma.tier(3))
            s5(Stick.tier(3))
            s8(Stick.tier(3))
            item { player, b ->
                Torch(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Magma.tier(3))
            s6(Stick.tier(3))
            s9(Stick.tier(3))
            item { player, b ->
                Torch(Utils.randRarity())
            }
        }
    },
    range = 16,
    red = 255,
    green = 153,
    blue = 51,
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