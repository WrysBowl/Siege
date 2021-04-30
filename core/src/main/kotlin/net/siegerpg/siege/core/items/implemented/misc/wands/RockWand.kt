package net.siegerpg.siege.core.items.implemented.misc.wands

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.misc.CustomWand
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class RockWand() : CustomWand(
    name = "Rock Wand",
    customModelData = 140005,
    description = listOf("Nature made rocks to be weaponized"),
    levelRequirement = 15,
    material = Material.WOODEN_HOE,
    baseStats = CustomItemUtils.statMap(strength = 20.0, luck = 6.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Pebble(0)) //tier 3
            s4(Stick(0)) //tier 3
            s7(Stick(0)) //tier 3
            item { player, b ->
                RockWand(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s2(Pebble(0)) //tier 3
            s5(Stick(0)) //tier 3
            s8(Stick(0)) //tier 3
            item { player, b ->
                RockWand(Utils.randRarity())
            }
        }
        recipe {
            shaped = true
            s3(Pebble(0)) //tier 3
            s6(Stick(0)) //tier 3
            s9(Stick(0)) //tier 3
            item { player, b ->
                RockWand(Utils.randRarity())
            }
        }
    },
    range = 16,
    red = 140,
    green = 140,
    blue = 140,
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